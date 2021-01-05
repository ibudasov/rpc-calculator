package domain

import org.junit.Test
import kotlin.test.assertEquals

internal class OperationSqrtTest {
    @Test
    fun `sqrt operation happy flow`() {
        val input = mutableListOf<InputElement>()
        input.add(InputElement("9"))
        input.add(InputElement("sqrt"))

        val result = Calculator().calculateThings(input)

        assertEquals("3 ", result.toString())
    }
}