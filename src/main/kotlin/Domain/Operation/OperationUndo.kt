package Domain.Operation

import Domain.Stack

class OperationUndo : Operation {

    private var operands: List<Double>

    init {
        operands = listOf()
    }

    override fun operationLiteral(): String {
        return "undo"
    }

    override fun addOperandAndKeepAddingUntilItFitsTheOperation(operand: Double): Boolean {
        operands = listOf(operand).plus(operands)

        return (operands.count() < 1)
    }

    override fun performOperationAndAddResultToStack(stack: Stack): Stack {
        return stack
    }
}