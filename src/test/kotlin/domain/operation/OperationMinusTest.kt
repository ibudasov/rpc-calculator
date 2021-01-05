package domain.operation

import domain.Calculator
import domain.InputElement
import org.junit.Test

class OperationMinusTest {
    @Test
    fun `minus operation happy flow`() {
        val input = mutableListOf<InputElement>()
        input.add(InputElement("9"))
        input.add(InputElement("3"))
        input.add(InputElement("-"))

        val result = Calculator().calculateThings(input)

        kotlin.test.assertEquals("6 ", result.toString())
    }
}
