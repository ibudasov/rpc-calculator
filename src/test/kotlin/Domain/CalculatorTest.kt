package Domain

import org.junit.Test
import org.junit.jupiter.api.assertThrows
import kotlin.test.assertEquals
import kotlin.test.expect

internal class CalculatorTest {
    @Test
    fun `sqrt operation can be performed on a number`() {
        val input = mutableListOf<InputElement>()
        input.add(InputElement("9.0"))
        input.add(InputElement("sqrt"))

        val result = Calculator().calculateThings(input)

        assertEquals("3.0 ", result.toString())
    }

    @Test
    fun `sqrt operation can be performed on a stack with many numbers`() {
        val input = mutableListOf<InputElement>()
        input.add(InputElement("1.0"))
        input.add(InputElement("2.0"))
        input.add(InputElement("9.0"))
        input.add(InputElement("sqrt"))

        val result = Calculator().calculateThings(input)

        assertEquals("3.0 2.0 1.0 ", result.toString())
    }

    @Test
    fun `div operation can be performed on a number`() {
        val input = mutableListOf<InputElement>()
        input.add(InputElement("9.0"))
        input.add(InputElement("3.0"))
        input.add(InputElement("/"))

        val result = Calculator().calculateThings(input)

        assertEquals("3.0 ", result.toString())
    }

    @Test
    fun `minus operation can be performed on a number`() {
        val input = mutableListOf<InputElement>()
        input.add(InputElement("9.0"))
        input.add(InputElement("3.0"))
        input.add(InputElement("-"))

        val result = Calculator().calculateThings(input)

        assertEquals("6.0 ", result.toString())
    }

    @Test
    fun `plus operation can be performed on a number`() {
        val input = mutableListOf<InputElement>()
        input.add(InputElement("9.0"))
        input.add(InputElement("3.0"))
        input.add(InputElement("+"))

        val result = Calculator().calculateThings(input)

        assertEquals("12.0 ", result.toString())
    }

    @Test
    fun `times operation can be performed on a number`() {
        val input = mutableListOf<InputElement>()
        input.add(InputElement("9.0"))
        input.add(InputElement("3.0"))
        input.add(InputElement("*"))

        val result = Calculator().calculateThings(input)

        assertEquals("27.0 ", result.toString())
    }

    @Test
    fun `few operations can be performed in one go`() {
        val input = mutableListOf<InputElement>()
        input.add(InputElement("9.0"))
        input.add(InputElement("3.0"))
        input.add(InputElement("*"))
        input.add(InputElement("5"))
        input.add(InputElement("+"))
        input.add(InputElement("11"))
        input.add(InputElement("-"))

        val result = Calculator().calculateThings(input)

        assertEquals("21.0 ", result.toString())
    }

    @Test
    fun `clear operator clears all the stack`() {
        val input = mutableListOf<InputElement>()
        input.add(InputElement("9.0"))
        input.add(InputElement("3.0"))
        input.add(InputElement("*"))
        input.add(InputElement("5"))
        input.add(InputElement("+"))
        input.add(InputElement("11"))
        input.add(InputElement("clear"))

        val result = Calculator().calculateThings(input)

        assertEquals("", result.toString())
    }

    @Test
    fun `If an operator cannot find a sufficient number of parameters on the stack, a warning is displayed`() {
        val input = mutableListOf<InputElement>()
        input.add(InputElement("-"))

        assertThrows<SorryCannotFindSufficientNumberOfParametersInTheStack> {
            Calculator().calculateThings(input)
        }
    }

    @Test
    fun `undo operator removes an operand from the stack`() {
        val input = mutableListOf<InputElement>()
        input.add(InputElement("9.0"))
        input.add(InputElement("3.0"))
        input.add(InputElement("undo"))

        val result = Calculator().calculateThings(input)

        assertEquals("9.0 ", result.toString())
    }

    fun `double undo operator removes 2 operands from the stack`() {
        val input = mutableListOf<InputElement>()
        input.add(InputElement("9.0"))
        input.add(InputElement("3.0"))
        input.add(InputElement("undo"))
        input.add(InputElement("undo"))

        val result = Calculator().calculateThings(input)

        assertEquals("", result.toString())
    }

    fun `undo operator can undo the operation, result of which is in the stack`() {
        val input = mutableListOf<InputElement>()
        input.add(InputElement("5.0"))
        input.add(InputElement("4.0"))
        input.add(InputElement("3.0"))
        input.add(InputElement("2.0"))
        input.add(InputElement("undo"))
        input.add(InputElement("undo"))
        input.add(InputElement("*"))
        input.add(InputElement("5"))
        input.add(InputElement("*"))
        input.add(InputElement("undo"))

        val result = Calculator().calculateThings(input)

        assertEquals("20.0 5.0 ", result.toString())
    }
}