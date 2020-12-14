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
}