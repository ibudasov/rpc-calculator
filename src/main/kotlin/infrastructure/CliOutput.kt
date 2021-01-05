package infrastructure

import application.Output
import domain.Stack

class CliOutput : Output {
    override fun outputStack(stack: Stack) {
        println("stack: $stack")
    }

    override fun printLine(line: String) {
        println(line)
    }
}