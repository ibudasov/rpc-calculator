import application.StringToInputElementsParser
import domain.InputElement
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
            expected.first().isOperand(),
            parser.parseIt(toBeParsed).first().isOperand()
        )
        assertEquals(
            1.0,
            parser.parseIt(toBeParsed).first().asOperand()
        )

        assertEquals(
            expected.last().isOperand(),
            parser.parseIt(toBeParsed).last().isOperand()
        )
        assertEquals(
            "sqrt",
            parser.parseIt(toBeParsed).last().toString()
        )
    }

}