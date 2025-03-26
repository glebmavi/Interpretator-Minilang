package co.glebmavi

sealed class Value {
    abstract fun asNumber(): Double
    abstract fun asString(): String

    data class IntValue(val value: Int) : Value() {
        override fun asNumber() = value.toDouble()
        override fun asString() = value.toString()
    }

    data class DoubleValue(val value: Double) : Value() {
        override fun asNumber() = value
        override fun asString() = value.toString()
    }

    data class StringValue(val value: String) : Value() {
        override fun asNumber() = value.toDoubleOrNull() ?: 0.0
        override fun asString() = value
    }
}
