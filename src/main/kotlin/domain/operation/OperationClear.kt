package domain.operation

import domain.StackOfOperands

class OperationClear : Operation {

    override fun operationLiteral(): String {
        return "clear"
    }

    override fun addOperandAndKeepAddingUntilItFitsTheOperation(operand: Double): Boolean {
        // no operands are being added for this operation, all we need we have in the stack already
        return false
    }

    override fun performOperationAndAddResultToStack(stackOfOperands: StackOfOperands): StackOfOperands {
        for (i in 1..stackOfOperands.size) {
            stackOfOperands.pop()
        }

        return stackOfOperands
    }
}