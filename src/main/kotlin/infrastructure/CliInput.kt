package infrastructure

import application.StringToInputElementsParser
import application.Input
import domain.InputElement

class CliInput : Input {

    var _rawInput: String = ""

    override fun setRawInput(string: String) {
        _rawInput = string
    }

    override fun getParsedInput(): List<InputElement> {
        return StringToInputElementsParser().parseIt(_rawInput)
    }
}