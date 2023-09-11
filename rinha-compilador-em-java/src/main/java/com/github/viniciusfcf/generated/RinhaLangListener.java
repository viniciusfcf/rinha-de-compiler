// Generated from RinhaLang.g4 by ANTLR 4.13.1
package com.github.viniciusfcf.generated;

	import com.github.viniciusfcf.datastructures.IsiSymbol;
	import com.github.viniciusfcf.datastructures.IsiVariable;
	import com.github.viniciusfcf.datastructures.IsiSymbolTable;
	import com.github.viniciusfcf.exceptions.IsiSemanticException;
	import com.github.viniciusfcf.ast.IsiProgram;
	import com.github.viniciusfcf.ast.AbstractCommand;
	import com.github.viniciusfcf.ast.CommandLeitura;
	import com.github.viniciusfcf.ast.CommandEscrita;
	import com.github.viniciusfcf.ast.CommandAtribuicao;
	import com.github.viniciusfcf.ast.CommandDecisao;
	import java.util.ArrayList;
	import java.util.Stack;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link RinhaLangParser}.
 */
public interface RinhaLangListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link RinhaLangParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProg(RinhaLangParser.ProgContext ctx);
	/**
	 * Exit a parse tree produced by {@link RinhaLangParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProg(RinhaLangParser.ProgContext ctx);
	/**
	 * Enter a parse tree produced by {@link RinhaLangParser#decl}.
	 * @param ctx the parse tree
	 */
	void enterDecl(RinhaLangParser.DeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link RinhaLangParser#decl}.
	 * @param ctx the parse tree
	 */
	void exitDecl(RinhaLangParser.DeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link RinhaLangParser#declaravar}.
	 * @param ctx the parse tree
	 */
	void enterDeclaravar(RinhaLangParser.DeclaravarContext ctx);
	/**
	 * Exit a parse tree produced by {@link RinhaLangParser#declaravar}.
	 * @param ctx the parse tree
	 */
	void exitDeclaravar(RinhaLangParser.DeclaravarContext ctx);
	/**
	 * Enter a parse tree produced by {@link RinhaLangParser#tipo}.
	 * @param ctx the parse tree
	 */
	void enterTipo(RinhaLangParser.TipoContext ctx);
	/**
	 * Exit a parse tree produced by {@link RinhaLangParser#tipo}.
	 * @param ctx the parse tree
	 */
	void exitTipo(RinhaLangParser.TipoContext ctx);
	/**
	 * Enter a parse tree produced by {@link RinhaLangParser#bloco}.
	 * @param ctx the parse tree
	 */
	void enterBloco(RinhaLangParser.BlocoContext ctx);
	/**
	 * Exit a parse tree produced by {@link RinhaLangParser#bloco}.
	 * @param ctx the parse tree
	 */
	void exitBloco(RinhaLangParser.BlocoContext ctx);
	/**
	 * Enter a parse tree produced by {@link RinhaLangParser#cmd}.
	 * @param ctx the parse tree
	 */
	void enterCmd(RinhaLangParser.CmdContext ctx);
	/**
	 * Exit a parse tree produced by {@link RinhaLangParser#cmd}.
	 * @param ctx the parse tree
	 */
	void exitCmd(RinhaLangParser.CmdContext ctx);
	/**
	 * Enter a parse tree produced by {@link RinhaLangParser#cmdleitura}.
	 * @param ctx the parse tree
	 */
	void enterCmdleitura(RinhaLangParser.CmdleituraContext ctx);
	/**
	 * Exit a parse tree produced by {@link RinhaLangParser#cmdleitura}.
	 * @param ctx the parse tree
	 */
	void exitCmdleitura(RinhaLangParser.CmdleituraContext ctx);
	/**
	 * Enter a parse tree produced by {@link RinhaLangParser#cmdescrita}.
	 * @param ctx the parse tree
	 */
	void enterCmdescrita(RinhaLangParser.CmdescritaContext ctx);
	/**
	 * Exit a parse tree produced by {@link RinhaLangParser#cmdescrita}.
	 * @param ctx the parse tree
	 */
	void exitCmdescrita(RinhaLangParser.CmdescritaContext ctx);
	/**
	 * Enter a parse tree produced by {@link RinhaLangParser#cmdattrib}.
	 * @param ctx the parse tree
	 */
	void enterCmdattrib(RinhaLangParser.CmdattribContext ctx);
	/**
	 * Exit a parse tree produced by {@link RinhaLangParser#cmdattrib}.
	 * @param ctx the parse tree
	 */
	void exitCmdattrib(RinhaLangParser.CmdattribContext ctx);
	/**
	 * Enter a parse tree produced by {@link RinhaLangParser#cmdselecao}.
	 * @param ctx the parse tree
	 */
	void enterCmdselecao(RinhaLangParser.CmdselecaoContext ctx);
	/**
	 * Exit a parse tree produced by {@link RinhaLangParser#cmdselecao}.
	 * @param ctx the parse tree
	 */
	void exitCmdselecao(RinhaLangParser.CmdselecaoContext ctx);
	/**
	 * Enter a parse tree produced by {@link RinhaLangParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(RinhaLangParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link RinhaLangParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(RinhaLangParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link RinhaLangParser#termo}.
	 * @param ctx the parse tree
	 */
	void enterTermo(RinhaLangParser.TermoContext ctx);
	/**
	 * Exit a parse tree produced by {@link RinhaLangParser#termo}.
	 * @param ctx the parse tree
	 */
	void exitTermo(RinhaLangParser.TermoContext ctx);
}