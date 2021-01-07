package infrastructure

import application.Output
import domain.StackOfOperands

class CliOutput : Output {
    override fun outputStack(stackOfOperands: StackOfOperands) {
        println("stack: $stackOfOperands")
    }

    override fun printLine(line: String) {
        println(line)
    }
}