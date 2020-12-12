package Domain

import org.junit.Test
import kotlin.test.assertEquals

internal class CalculatorTest {
    @Test
    fun `sqrt operation can be performed on a number`() {
        val input = mutableListOf<InputElement>()
        input.add(InputElement("9.0"))
        input.add(InputElement("sqrt"))

        val result = Calculator().calculateThings(input)

        assertEquals(3.0, result.getTheElementFromTheTopOfIt())
    }

    @Test
    fun `sqrt operation can be performed on a stack with many numbers`() {
        val input = mutableListOf<InputElement>()
        input.add(InputElement("1.0"))
        input.add(InputElement("2.0"))
        input.add(InputElement("9.0"))
        input.add(InputElement("sqrt"))

        val result = Calculator().calculateThings(input)

        assertEquals(3.0, result.getTheElementFromTheTopOfIt())
    }

}