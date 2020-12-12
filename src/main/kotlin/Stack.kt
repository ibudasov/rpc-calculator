class Stack {

    private var theseNumbers: List<Double>

    init {
        theseNumbers = listOf()
    }

    // todo: make it immutable

    fun addNumberOnTopOfIt(resultOfOperation: Double) {
        theseNumbers = listOf(resultOfOperation).plus(theseNumbers.toList())
    }

    fun getTheElementFromTheTopOfIt(): Double {
        val toReturn = theseNumbers.first()

        theseNumbers.dropLast(1)

        return toReturn
    }
}