package Domain

import Domain.Operation.OperationFactory

class Calculator {

    fun calculateThings(input: List<InputElement>): Stack {
        var stack = Stack()

        input.forEach {

            if (it.isNumber()) {
                stack.addNumberOnTopOfIt(it.asNumber())
            }

            if (it.isOperator()) {
                val operation = OperationFactory().createByLiteral(it.elementLiteral)

                // todo: process the lack of operands in the stack here

                while (operation.addOperandAndKeepAddingUntilItFitsTheOperation(
                        stack.getTheElementFromTheTopOfItAndRemoveItFromStack()
                    )
                ) {
                    // doing nothing here, what's needed to happen -- happened in the condition
                }

                stack = operation.performOperationAndAddResultToStack(stack)
            }

        }

        return stack
    }
}