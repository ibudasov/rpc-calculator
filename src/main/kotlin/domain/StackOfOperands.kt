package domain

import java.math.RoundingMode
import java.text.DecimalFormat
import java.util.*

class StackOfOperands : Stack<Double>() {
    override fun toString(): String {
        var accumulator = ""

        val df = DecimalFormat("#.##########")
        df.roundingMode = RoundingMode.CEILING

        elements().toList().forEach {
            accumulator += df.format(it) + " "
        }

        return accumulator
    }
}