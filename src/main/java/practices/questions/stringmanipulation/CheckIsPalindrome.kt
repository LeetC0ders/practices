package practices.questions.stringmanipulation

import practices.questions.EMPTY_SOLUTION_IN
import practices.questions.Solution

class CheckIsPalindrome : Solution<String, Boolean> {

    override fun getName() = "CheckIsPalindrome"

    override fun solve(solutionIn: String?): Boolean {
        solutionIn?.let {
            firstAttempt(it)
        }
        throw Exception(EMPTY_SOLUTION_IN)
    }

    fun firstAttempt(str: String): Boolean {
        return str == str.reversed()
    }
}

fun main() {
    val str1 = "abba"
    val str2 = "xxbb"
    println(CheckIsPalindrome().firstAttempt(str1))
    println(CheckIsPalindrome().firstAttempt(str2))
}