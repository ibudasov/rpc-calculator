package Application

import Domain.InputElement

interface Input {

    fun setRawInput(string: String)

    fun getParsedInput(): List<InputElement>
}