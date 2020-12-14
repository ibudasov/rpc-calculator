package Domain

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
        if (_operands.count() == 0) {
            _operands = listOf(operand)
        }

        return false
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