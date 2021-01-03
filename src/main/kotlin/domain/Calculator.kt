package domain

import domain.operation.OperationFactory

class Calculator {

    fun calculateThings(input: List<InputElement>): Stack {
        var stack = Stack()
        val stackHistory = StackStateHistory()

        stackHistory.saveStackState(stack)

        input.forEach {

            if (it.isUndo()) {
                stack = stackHistory.getLastSavedStackStateAndRemoveItFromHistory()
            }

            if (it.isNumber()) {
                stack = stack.addNumberOnTopOfIt(it.asNumber())
                stackHistory.saveStackState(stack)

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
                stackHistory.saveStackState(stack)

            }

        }

        return stack
    }
}