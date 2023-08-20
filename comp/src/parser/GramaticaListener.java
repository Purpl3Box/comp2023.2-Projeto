// Generated from Gramatica.g4 by ANTLR 4.13.0
package comp.src.parser;

    import comp.src.datastructures.*;
    import comp.src.ast.*;
    import java.util.ArrayList;
    import java.util.List;
    import java.util.Stack;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link GramaticaParser}.
 */
public interface GramaticaListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link GramaticaParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(GramaticaParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link GramaticaParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(GramaticaParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link GramaticaParser#declara}.
	 * @param ctx the parse tree
	 */
	void enterDeclara(GramaticaParser.DeclaraContext ctx);
	/**
	 * Exit a parse tree produced by {@link GramaticaParser#declara}.
	 * @param ctx the parse tree
	 */
	void exitDeclara(GramaticaParser.DeclaraContext ctx);
	/**
	 * Enter a parse tree produced by {@link GramaticaParser#declaracao}.
	 * @param ctx the parse tree
	 */
	void enterDeclaracao(GramaticaParser.DeclaracaoContext ctx);
	/**
	 * Exit a parse tree produced by {@link GramaticaParser#declaracao}.
	 * @param ctx the parse tree
	 */
	void exitDeclaracao(GramaticaParser.DeclaracaoContext ctx);
	/**
	 * Enter a parse tree produced by {@link GramaticaParser#bloco}.
	 * @param ctx the parse tree
	 */
	void enterBloco(GramaticaParser.BlocoContext ctx);
	/**
	 * Exit a parse tree produced by {@link GramaticaParser#bloco}.
	 * @param ctx the parse tree
	 */
	void exitBloco(GramaticaParser.BlocoContext ctx);
	/**
	 * Enter a parse tree produced by {@link GramaticaParser#cmd}.
	 * @param ctx the parse tree
	 */
	void enterCmd(GramaticaParser.CmdContext ctx);
	/**
	 * Exit a parse tree produced by {@link GramaticaParser#cmd}.
	 * @param ctx the parse tree
	 */
	void exitCmd(GramaticaParser.CmdContext ctx);
	/**
	 * Enter a parse tree produced by {@link GramaticaParser#cmdLeitura}.
	 * @param ctx the parse tree
	 */
	void enterCmdLeitura(GramaticaParser.CmdLeituraContext ctx);
	/**
	 * Exit a parse tree produced by {@link GramaticaParser#cmdLeitura}.
	 * @param ctx the parse tree
	 */
	void exitCmdLeitura(GramaticaParser.CmdLeituraContext ctx);
	/**
	 * Enter a parse tree produced by {@link GramaticaParser#cmdEscrita}.
	 * @param ctx the parse tree
	 */
	void enterCmdEscrita(GramaticaParser.CmdEscritaContext ctx);
	/**
	 * Exit a parse tree produced by {@link GramaticaParser#cmdEscrita}.
	 * @param ctx the parse tree
	 */
	void exitCmdEscrita(GramaticaParser.CmdEscritaContext ctx);
	/**
	 * Enter a parse tree produced by {@link GramaticaParser#cmdExpr}.
	 * @param ctx the parse tree
	 */
	void enterCmdExpr(GramaticaParser.CmdExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link GramaticaParser#cmdExpr}.
	 * @param ctx the parse tree
	 */
	void exitCmdExpr(GramaticaParser.CmdExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link GramaticaParser#cmdIf}.
	 * @param ctx the parse tree
	 */
	void enterCmdIf(GramaticaParser.CmdIfContext ctx);
	/**
	 * Exit a parse tree produced by {@link GramaticaParser#cmdIf}.
	 * @param ctx the parse tree
	 */
	void exitCmdIf(GramaticaParser.CmdIfContext ctx);
	/**
	 * Enter a parse tree produced by {@link GramaticaParser#cmdWhile}.
	 * @param ctx the parse tree
	 */
	void enterCmdWhile(GramaticaParser.CmdWhileContext ctx);
	/**
	 * Exit a parse tree produced by {@link GramaticaParser#cmdWhile}.
	 * @param ctx the parse tree
	 */
	void exitCmdWhile(GramaticaParser.CmdWhileContext ctx);
	/**
	 * Enter a parse tree produced by {@link GramaticaParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(GramaticaParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link GramaticaParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(GramaticaParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link GramaticaParser#termo}.
	 * @param ctx the parse tree
	 */
	void enterTermo(GramaticaParser.TermoContext ctx);
	/**
	 * Exit a parse tree produced by {@link GramaticaParser#termo}.
	 * @param ctx the parse tree
	 */
	void exitTermo(GramaticaParser.TermoContext ctx);
	/**
	 * Enter a parse tree produced by {@link GramaticaParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(GramaticaParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link GramaticaParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(GramaticaParser.TypeContext ctx);
}