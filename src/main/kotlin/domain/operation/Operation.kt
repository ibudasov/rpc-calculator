package domain.operation

import domain.StackOfOperands

interface Operation {

    /**
     * A textual representation of the operation.
     */
    fun operationLiteral(): String

    /**
     * Operations can receive variable amount of parameters, and I want the client code to call this
     * method until false is returned.
     * I had an idea of returning a number of operands, required for the operation, but it would
     * interfere with `clear` operator, which would take all the operands in the stack
     * This is how I encapsulate amount of parameters into the operation.
     */
    fun addOperandAndKeepAddingUntilItFitsTheOperation(operand: Double): Boolean

    /**
     * I perform operation and insert the result in the Stack because this is how I want to see my
     * abstraction:
     * - some operations insert the result into the stack
     * - some other operations insert nothing
     *
     * I encapsulate this behaviour into the operation itself
     */
    fun performOperationAndAddResultToStack(stackOfOperands: StackOfOperands): StackOfOperands
}