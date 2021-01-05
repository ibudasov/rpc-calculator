package application

import domain.Calculator
import domain.SorryCannotFindSufficientNumberOfParametersInTheStack

class Application {
    fun run(input: Input, output: Output) {

        try {
            output.outputStack(
                Calculator().calculate(input.getParsedInput())
            )
        } catch (e: SorryCannotFindSufficientNumberOfParametersInTheStack) {
            e.message?.let { output.printLine(it) }
        }
    }
}