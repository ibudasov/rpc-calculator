package domain.operation

import domain.Calculator
import domain.InputElement
import org.junit.Test
import kotlin.test.assertFailsWith

class OperationDivTest {
    @Test
    fun `div operation happy flow`() {
        val input = mutableListOf<InputElement>()
        input.add(InputElement("9"))
        input.add(InputElement("3"))
        input.add(InputElement("/"))

        val result = Calculator().calculate(input)

        kotlin.test.assertEquals("3 ", result.toString())
    }

    @Test
    fun `div by null is not possible`() {
        val input = mutableListOf<InputElement>()
        input.add(InputElement("9"))
        input.add(InputElement("0"))
        input.add(InputElement("/"))

        assertFailsWith<SorryDivisionByZeroIsNoGood> {
            Calculator().calculate(input)
        }
    }
}