import domain.InputElement
import application.StringToInputElementsParser
import org.junit.Test
import kotlin.test.assertEquals

internal class StringToInputElementsParserTest {

    @Test
    fun `string can be parsed to InputElements`() {
        val toBeParsed = "1 2 sqrt"

        val expected = mutableListOf<InputElement>()
        expected.add(InputElement("1"))
        expected.add(InputElement("2"))
        expected.add(InputElement("sqrt"))

        val parser = StringToInputElementsParser()

        assertEquals(
            expected.first().isNumber(),
            parser.parseIt(toBeParsed).first().isNumber()
        )
        assertEquals(
            1.0,
            parser.parseIt(toBeParsed).first().asNumber()
        )

        assertEquals(
            expected.last().isNumber(),
            parser.parseIt(toBeParsed).last().isNumber()
        )
        assertEquals(
            "sqrt",
            parser.parseIt(toBeParsed).last().toString()
        )
    }

}