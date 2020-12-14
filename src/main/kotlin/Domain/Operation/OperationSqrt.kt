package Domain.Operation

import Domain.Stack
import kotlin.math.sqrt

class OperationSqrt : Operation {

    private var _operands: List<Double>

    init {
        _operands = listOf()
    }

    override fun operationLiteral(): String {
        return "sqrt"
    }

    override fun addOperandAndKeepAddingUntilItFitsTheOperation(operand: Double): Boolean {
        _operands = listOf(operand).plus(_operands)

        return (_operands.count() < 1)
    }

    override fun performOperationAndAddResultToStack(stack: Stack): Stack {

        var resultOfTheOperation = 0.0

        _operands.forEach {
            resultOfTheOperation = sqrt(it)
        }

        stack.addNumberOnTopOfIt(resultOfTheOperation)

        return stack
    }
}