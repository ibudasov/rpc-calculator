fun main(args: Array<String>) {
    println("What would be your input?")

    var inputString = ""

    inputString += readLine()

    println(
        Application().run(inputString)
    )
}