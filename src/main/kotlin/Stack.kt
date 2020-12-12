class Stack {

    private var theseNumbers: List<Double>

    init {
        theseNumbers = listOf()
    }

    fun addResultOfOperation(resultOfOperation: Double) {
        theseNumbers = listOf(resultOfOperation).plus(theseNumbers.toList())
    }

    fun getTheElementFromTheTopOfIt(): Double {
        return theseNumbers.first()
    }
}