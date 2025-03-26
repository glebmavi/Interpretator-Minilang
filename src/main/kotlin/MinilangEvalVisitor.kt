package co.glebmavi

import org.antlr.v4.runtime.tree.TerminalNode

typealias intVal = Value.IntValue
typealias strVal = Value.StringValue
typealias doubleVal = Value.DoubleValue

class MinilangEvalVisitor : MinilangBaseVisitor<Value>() {

    // Таблица символов для хранения переменных.
    private val symbolTable = mutableMapOf<String, Value>()

    override fun visitProgram(ctx: MinilangParser.ProgramContext): Value? {
        ctx.statement().forEach { visit(it) }
        return null
    }

    override fun visitAssignment(ctx: MinilangParser.AssignmentContext): Value {
        val id = ctx.Identifier().text
        val value = visit(ctx.expression())
        symbolTable[id] = value ?: throw RuntimeException("Ошибка вычисления выражения для переменной: $id")
        return value
    }

    override fun visitPrintStatement(ctx: MinilangParser.PrintStatementContext): Value? {
        val value = visit(ctx.expression())
        println(value?.asString())
        return value
    }

    override fun visitIfStatement(ctx: MinilangParser.IfStatementContext): Value? {
        val condition = visit(ctx.expression())
        if (condition!!.asNumber() != 0.0) {
            return visit(ctx.block(0))
        } else if (ctx.block().size > 1) {
            return visit(ctx.block(1))
        }
        return null
    }

    override fun visitWhileStatement(ctx: MinilangParser.WhileStatementContext): Value? {
        while (visit(ctx.expression())!!.asNumber() != 0.0) {
            visit(ctx.block())
        }
        return null
    }

    override fun visitBlock(ctx: MinilangParser.BlockContext): Value? {
        var last: Value? = null
        ctx.statement().forEach { last = visit(it) }
        return last
    }

    override fun visitExpression(ctx: MinilangParser.ExpressionContext): Value? {
        when (ctx.childCount) {
            1 -> {
                // Одиночный токен: число, строковый литерал или идентификатор.
                val child = ctx.getChild(0)
                if (child is TerminalNode) {
                    return when (child.symbol.type) {
                        MinilangParser.Number -> intVal(child.text.toInt())
                        MinilangParser.StringLiteral -> {
                            // Удаляем кавычки.
                            strVal(child.text.substring(1, child.text.length - 1))
                        }
                        MinilangParser.Identifier -> {
                            val id = child.text
                            symbolTable[id] ?: throw RuntimeException("Неопределённая переменная: $id")
                        }
                        else -> throw RuntimeException("Неизвестный токен: ${child.text}")
                    }
                }
            }
            3 -> {
                // Либо скобки, либо бинарное выражение.
                if (ctx.getChild(0).text == "(" && ctx.getChild(2).text == ")") {
                    return visit(ctx.getChild(1))
                } else {
                    val left = visit(ctx.getChild(0))
                        ?: throw RuntimeException("Отсутствует левый операнд в выражении: ${ctx.text}")
                    val op = ctx.getChild(1).text
                    val right = visit(ctx.getChild(2))
                        ?: throw RuntimeException("Отсутствует правый операнд в выражении: ${ctx.text}")
                    return evaluateBinary(left, op, right)
                }
            }
            else -> {
                throw RuntimeException("Неподдерживаемое выражение: ${ctx.text}")
            }
        }
        return null
    }

    private fun evaluateBinary(left: Value, op: String, right: Value): Value {
        return when (op) {
            "+" -> {
                if (left is strVal || right is strVal) {
                    strVal(left.asString() + right.asString())
                } else if (left is doubleVal || right is doubleVal) {
                    doubleVal(left.asNumber() + right.asNumber())
                } else {
                    intVal((left.asNumber() + right.asNumber()).toInt())
                }
            }
            "-" -> {
                if (left is strVal || right is strVal)
                    throw RuntimeException("Вычитание не поддерживается для строк")
                else if (left is doubleVal || right is doubleVal)
                    doubleVal(left.asNumber() - right.asNumber())
                else
                    intVal((left.asNumber() - right.asNumber()).toInt())
            }
            "*" -> {
                if (left is strVal && right is intVal)
                    strVal(left.asString().repeat(right.value))
                else if (right is strVal && left is intVal)
                    strVal(right.asString().repeat(left.value))
                else if (left is strVal || right is strVal)
                    throw RuntimeException("Умножение не поддерживается для строк")
                else if (left is doubleVal || right is doubleVal)
                    doubleVal(left.asNumber() * right.asNumber())
                else
                    intVal((left.asNumber() * right.asNumber()).toInt())
            }
            "/" -> {
                if (left is strVal || right is strVal)
                    throw RuntimeException("Деление не поддерживается для строк")
                if (right.asNumber() == 0.0)
                    throw RuntimeException("Деление на ноль")
                else if (left is doubleVal || right is doubleVal)
                    doubleVal(left.asNumber() / right.asNumber())
                else
                    intVal((left.asNumber() / right.asNumber()).toInt())
            }
            "%" -> {
                if (left is strVal || right is strVal)
                    throw RuntimeException("Остаток от деления не поддерживается для строк")
                if (right.asNumber() == 0.0)
                    throw RuntimeException("Деление по модулю на ноль")
                else
                    intVal((left.asNumber() % right.asNumber()).toInt())
            }
            // Операторы сравнения.
            "<" -> intVal(if (left.asNumber() < right.asNumber()) 1 else 0)
            ">" -> intVal(if (left.asNumber() > right.asNumber()) 1 else 0)
            "<=" -> intVal(if (left.asNumber() <= right.asNumber()) 1 else 0)
            ">=" -> intVal(if (left.asNumber() >= right.asNumber()) 1 else 0)
            "==" -> {
                if (left is strVal && right is strVal) {
                    intVal(if (left.asString() == right.asString()) 1 else 0)
                } else {
                    intVal(if (left.asNumber() == right.asNumber()) 1 else 0)
                }
            }
            else -> throw RuntimeException("Неизвестный оператор: $op")
        }
    }
}
