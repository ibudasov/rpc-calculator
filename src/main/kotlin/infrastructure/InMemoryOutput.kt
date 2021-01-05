package infrastructure

import application.Output
import domain.Stack

class InMemoryOutput : Output {

    var stacksWhichWereOutput = listOf<Stack>()
    var linesWhichWereOutput = listOf<String>()

    override fun outputStack(stack: Stack) {
        stacksWhichWereOutput = stacksWhichWereOutput.plus(stack)
    }

    override fun printLine(line: String) {
        linesWhichWereOutput = linesWhichWereOutput.plus(line)
    }
}