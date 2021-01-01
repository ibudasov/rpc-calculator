package Domain

class Stack {

    // todo: having this thing Mutable will cause problems when there are multithreads. Make it just a list
    private var theseNumbers: MutableList<Double>

    init {
        theseNumbers = mutableListOf()
    }

    fun addNumberOnTopOfIt(resultOfOperation: Double) {
        theseNumbers = listOf(resultOfOperation).plus(theseNumbers.toList()).toMutableList()
    }

    fun getTheElementFromTheTopOfItAndRemoveItFromStack(): Double {

        val lastValueInTheStack = 1

        if(theseNumbers.size < lastValueInTheStack) {
            throw SorryCannotFindSufficientNumberOfParametersInTheStack()
        }

        return theseNumbers.removeFirst()
    }

    fun howManyOperandsAreThere(): Int
    {
        return theseNumbers.size
    }

    override fun toString(): String {
        var accunulator = ""

        theseNumbers.forEach {
            accunulator += "$it " // 👈 this is an element converted to string plus a space
        }

        return accunulator
    }
}