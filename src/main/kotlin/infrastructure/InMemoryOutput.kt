package infrastructure

import application.Output
import domain.StackOfOperands

class InMemoryOutput : Output {

    var stacksWhichWereOutput = listOf<StackOfOperands>()
    var linesWhichWereOutput = listOf<String>()

    override fun outputStack(stackOfOperands: StackOfOperands) {
        stacksWhichWereOutput = stacksWhichWereOutput.plus(stackOfOperands)
    }

    override fun printLine(line: String) {
        linesWhichWereOutput = linesWhichWereOutput.plus(line)
    }
}