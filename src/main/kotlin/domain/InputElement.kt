package domain

import domain.operation.OperationFactory
import domain.operation.SorryCouldNotCreateOperatorByLiteral
import java.lang.Double.parseDouble

class InputElement(val elementLiteral: String) {
    fun isOperand(): Boolean {

        try {
            parseDouble(elementLiteral)
        } catch (e: NumberFormatException) {
            return false
        }

        return true
    }

    fun asOperand(): Double {
        return parseDouble(elementLiteral)
    }

    fun isOperator(): Boolean {
        return try {
            OperationFactory().createByLiteral(elementLiteral)
            true
        } catch (e: SorryCouldNotCreateOperatorByLiteral) {
            false
        }
    }

    fun isUndo(): Boolean {
        return elementLiteral == "undo"
    }

    override fun toString(): String {
        return elementLiteral
    }
}