import org.junit.Test
import kotlin.test.assertEquals

internal class InputStringParserTest {

    @Test
    fun `string can be parsed to InputElements`() {
        val toBeParsed = "1 2 sqrt"

        val expected = mutableListOf<InputElement>()
        expected.add(InputElement("1"))
        expected.add(InputElement("2"))
        expected.add(InputElement("sqrt"))

        val parser = InputStringParser()

        assertEquals(
            expected.first().isInteger(),
            parser.parseIt(toBeParsed).first().isInteger()
        )
        assertEquals(
            1.0,
            parser.parseIt(toBeParsed).first().asInteger()
        )

        assertEquals(
            expected.last().isInteger(),
            parser.parseIt(toBeParsed).last().isInteger()
        )
        assertEquals(
            "sqrt",
            parser.parseIt(toBeParsed).last().toString()
        )
    }

}