package co.glebmavi

import org.antlr.v4.runtime.CharStreams
import org.antlr.v4.runtime.CommonTokenStream

fun main(args: Array<String>) {
    if (args.size != 1) {
        println("Usage: <program> <filename>")
        return
    }

    val fileName = args[0]
    val input = CharStreams.fromFileName(fileName)
    val lexer = MinilangLexer(input)
    val tokens = CommonTokenStream(lexer)
    val parser = MinilangParser(tokens)
    val tree = parser.program()

    val visitor = MinilangEvalVisitor()
    visitor.visit(tree)
}
