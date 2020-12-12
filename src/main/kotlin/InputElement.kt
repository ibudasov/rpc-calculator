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

    override fun toString(): String
    {
        return elementLiteral
    }
}