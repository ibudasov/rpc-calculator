import org.junit.Test
import kotlin.test.assertEquals

internal class InputElementTest {

    @Test
    fun `inputElement can be constructed from string`() {
        val ok = InputElement("ok")

        assertEquals("ok", ok.elementLiteral)

    }
}