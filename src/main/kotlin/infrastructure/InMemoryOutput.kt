package infrastructure

import application.Output
import domain.StackOfOperands

class InMemoryOutput : Output {

    var stacksWhichWereOutput = mutableListOf<StackOfOperands>()
    var linesWhichWereOutput = listOf<String>()

    override fun outputStack(stackOfOperands: StackOfOperands) {
        val clonedStack = stackOfOperands.clone()

        stacksWhichWereOutput.add(clonedStack as StackOfOperands)
    }

    override fun printLine(line: String) {
        linesWhichWereOutput = linesWhichWereOutput.plus(line)
    }
}