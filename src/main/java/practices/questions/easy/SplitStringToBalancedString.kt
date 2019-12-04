package practices.questions.easy

import practices.questions.EMPTY_SOLUTION_IN
import practices.questions.Solution

/*
* 1221-Split a String in Balanced Strings
*
*
*
* */
class SplitStringToBalancedString: Solution<String, Int> {

    override fun getName() = "SplitStringToBalancedString"

    override fun solve(solutionIn: String?): Int {
        solutionIn?.let {
            return firstAttempt(it)
        }
        throw Exception(EMPTY_SOLUTION_IN)
    }

    /*
    * Runtime: 140 ms, faster than 41.86% of Kotlin online submissions for Split a String in Balanced Strings.
    * Memory Usage: 31.5 MB, less than 100.00% of Kotlin online submissions for Split a String in Balanced Strings.
    * */
    fun firstAttempt(solutionIn: String): Int {

        var counterArr = intArrayOf(0, 0) //[0] or R, [1] or L
        var counter = 0

        counterArr[0] = 0
        counterArr[1] = 0

        for (item in solutionIn) {
            when (item) {
                'R' -> counterArr[0]++
                'L' -> counterArr[1]++
            }
            if (counterArr[0] == counterArr[1]) {
                counterArr[0] = 0
                counterArr[1] = 0
                counter++
            }
        }
        return counter
    }
}

fun main() {
    val s = SplitStringToBalancedString()
    print(s.firstAttempt("RLRRRLLRLL"))
}