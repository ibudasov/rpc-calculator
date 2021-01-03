package infrastructure

import application.Output
import domain.Stack

class CliOutput : Output {
    override fun outputStack(stack: Stack) {

        // TODO: number formatting might be improved here

        println("stack: " + stack.toString())
    }

    override fun printLine(line: String) {
        println(line)
    }
}