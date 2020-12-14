package Domain.Operation

import Domain.Stack

class OperationPlus : Operation {

    private var _operands: List<Double>

    init {
        _operands = listOf()
    }

    override fun operationLiteral(): String {
        return "+"
    }

    override fun addOperandAndKeepAddingUntilItFitsTheOperation(operand: Double): Boolean {
        _operands = listOf(operand).plus(_operands)

        return (_operands.count() < 2)
    }

    override fun performOperationAndAddResultToStack(stack: Stack): Stack {

        var resultOfTheOperation = 0.0

        _operands.forEach {
            resultOfTheOperation += it
        }

        stack.addNumberOnTopOfIt(resultOfTheOperation)

        return stack
    }
}