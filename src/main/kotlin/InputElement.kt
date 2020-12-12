import java.lang.Double.parseDouble

class InputElement(val elementLiteral: String) {
    fun isInteger(): Boolean {

        try {
            parseDouble(elementLiteral)
        } catch (e: NumberFormatException) {
            return false
        }

        return true
    }

    fun asInteger(): Double {
        return parseDouble(elementLiteral)
    }

    override fun toString(): String
    {
        return elementLiteral
    }
}