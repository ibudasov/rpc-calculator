package Domain

class Stack {

    private var theseNumbers: List<Double>

    init {
        theseNumbers = listOf()
    }

    fun addNumberOnTopOfIt(resultOfOperation: Double) {
        theseNumbers = listOf(resultOfOperation).plus(theseNumbers)
    }

    fun getTheElementFromTheTopOfItAndRemoveItFromStack(): Double {

        val lastValueInTheStack = 1

        if(theseNumbers.size < lastValueInTheStack) {
            throw SorryCannotFindSufficientNumberOfParametersInTheStack()
        }

        val first = theseNumbers.first()

        theseNumbers = theseNumbers.drop(1)

        return first
    }

    override fun toString(): String {
        var accunulator = ""

        theseNumbers.forEach {
            accunulator += "$it " // 👈 this is an element converted to string plus a space
        }

        return accunulator
    }
}