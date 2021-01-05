package domain

import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

internal class CalculatorTest {

    @Test
    fun `few operations can be performed in one go`() {
        val input = mutableListOf<InputElement>()
        input.add(InputElement("9"))
        input.add(InputElement("3"))
        input.add(InputElement("*"))
        input.add(InputElement("5"))
        input.add(InputElement("+"))
        input.add(InputElement("11"))
        input.add(InputElement("-"))

        val result = Calculator().calculate(input)

        assertEquals("21 ", result.toString())
    }

    @Test
    fun `If an operator cannot find a sufficient number of parameters on the stack, a warning is displayed`() {
        val input = mutableListOf<InputElement>()
        input.add(InputElement("-"))

        val exception = assertFailsWith<SorryCannotFindSufficientNumberOfParametersInTheStack> {
            Calculator().calculate(input)
        }
        assertEquals("operator - (position: 1): insucient parameters", exception.message)
    }

    @Test
    fun `undo operator removes an operand from the stack`() {
        val input = mutableListOf<InputElement>()
        input.add(InputElement("9"))
        input.add(InputElement("3"))
        input.add(InputElement("undo"))

        val result = Calculator().calculate(input)

        assertEquals("9 ", result.toString())
    }

    @Test
    fun `double undo operator removes 2 operands from the stack`() {
        val input = mutableListOf<InputElement>()
        input.add(InputElement("9"))
        input.add(InputElement("3"))
        input.add(InputElement("undo"))
        input.add(InputElement("undo"))

        val result = Calculator().calculate(input)

        assertEquals("", result.toString())
    }

    @Test
    fun `undo operator can undo the operation, result of which is in the stack`() {
        val input = mutableListOf<InputElement>()
        input.add(InputElement("5"))
        input.add(InputElement("4"))
        input.add(InputElement("3"))
        input.add(InputElement("2"))
        input.add(InputElement("undo"))
        input.add(InputElement("undo"))
        input.add(InputElement("*"))
        input.add(InputElement("5"))
        input.add(InputElement("*"))
        input.add(InputElement("undo"))

        val result = Calculator().calculate(input)

        assertEquals("20 5 ", result.toString())
    }
}