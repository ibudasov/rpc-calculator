import Application.Application
import org.junit.Test
import kotlin.test.assertEquals

internal class ApplicationTest {

    @Test
    fun `sqrt can be calculated`() {
        assertEquals("3.0 ", Application().run("9 sqrt"))
    }

    @Test
    fun `sum can be calculated`() {
        assertEquals("10.0 ", Application().run("9 1 +"))
    }

    @Test
    fun `mul can be calculated`() {
        assertEquals("90.0 ", Application().run("9 10 *"))
    }

    @Test
    fun `minus can be calculated`() {
        assertEquals("4.0 ", Application().run("15 11 -"))
    }

    @Test
    fun `div can be calculated`() {
        assertEquals("5.0 ", Application().run("10 2 /"))
    }
}