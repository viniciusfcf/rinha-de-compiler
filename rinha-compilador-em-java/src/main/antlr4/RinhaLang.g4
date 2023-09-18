grammar RinhaLang;

@header{
	import com.github.viniciusfcf.datastructures.*;
	import com.github.viniciusfcf.exceptions.IsiSemanticException;
	import com.github.viniciusfcf.ast.*;
	import com.github.viniciusfcf.*;
	import java.util.ArrayList;
	import java.util.Stack;
}

@members{
	private int _tipo;
	private boolean containsElse = false;
	private boolean metodoInterno = false;
	private String _nomeFuncao;
	private String _varName;
	private String _varValue;
	private IsiProgram program = new IsiProgram();
	private ArrayList<AbstractCommand> curThread;
	private Stack<ArrayList<AbstractCommand>> stack = new Stack<ArrayList<AbstractCommand>>();
	private String _readID;
	private String _writeID;
	private Object _writeValue;
	private String _exprID;
	private String _exprContent;
	private String _exprDecision;
	private ArrayList<String> _parametros;
	private ArrayList<String> _parametrosCall;
	private ArrayList<AbstractCommand> listaTrue;
	private ArrayList<AbstractCommand> listaFalse;
	private ArrayList<IsiMethod> methods = new ArrayList<>();
	private String _tuplaContent1;
	private String _tuplaContent2;
	private String _tuplaExpr;
	
	
	public void exibeComandos(){
		for (AbstractCommand c: program.getComandos()){
			System.out.println(c);
		}
	}
	
	public void exibeMetodos() {
		for (IsiMethod m: program.getMetodos()) {
			System.out.println(m);
		}
	}
	
	public String generateCode(){
		return program.generateTarget();
	}
	
}

prog	: {curThread = new ArrayList<AbstractCommand>(); 
                      stack.push(curThread);}
           (cmd | funcao)+ 
           {  
           	  program.setComandos(stack.pop());
           	  program.setMetodos(methods);
           	 
           } 
		;
		
		
funcao      : {System.out.println("lendo Metodo"); metodoInterno = true;}LET ID{ 
	                  _nomeFuncao = _input.LT(-1).getText();} ATTR FN AP ID{
	                  _parametros = new ArrayList<>();
	                  _parametros.add(_input.LT(-1).getText());
	                  } (VIR ID{ 
	                  if(_parametros.contains(_input.LT(-1).getText())) {
	                  	throw new IsiSemanticException("Parâmetro " + _input.LT(-1).getText() +" já foi declarado");
	                  }
	                  _parametros.add(_input.LT(-1).getText());}
	                  
	                  )* FP NX {System.out.println("lendo Metodo NX");}
				ACH{
				System.out.println("lendo Metodo ACH");
					curThread = new ArrayList<AbstractCommand>(); 
                      stack.push(curThread);
                    } 
                    (cmd {System.out.println("Lendo comando no metodo "+_input.LT(-1).getText());})+ FCH SC{
                    	System.out.println("FINAL DO METODO "+_nomeFuncao);
                    	ArrayList<AbstractCommand> comandos = stack.pop();
                    	IsiMethod method = new IsiMethod(_nomeFuncao, _parametros, comandos);
                    	methods.add(method);
                    	metodoInterno = false;
                   	}
                   	
			;


cmd		:  
 		  cmdescrita {System.out.println("cmdescrita");}
 		|  cmdattrib {System.out.println("cmdattrib");}
 		|  cmdselecao  {System.out.println("cmdselecao");}
 		|  cmdcall  {System.out.println("cmdcall1 "+_input.LT(-1).getText());}
		;
		
			
expr		:  termo{System.out.println("Leu um termo "+_exprContent);} ( 
	             (OP | OPREL)  {System.out.println("Leu um termo1 "+_exprContent); _exprContent += _input.LT(-1).getText();System.out.println("Leu um termo2 "+_exprContent);}
	            termo
	            )*{System.out.println("Leu uma expressão "+_exprContent);}
			;
			
termo		: ID { 
	               _exprContent += _input.LT(-1).getText();
                 } 
            | 
              NUMBER
              {
              	_exprContent += _input.LT(-1).getText();
              }
            |
              tupla {
              	System.out.println("TERMO!!! "+_exprContent);
              	_exprContent += _tuplaExpr;
              	System.out.println("TERMO!!! "+_exprContent);
              }
			;


