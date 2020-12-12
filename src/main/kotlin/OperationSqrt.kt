import kotlin.math.sqrt

class OperationSqrt : Operation {

    private var _operands: List<InputElement>

    init {
        _operands = listOf()
    }

    override fun operationLiteral(): String {
        return "sqrt"
    }

    override fun addOperandAndKeepAddingUntilItFitsTheOperation(inputElement: InputElement): Boolean {
        if (_operands.count() == 1) {
            return false
        }

        if (inputElement.isNumber()) {
            _operands = listOf(inputElement)
        } else {
            throw Exception(inputElement.elementLiteral + " expected to be a number")
        }

        return false
    }

    override fun performOperationAndAddResultToStack(stack: Stack): Stack {

        var resultOfTheOperation = 0.0

        _operands.forEach {
            resultOfTheOperation = sqrt(it.asNumber())
        }

        stack.addResultOfOperation(resultOfTheOperation)

        return stack
    }
}