package Infrastructure

import Application.Input
import Domain.InputElement

class CliInput : Input {

    var _rawInput: String = ""

    override fun setRawInput(string: String) {
        _rawInput = string
    }

    override fun getParsedInput(): List<InputElement> {
        return CliInputStringParser().parseIt(_rawInput)
    }
}