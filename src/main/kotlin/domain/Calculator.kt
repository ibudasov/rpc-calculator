package domain

import domain.operation.OperationFactory
import java.lang.IllegalStateException

class Calculator {

    fun calculateThings(input: List<InputElement>): Stack {
        var stack = Stack()
        val stackHistory = StackStateHistory()
        var positionOfTheCurrentElement = 0

        stackHistory.saveStackState(stack)

        input.forEach {

            positionOfTheCurrentElement++

            if (it.isUndo()) {
                stack = stackHistory.getLastSavedStackStateAndRemoveItFromHistory()
            }

            if (it.isNumber()) {
                stack = stack.addNumberOnTopOfIt(it.asNumber())
                stackHistory.saveStackState(stack)

            }

            if (it.isOperator()) {
                val operation = OperationFactory().createByLiteral(it.elementLiteral)

                try {
                    while (operation.addOperandAndKeepAddingUntilItFitsTheOperation(
                            stack.getTheElementFromTheTopOfItAndRemoveItFromStack()
                        )
                    ) {
                        // doing nothing here, what's needed to happen -- happened in the condition
                    }
                } catch (e: IllegalStateException) {
                    throw SorryCannotFindSufficientNumberOfParametersInTheStack(operation, positionOfTheCurrentElement)
                }

                stack = operation.performOperationAndAddResultToStack(stack)
                stackHistory.saveStackState(stack)

            }

        }

        return stack
    }
}