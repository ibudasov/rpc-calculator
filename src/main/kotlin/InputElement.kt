import java.lang.Double.parseDouble

class InputElement(val elementLiteral: String) {
    fun isNumber(): Boolean {

        try {
            parseDouble(elementLiteral)
        } catch (e: NumberFormatException) {
            return false
        }

        return true
    }

    fun asNumber(): Double {
        return parseDouble(elementLiteral)
    }

    fun isOperator(): Boolean {
        if (elementLiteral == (OperationSqrt()).operationLiteral()) {
            return true
        }
        return false
    }

    override fun toString(): String {
        return elementLiteral
    }
}