cmdcall	: ID { 
                     	  _nomeFuncao = _input.LT(-1).getText();
                     	  System.out.println("CMD CALL!! "+_nomeFuncao +" INTERNO? "+metodoInterno);
                        }  (AP ({_exprContent = "";}expr{
	                  _parametrosCall = new ArrayList<>();
	                  _parametrosCall.add(_exprContent);
	                  } (VIR {_exprContent = "";}expr{ 
	                  _parametrosCall.add(_exprContent);})*) FP)* {
              	CommandCall cmd = new CommandCall(_nomeFuncao, _parametrosCall, metodoInterno);
              	stack.peek().add(cmd);
              }   
		;

			
cmdescrita	: 'print' 
                 AP 
                 (ID { 
	                  _writeID = _input.LT(-1).getText();
	                   _writeValue = null;
                     } 
                    
                   |
                   NUMBER{
						_writeValue = Integer.valueOf(_input.LT(-1).getText());
						}
                   | 
                   STR{
						_writeValue = _input.LT(-1).getText();
						}
                   | 
                   BOL{
						_writeValue = Boolean.valueOf(_input.LT(-1).getText());
						}
                   | 
                   cmd{
						_writeValue = stack.peek().remove(stack.peek().size()-1).generateJavaCode().replace(';', ' ');
						}
                   | 
                   tupla{
                   		System.out.println("_tuplaExpr: "+_tuplaExpr);
						_writeValue = _tuplaExpr;
						}
					|
					expr {
						_writeValue = _exprContent;
					}
                   )
                 FP 
                 
               {
               		if(_writeValue != null) {
               			CommandEscrita cmd = new CommandEscrita(_writeValue);
               	  		stack.peek().add(cmd);
               		}else {
               			CommandEscrita cmd = new CommandEscrita(_writeID);
               	  		stack.peek().add(cmd);
               		}
               	  
               }
			;
			
cmdattrib	:  LET ID  {
	                  _varName = _input.LT(-1).getText();
                    } 
			  ATTR { _exprContent = ""; } 
               expr 
               SC
               {
               	 CommandAtribuicao cmd = new CommandAtribuicao(_varName, _exprContent);
               	 stack.peek().add(cmd);
               }
           ;
			
			
cmdselecao  :  'if'{
					containsElse = false;} AP
                    (ID | NUMBER | BOL)    { _exprDecision = _input.LT(-1).getText(); }
                    (OPREL { _exprDecision += _input.LT(-1).getText(); }
                    (ID | NUMBER | BOL){_exprDecision += _input.LT(-1).getText(); })? 
                    FP 
                    ACH 
                    { curThread = new ArrayList<AbstractCommand>(); 
                      stack.push(curThread);
                    }
                    (cmd)+ 
                    
                    FCH 
                    {
                       listaTrue = stack.pop();	
                    } 
                   ('else' 
                   	 ACH
                   	 {
                   	 	curThread = new ArrayList<AbstractCommand>();
                   	 	stack.push(curThread);
                   	 	containsElse = true;
                   	 } 
                   	(cmd)+ 
                   	FCH)?
                   	{
                   		if(containsElse) {
                   			listaFalse = stack.pop();
                   		}else {
                   			listaFalse = new ArrayList<>();
                   		}
                   		CommandDecisao cmd = new CommandDecisao(_exprDecision, listaTrue, listaFalse);
                   		stack.peek().add(cmd);
                   	}
                   
            ;

			
// TODO n ta do jeito que quero, mas ok
tupla   : AP (ID | NUMBER){_tuplaContent1 =_input.LT(-1).getText();} VIR (ID | NUMBER){_tuplaContent2 = _input.LT(-1).getText();} FP {_tuplaExpr = "new Tupla("+_tuplaContent1+","+ _tuplaContent2+")";}
		;
LET : 'let'
	;
AP	: '('
	;
	
FP	: ')'
	;

NX	: '=>'
	;	

FN	: 'fn'
	;
SC	: ';'
	;
	
OP	: '+' | '-' | '*' | '/'
	;
	
ATTR : '='
	 ;
	 
VIR  : ','
     ;
     
ACH  : '{'
     ;
     
FCH  : '}'
     ;
	 
	 
OPREL : '==' | '!=' | '<' | '<=' | '>' | '>=' | '||' | '&&'
      ;

BOL     : 'true' | 'false'
		;
ID	: [a-z] ([a-z] | [A-Z] | [0-9])*
	;
	
NUMBER	: [0-9]+ ('.' [0-9]+)?
		;
STR     : '"' ([a-z] | [A-Z] | [0-9]| [ ])* '"'
 		;
 		
		
WS	: (' ' | '\t' | '\n' | '\r') -> skip;