package Domain

class OperationMinus : Operation {

    private var _operands: List<Double>

    init {
        _operands = listOf()
    }

    override fun operationLiteral(): String {
        return "-"
    }

    override fun addOperandAndKeepAddingUntilItFitsTheOperation(operand: Double): Boolean {
        _operands = listOf(operand).plus(_operands)

        return (_operands.count() < 2)
    }

    override fun performOperationAndAddResultToStack(stack: Stack): Stack {
        stack.addNumberOnTopOfIt(
            _operands.first() - _operands.last()
        )

        return stack
    }
}