package application

import infrastructure.CliInput
import infrastructure.InMemoryOutput
import org.junit.Test
import kotlin.test.assertEquals

class ApplicationTest {

    @Test
    fun `happy path`() {

        val application = Application()
        val input = CliInput()
        val output = InMemoryOutput()

        input.setRawInput(" 1 1 +")

        application.run(input, output)

        assertEquals("2 ", output.stacksWhichWereOutput.first().toString())
    }

    @Test
    fun `error is shown when there is no sufficient number of operands`() {

        val application = Application()
        val input = CliInput()
        val output = InMemoryOutput()

        input.setRawInput("1 +")

        application.run(input, output)

        assertEquals(0, output.stacksWhichWereOutput.size)
        assertEquals("operator + (position: 2): insucient parameters", output.linesWhichWereOutput.first())
    }

}