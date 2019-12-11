package practices.questions.stringmanipulation

import practices.questions.EMPTY_SOLUTION_IN
import practices.questions.Solution

class CheckAnagrams : Solution<Pair<String, String>, Boolean> {

    override fun getName() = "CheckAnagrams"

    override fun solve(solutionIn: Pair<String, String>?): Boolean {
        solutionIn?.let {
            return firstAttempt(it.first, it.second)
        }
        throw Exception(EMPTY_SOLUTION_IN)
    }

    fun firstAttempt(str1: String, str2: String): Boolean {
        if (str1.length != str2.length) return false
        else {
            str1.forEach {
                if (!str2.contains(it)) {
                    return false
                }
            }
            return true
        }
    }
}

fun main() {
    val a1 = "below"
    val a2 = "elbow"
    print(CheckAnagrams().firstAttempt(a1, a2))
}