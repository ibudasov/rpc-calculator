package application

import domain.InputElement

class StringToInputElementsParser {

    fun parseIt(string: String): List<InputElement> {
        val listOfLiterals = string.split(' ')

        val parsedToListOfInputElements = mutableListOf<InputElement>()

        listOfLiterals.forEach {
            parsedToListOfInputElements.add(InputElement(it))
        }

        return parsedToListOfInputElements
    }
}