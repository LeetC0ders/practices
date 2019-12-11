package practices.questions.stringmanipulation

import practices.questions.EMPTY_SOLUTION_IN
import practices.questions.Solution

class CheckIsStringDoubleOrInt : Solution<String, CheckIsStringDoubleOrInt.Type> {

    enum class Type(string: String) {
        INT("INT"),
        DOUBLE("DOUBLE"),
        NAN("NOT_A_NUMBER")
    }

    override fun getName() = "CheckIsStringDoubleOrInt"

    override fun solve(solutionIn: String?): Type {
        solutionIn?.let {
            firstAttempt(it)
        }
        throw Exception(EMPTY_SOLUTION_IN)
    }

    fun firstAttempt(string: String): Type {
        val allNumbers = "1234567890"
        val dot = '.'

        var hasDot = false
        var isNumber = false

        for (char in string) {
            when {
                char == dot -> hasDot = true
                allNumbers.contains(char) -> isNumber = true
                else -> isNumber = false
            }
        }

        return when {
            hasDot && isNumber -> Type.DOUBLE
            isNumber -> Type.INT
            else -> Type.NAN
        }
    }
}

fun main() {
    print(CheckIsStringDoubleOrInt().firstAttempt("213."))
}