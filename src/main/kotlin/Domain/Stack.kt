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
        return theseNumbers.removeFirst()
    }

    override fun toString(): String {
        var accunulator = ""

        theseNumbers.forEach {
            accunulator += it.toString() + " "
        }

        return accunulator
    }
}