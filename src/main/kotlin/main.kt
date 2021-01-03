import application.Application
import infrastructure.CliInput
import infrastructure.CliOutput

fun main(args: Array<String>) {
    println("What would be your input?")

    var inputString = ""

    inputString += readLine()

    val input = CliInput()
    input.setRawInput(inputString)

    // TODO: The application currently runs only once and then halts.
    //       It should receive input, show output and request the input again.

    Application().run(input, CliOutput())
}