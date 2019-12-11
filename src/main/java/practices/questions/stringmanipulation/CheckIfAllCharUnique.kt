package practices.questions.stringmanipulation

import practices.questions.EMPTY_SOLUTION_IN
import practices.questions.Solution
import java.lang.StringBuilder

class CheckIfAllCharUnique: Solution<String, Boolean> {

    override fun getName() = "CheckIfAllCharUnique"

    override fun solve(solutionIn: String?): Boolean {
        solutionIn?.let {
            return firstAttempt(it)
        }
        throw Exception(EMPTY_SOLUTION_IN)
    }

    fun firstAttempt(string: String): Boolean {
        var set: MutableSet<Char> = HashSet()
        for (char in string) {
            var isSuccess = set.add(char)
            if (!isSuccess) return isSuccess
        }
        return true
    }
}

fun main() {
    val test = StringBuilder().apply {
        for (char in 'a'..'z') append(char)
//        append('z')
    }.toString()
    print(CheckIfAllCharUnique().firstAttempt(test))
}