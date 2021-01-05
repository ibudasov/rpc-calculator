import application.Application
import infrastructure.CliInput
import infrastructure.CliOutput

fun main(args: Array<String>) {
    println("👇 What would be your input?")

    var inputString = readLine()

    while (inputString != null && inputString.isNotBlank()) {
        val input = CliInput()
        input.setRawInput(inputString)
        Application().run(input, CliOutput())
        inputString = readLine()
    }

    println("🤌 Ciao!")
}