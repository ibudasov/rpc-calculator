package Infrastructure

import Application.Output
import Domain.Stack

class CliOutput : Output {
    override fun outputStack(stack: Stack) {

        // TODO: number formatting might be improved here

        println("stack: " + stack.toString())
    }

    override fun printLine(line: String) {
        println(line)
    }
}