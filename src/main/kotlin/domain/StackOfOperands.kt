package domain

import java.math.RoundingMode
import java.text.DecimalFormat
import java.util.*

class StackOfOperands : Stack<Double>() {
    override fun toString(): String {
        var accunulator = ""

        val df = DecimalFormat("#.##########")
        df.roundingMode = RoundingMode.CEILING

        elements().toList().forEach {
            accunulator += df.format(it) + " "
        }

        return accunulator
    }
}