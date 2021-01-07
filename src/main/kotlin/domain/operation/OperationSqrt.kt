package domain.operation

import domain.StackOfOperands
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

    override fun performOperationAndAddResultToStack(stackOfOperands: StackOfOperands): StackOfOperands {
        stackOfOperands.push(
            sqrt(_operands.first())
        )

        return stackOfOperands
    }
}