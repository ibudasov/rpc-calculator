package domain

import domain.operation.OperationFactory

class Calculator {

    fun calculate(input: List<InputElement>): Stack {
        var stack = Stack()
        val stackHistory = StackStateHistory()
        var positionOfTheCurrentElement = 0

        stackHistory.saveStackState(stack)

        input.forEach {

            positionOfTheCurrentElement++

            if (it.isUndo()) {
                stack = stackHistory.getLastSavedStackStateAndRemoveItFromHistory()
            }

            if (it.isOperand()) {
                stack = stack.push(it.asOperand())
                stackHistory.saveStackState(stack)
            }

            if (it.isOperator()) {
                val operation = OperationFactory().createByLiteral(it.elementLiteral)

                try {
                    while (operation.addOperandAndKeepAddingUntilItFitsTheOperation(
                            stack.pop()
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