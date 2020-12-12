import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

internal class InputElementTest {

    @Test
    fun `inputElement can be constructed from string`() {
        val elementUnderTheTest = InputElement("ok")

        assertEquals("ok", elementUnderTheTest.elementLiteral)
    }

    @Test
    fun `inputElement can be can be identified as an Int when it's applicable`() {
        val elementUnderTheTest = InputElement("2")

        assertTrue(elementUnderTheTest.isInteger())
    }

    @Test
    fun `inputElement can be can be identified as an NON-Int when it's a word`() {
        val elementUnderTheTest = InputElement("banaan")

        assertFalse(elementUnderTheTest.isInteger())
    }
}