package domain.operation

import domain.StackOfOperands

class OperationDiv : Operation {

    private var _operands: List<Double>

    init {
        _operands = listOf()
    }

    override fun operationLiteral(): String {
        return "/"
    }

    override fun addOperandAndKeepAddingUntilItFitsTheOperation(operand: Double): Boolean {
        _operands = listOf(operand).plus(_operands)

        return (_operands.count() < 2)
    }

    override fun performOperationAndAddResultToStack(stackOfOperands: StackOfOperands): StackOfOperands {

        if (_operands.last() == 0.0) {
            throw SorryDivisionByZeroIsNoGood()
        }

        stackOfOperands.push(
            _operands.first() / _operands.last()
        )

        return stackOfOperands
    }
}