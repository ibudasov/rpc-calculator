package domain

import domain.operation.OperationFactory
import java.util.*

class Calculator {

    fun calculate(input: List<InputElement>): StackOfOperands {
        var stack = StackOfOperands()
        val stackHistory = StackStateHistory()
        var positionOfTheCurrentElement = 0

        stackHistory.saveStackState(stack)

        input.forEach {

            positionOfTheCurrentElement++

            if (it.isUndo()) {
                stack = stackHistory.getLastSavedStackStateAndRemoveItFromHistory()
            }

            if (it.isOperand()) {
                stack.push(it.asOperand())
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
                } catch (e: EmptyStackException) {
                    throw SorryCannotFindSufficientNumberOfParametersInTheStack(operation, positionOfTheCurrentElement)
                }

                stack = operation.performOperationAndAddResultToStack(stack)
                stackHistory.saveStackState(stack)
            }
        }

        return stack
    }
}