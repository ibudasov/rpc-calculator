import org.junit.Test
import kotlin.test.assertEquals

internal class OperationSqrtTest {
    @Test
    fun `sqrt operation can be performed on a number`() {
        val operationUnderTheTest = OperationSqrt()

        assertEquals("sqrt", operationUnderTheTest.operationLiteral())

        operationUnderTheTest.addOperandAndKeepAddingUntilItFitsTheOperation(
            InputElement("9")
        )

        val stack = Stack()

        val updatedStack = operationUnderTheTest.performOperationAndAddResultToStack(stack)

        assertEquals(3.0, updatedStack.getTheElementFromTheTopOfIt())
    }
}