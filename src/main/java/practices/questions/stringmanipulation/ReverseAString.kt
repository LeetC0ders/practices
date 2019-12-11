package practices.questions.stringmanipulation

import practices.questions.EMPTY_SOLUTION_IN
import practices.questions.Solution
import java.lang.StringBuilder

class ReverseAString: Solution<String, String> {

    override fun getName() = "ReverseAString"

    override fun solve(solutionIn: String?): String {
        solutionIn?.let {
            return firstAttempt(it)
        }
        throw Exception(EMPTY_SOLUTION_IN)
    }

    // iterative way
    fun firstAttempt(string: String) = StringBuilder().apply {
        for (index in string.length - 1 downTo 0) append(string[index]) }.toString()

    // recursive way
    fun secondAttempt(string: String): String {

        var sb = StringBuilder()

        fun recursiveHelperFunction(index: Int) {
            if (index < string.length) {
                recursiveHelperFunction(index + 1)
                sb.append(string[index])
            } else {
                return
            }
        }

        recursiveHelperFunction(0)
        return sb.toString()
    }
}

fun main() {
    val test = "zz22zz44zz55"
//    print(ReverseAString().firstAttempt(test))
    print(ReverseAString().secondAttempt(test))
}