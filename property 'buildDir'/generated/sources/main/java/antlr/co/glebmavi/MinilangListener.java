// Generated from co\glebmavi\Minilang.g4 by ANTLR 4.10
package co.glebmavi;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link MinilangParser}.
 */
public interface MinilangListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link MinilangParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(MinilangParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link MinilangParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(MinilangParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link MinilangParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(MinilangParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MinilangParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(MinilangParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MinilangParser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterAssignment(MinilangParser.AssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link MinilangParser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitAssignment(MinilangParser.AssignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link MinilangParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void enterIfStatement(MinilangParser.IfStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MinilangParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void exitIfStatement(MinilangParser.IfStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MinilangParser#whileStatement}.
	 * @param ctx the parse tree
	 */
	void enterWhileStatement(MinilangParser.WhileStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MinilangParser#whileStatement}.
	 * @param ctx the parse tree
	 */
	void exitWhileStatement(MinilangParser.WhileStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MinilangParser#printStatement}.
	 * @param ctx the parse tree
	 */
	void enterPrintStatement(MinilangParser.PrintStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MinilangParser#printStatement}.
	 * @param ctx the parse tree
	 */
	void exitPrintStatement(MinilangParser.PrintStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MinilangParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(MinilangParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link MinilangParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(MinilangParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link MinilangParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(MinilangParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MinilangParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(MinilangParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MinilangParser#compOp}.
	 * @param ctx the parse tree
	 */
	void enterCompOp(MinilangParser.CompOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link MinilangParser#compOp}.
	 * @param ctx the parse tree
	 */
	void exitCompOp(MinilangParser.CompOpContext ctx);
}