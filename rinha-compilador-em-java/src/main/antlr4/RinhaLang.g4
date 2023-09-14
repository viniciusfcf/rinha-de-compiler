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
	private String _nomeFuncao;
	private String _varName;
	private String _varValue;
	private IsiSymbolTable symbolTable = new IsiSymbolTable();
	private IsiSymbol symbol;
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
	private ArrayList<AbstractCommand> listaTrue;
	private ArrayList<AbstractCommand> listaFalse;
	private ArrayList<IsiMethod> methods = new ArrayList<>();
	
	
	public void verificaID(String id){
		if (!symbolTable.exists(id)){
			throw new IsiSemanticException("Symbol "+id+" not declared");
		}
	}
	
	public void exibeComandos(){
		System.out.println("exibeComandos");
		for (AbstractCommand c: program.getComandos()){
			System.out.println(c);
		}
	}
	
	public void exibeMetodos() {
		System.out.println("exibeMetodos");
		for (IsiMethod m: program.getMetodos()) {
			System.out.println(m);
		}
	}
	
	public String generateCode(){
		return program.generateTarget();
	}
	
}

prog	: {System.out.println("inicializando programa");curThread = new ArrayList<AbstractCommand>(); 
                      stack.push(curThread);}
           (cmd | funcao)+ bloco
           {  System.out.println("FINALIZANDO programa "+stack.size());System.out.println("FINALIZANDO programa "+stack);program.setVarTable(symbolTable);
           	  program.setComandos(stack.pop());
           	  program.setMetodos(methods);
           	 
           } 
		;
		
		
funcao      : LET ID{ 
	                  _nomeFuncao = _input.LT(-1).getText();} ATTR FN AP ID{
	                  _parametros = new ArrayList<>();
	                  _parametros.add(_input.LT(-1).getText());
	                  } (VIR ID{ 
	                  if(_parametros.contains(_input.LT(-1).getText())) {
	                  	throw new IsiSemanticException("Parâmetro " + _input.LT(-1).getText() +" já foi declarado");
	                  }
	                  _parametros.add(_input.LT(-1).getText());}
	                  
	                  )* FP NX 
				ACH{
				
					curThread = new ArrayList<AbstractCommand>(); 
                      stack.push(curThread);
                    } 
                    (cmd)+ FCH SC{
                    	System.out.println("Li a funcao: "+_nomeFuncao+" "+_parametros);
                    	ArrayList<AbstractCommand> comandos = stack.pop();
                    	System.out.println("Comandos da funcao: "+ comandos);
                    	IsiMethod method = new IsiMethod(_nomeFuncao, _parametros, comandos);
                    	methods.add(method);
                    	System.out.println("stack ao final da funcao"+ stack.size());
                    	
                   	}
                   	
			;


           
tipo       : 'numero' { _tipo = IsiVariable.NUMBER;  }
           | 'texto'  { _tipo = IsiVariable.TEXT;  }
           ;
        
bloco	: { 
	        System.out.println("stack no inicio do bloco"+ stack.size());
          }
          (cmd)+
		;
		

cmd		:  cmdleitura  
 		|  cmdescrita 
 		|  cmdattrib
 		|  cmdselecao  
 		|  cmdcall  
		;
		
		
cmdcall	: ID { System.out.println("cmdcall");
                     	  _nomeFuncao = _input.LT(-1).getText();
                        }  AP (ID{
	                  _parametros = new ArrayList<>();
	                  _parametros.add(_input.LT(-1).getText());
	                  } (VIR ID{ 
	                  _parametros.add(_input.LT(-1).getText());})*) FP SC{
              	IsiVariable var = (IsiVariable)symbolTable.get(_readID);
              	CommandCall cmd = new CommandCall(_nomeFuncao, _parametros);
              	stack.peek().add(cmd);
              }   
		;

cmdleitura	: 'leia' AP
                     ID { verificaID(_input.LT(-1).getText());
                     	  _readID = _input.LT(-1).getText();
                        } 
                     FP 
                     SC 
                     
              {
              	IsiVariable var = (IsiVariable)symbolTable.get(_readID);
              	CommandLeitura cmd = new CommandLeitura(_readID, var);
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
                   tupla{
						_writeValue = new Tupla(1,2);
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
	                  System.out.println("===cmdattrib "+_varName);
                    } 
			  ATTR { _exprContent = ""; } 
               expr 
               SC
               {
               	System.out.println("Stack size: "+stack.size());
               	System.out.println("Stack: "+stack);
               	 CommandAtribuicao cmd = new CommandAtribuicao(_varName, _exprContent);
               	 stack.peek().add(cmd);
               }
           ;
			
			
cmdselecao  :  'if'{
					containsElse = false;} AP
                    (ID | NUMBER | BOL)    { _exprDecision = _input.LT(-1).getText(); }
                    (OPREL { _exprDecision += MyOPREL.valueOf(_input.LT(-1).getText()).getJavaRepresentation(); }
                    (ID | NUMBER | BOL){_exprDecision += _input.LT(-1).getText(); })? 
                    FP 
                    ACH 
                    { curThread = new ArrayList<AbstractCommand>(); 
                      stack.push(curThread);
                      System.out.println("stack no IF"+ stack.size());
                    }
                    (cmd)+ 
                    
                    FCH 
                    {
                       listaTrue = stack.pop();	
                    } 
                   ( ('else' 
                   	 ACH
                   	 {
                   	 	curThread = new ArrayList<AbstractCommand>();
                   	 	stack.push(curThread);
                   	 	containsElse = true;
                   	 } 
                   	(cmd+) 
                   	FCH)*
                   	{
                   		if(containsElse) {
                   			listaFalse = stack.pop();
                   		}else {
                   			listaFalse = new ArrayList<>();
                   		}
                   		CommandDecisao cmd = new CommandDecisao(_exprDecision, listaTrue, listaFalse);
                   		stack.peek().add(cmd);
                   		System.out.println("stack no Fim do IF"+ stack.size());
                   	}
                   )?
            ;
			
expr		:  termo ( 
	             OP  { _exprContent += _input.LT(-1).getText();}
	            termo
	            )*
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
              tupla
			;


			
// TODO n ta do jeito que quero, mas ok
tupla   : AP termo VIR termo FP
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
	 
	 
OPREL : 'Gt' | 'Lt' | 'Gte' | 'Lte' | 'Eq' | 'Neq'
      ;

BOL     : 'true' | 'false'
		;
ID	: [a-z] ([a-z] | [A-Z] | [0-9])*
	;
	
NUMBER	: [0-9]+ ('.' [0-9]+)?
		;
STR     : '"' ([a-z] | [A-Z] | [0-9])* '"'
 		;
 		
		
WS	: (' ' | '\t' | '\n' | '\r') -> skip;