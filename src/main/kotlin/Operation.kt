interface Operation {

    /**
     * Operation literal is a textual representation of the operation.
     */
    fun operationLiteral(): String

    /**
     * Operations can receive variable amount of parameters, and I want the client code to call this
     * method until false is returned.
     * This is how I encapsulate amount of parameters into the operation.
     */
    fun addOperandAndKeepAddingUntilItFitsTheOperation(inputElement: InputElement): Boolean

    /**
     * I perform operation and insert the result in the Stack because this is how I want to see my
     * abstraction:
     * - some operations insert the result into the stack
     * - some other operations insert nothing
     *
     * I encapsulate this behaviour into the operation itself
     */
    fun performOperationAndAddResultToStack(stack: Stack): Stack
}