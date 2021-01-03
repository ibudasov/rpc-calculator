package domain.operation

import domain.Stack

class OperationClear : Operation {

    private var _operands: List<Double>

    init {
        _operands = listOf()
    }

    override fun operationLiteral(): String {
        return "clear"
    }

    override fun addOperandAndKeepAddingUntilItFitsTheOperation(operand: Double): Boolean {
       // no operands are being added for this operation, all we need we have in the stack already
       return false
    }

    override fun performOperationAndAddResultToStack(stack: Stack): Stack {
        for (i in 1..stack.countElements()) {
            stack.getTheElementFromTheTopOfItAndRemoveItFromStack()
        }

        return stack
    }
}