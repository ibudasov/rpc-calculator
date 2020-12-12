class Calculator {

    fun calculateThings(input: List<InputElement>): Stack {
        var stack = Stack()

        input.forEach {

            if (it.isNumber()) {
                stack.addNumberOnTopOfIt(it.asNumber())
            }

            if (it.isOperator()) {
                val operation = OperationFactory().createByLiteral(it.elementLiteral)

                while (operation.addOperandAndKeepAddingUntilItFitsTheOperation(
                        stack.getTheElementFromTheTopOfIt()
                    )
                ) {
                    // doing nothing here, what's needed happened in the condition
                }

                stack = operation.performOperationAndAddResultToStack(stack)
            }

        }

        return stack
    }
}