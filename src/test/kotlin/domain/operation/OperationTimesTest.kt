package domain.operation

import domain.Calculator
import domain.InputElement
import org.junit.Test

class OperationTimesTest {

    @Test
    fun `times operation happy flow`() {
        val input = mutableListOf<InputElement>()
        input.add(InputElement("9"))
        input.add(InputElement("3"))
        input.add(InputElement("*"))

        val result = Calculator().calculate(input)

        kotlin.test.assertEquals("27 ", result.toString())
    }
}