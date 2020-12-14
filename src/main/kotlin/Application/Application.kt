package Application

import Domain.Calculator

class Application {
    fun run(input: Input, output: Output) {
        output.outputStack(
            Calculator().calculateThings(input.getParsedInput())
        )
    }
}