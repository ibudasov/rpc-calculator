package domain

class Stack {

    private var operands: List<Double>

    init {
        operands = listOf()
    }

    fun addNumberOnTopOfIt(resultOfOperation: Double): Stack {
        operands = listOf(resultOfOperation).plus(operands)

        return this
    }

    fun getTheElementFromTheTopOfItAndRemoveItFromStack(): Double {

        val lastValueInTheStack = 1

        if (operands.size < lastValueInTheStack) {
            throw IllegalStateException("Stack appears to be empty while trying to get an operand out of it")
        }

        val first = operands.first()

        operands = operands.drop(1)

        return first
    }

    fun countElements(): Int {
        return operands.size
    }

    fun clone(): Stack
    {
        val newStack = Stack()
        operands.forEach {
            newStack.addNumberOnTopOfIt(it)
        }

        return newStack
    }

    override fun toString(): String {
        var accunulator = ""

        operands.forEach {
            accunulator += "$it " // 👈 this is an element converted to string plus a space
        }

        return accunulator
    }
}