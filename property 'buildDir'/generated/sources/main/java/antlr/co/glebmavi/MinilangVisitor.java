// Generated from co\glebmavi\Minilang.g4 by ANTLR 4.10
package co.glebmavi;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link MinilangParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface MinilangVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link MinilangParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(MinilangParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link MinilangParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(MinilangParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MinilangParser#assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignment(MinilangParser.AssignmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link MinilangParser#ifStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStatement(MinilangParser.IfStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MinilangParser#whileStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileStatement(MinilangParser.WhileStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MinilangParser#printStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrintStatement(MinilangParser.PrintStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MinilangParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(MinilangParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link MinilangParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(MinilangParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MinilangParser#compOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompOp(MinilangParser.CompOpContext ctx);
}