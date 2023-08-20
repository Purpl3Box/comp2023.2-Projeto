// Generated from IsiLang.g4 by ANTLR 4.10.1
package comp.src.parser;

    import comp.src.datastructures.*;
    import comp.src.ast.*;
    import java.util.ArrayList;
    import java.util.List;
    import java.util.Stack;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link TypeCompParser}.
 */
public interface TypeCompListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link TypeCompParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(TypeCompParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link TypeCompParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(TypeCompParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link TypeCompParser#declaration}.
	 * @param ctx the parse tree
	 */
	void enterDeclaration(TypeCompParser.DeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link TypeCompParser#declaration}.
	 * @param ctx the parse tree
	 */
	void exitDeclaration(TypeCompParser.DeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link TypeCompParser#declarationStatement}.
	 * @param ctx the parse tree
	 */
	void enterDeclarationStatement(TypeCompParser.DeclarationStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link TypeCompParser#declarationStatement}.
	 * @param ctx the parse tree
	 */
	void exitDeclarationStatement(TypeCompParser.DeclarationStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link TypeCompParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(TypeCompParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link TypeCompParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(TypeCompParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link TypeCompParser#command}.
	 * @param ctx the parse tree
	 */
	void enterCommand(TypeCompParser.CommandContext ctx);
	/**
	 * Exit a parse tree produced by {@link TypeCompParser#command}.
	 * @param ctx the parse tree
	 */
	void exitCommand(TypeCompParser.CommandContext ctx);
	/**
	 * Enter a parse tree produced by {@link TypeCompParser#commandread}.
	 * @param ctx the parse tree
	 */
	void enterCommandread(TypeCompParser.CommandreadContext ctx);
	/**
	 * Exit a parse tree produced by {@link TypeCompParser#commandread}.
	 * @param ctx the parse tree
	 */
	void exitCommandread(TypeCompParser.CommandreadContext ctx);
	/**
	 * Enter a parse tree produced by {@link TypeCompParser#commandwrite}.
	 * @param ctx the parse tree
	 */
	void enterCommandwrite(TypeCompParser.CommandwriteContext ctx);
	/**
	 * Exit a parse tree produced by {@link TypeCompParser#commandwrite}.
	 * @param ctx the parse tree
	 */
	void exitCommandwrite(TypeCompParser.CommandwriteContext ctx);
	/**
	 * Enter a parse tree produced by {@link TypeCompParser#commandattrib}.
	 * @param ctx the parse tree
	 */
	void enterCommandattrib(TypeCompParser.CommandattribContext ctx);
	/**
	 * Exit a parse tree produced by {@link TypeCompParser#commandattrib}.
	 * @param ctx the parse tree
	 */
	void exitCommandattrib(TypeCompParser.CommandattribContext ctx);
	/**
	 * Enter a parse tree produced by {@link TypeCompParser#commandif}.
	 * @param ctx the parse tree
	 */
	void enterCommandif(TypeCompParser.CommandifContext ctx);
	/**
	 * Exit a parse tree produced by {@link TypeCompParser#commandif}.
	 * @param ctx the parse tree
	 */
	void exitCommandif(TypeCompParser.CommandifContext ctx);
	/**
	 * Enter a parse tree produced by {@link TypeCompParser#commandwhile}.
	 * @param ctx the parse tree
	 */
	void enterCommandwhile(TypeCompParser.CommandwhileContext ctx);
	/**
	 * Exit a parse tree produced by {@link TypeCompParser#commandwhile}.
	 * @param ctx the parse tree
	 */
	void exitCommandwhile(TypeCompParser.CommandwhileContext ctx);
	/**
	 * Enter a parse tree produced by {@link TypeCompParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(TypeCompParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link TypeCompParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(TypeCompParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link TypeCompParser#term}.
	 * @param ctx the parse tree
	 */
	void enterTerm(TypeCompParser.TermContext ctx);
	/**
	 * Exit a parse tree produced by {@link TypeCompParser#term}.
	 * @param ctx the parse tree
	 */
	void exitTerm(TypeCompParser.TermContext ctx);
	/**
	 * Enter a parse tree produced by {@link TypeCompParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(TypeCompParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link TypeCompParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(TypeCompParser.TypeContext ctx);
}