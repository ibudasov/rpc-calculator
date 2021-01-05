package domain.operation

import domain.Calculator
import domain.InputElement
import org.junit.Test
import kotlin.test.assertEquals

internal class OperationClearTest {

    @Test
    fun `clear operator clears all the stack`() {
        val input = mutableListOf<InputElement>()
        input.add(InputElement("11"))
        input.add(InputElement("11"))
        input.add(InputElement("+"))
        input.add(InputElement("clear"))

        val result = Calculator().calculateThings(input)

        assertEquals("", result.toString())
        assertEquals(0, result.countElements())
    }
}