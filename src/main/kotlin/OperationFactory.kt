class OperationFactory {
    fun createByLiteral(literal: String): Operation
    {
        if (literal == (OperationSqrt()).operationLiteral()) {
            return OperationSqrt()
        }

        throw SorryCouldNotCreateOperatorByLiteral()
    }
}