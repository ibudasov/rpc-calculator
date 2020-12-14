import Domain.Calculator

class Application {

    // todo: get input and output objects here, don't mix implementation and domain

    fun run(string: String): String {
        val input = InputStringParser().parseIt(string)

        val stack = Calculator().calculateThings(input)

        return stack.toString()
    }
}