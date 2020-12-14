package Domain

class OperationFactory {
    fun createByLiteral(literal: String): Operation {
        if (literal == (OperationSqrt()).operationLiteral()) {
            return OperationSqrt()
        }

        if (literal == (OperationPlus()).operationLiteral()) {
            return OperationPlus()
        }

        throw SorryCouldNotCreateOperatorByLiteral()
    }
}