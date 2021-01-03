package application

import domain.InputElement

interface Input {

    /**
     * Something which might be parsed.
     * For CLI and Web I assumed that String would be alright
     */
    fun setRawInput(string: String)

    /**
     * Should return domain objects parsed from input
     */
    fun getParsedInput(): List<InputElement>
}