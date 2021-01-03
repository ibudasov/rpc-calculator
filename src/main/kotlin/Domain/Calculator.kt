package Domain

import Domain.Operation.OperationFactory

class Calculator {

    fun calculateThings(input: List<InputElement>): Stack {
        var stack = Stack()
        val stackHistory = StackStateHistory()

        input.forEach {

            if (it.isUndo()) {
                return stackHistory.getLastSavedStackStateAndRemoveItFromHistory()
            }

            if (it.isNumber()) {
                stack = stack.addNumberOnTopOfIt(it.asNumber())
            }

            if (it.isOperator()) {
                val operation = OperationFactory().createByLiteral(it.elementLiteral)

                while (operation.addOperandAndKeepAddingUntilItFitsTheOperation(
                        stack.getTheElementFromTheTopOfItAndRemoveItFromStack()
                    )
                ) {
                    // doing nothing here, what's needed to happen -- happened in the condition
                }

                stack = operation.performOperationAndAddResultToStack(stack)
            }

            stackHistory.saveStackState(stack)
        }

        return stack
    }
}