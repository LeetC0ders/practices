package practices.questions.easy

import practices.questions.EMPTY_SOLUTION_IN
import practices.questions.Solution
import javax.inject.Inject
import javax.inject.Singleton

/*
* 1221-Split a String in Balanced Strings
*
* Question:
* Balanced strings are those who have equal quantity of 'L' and 'R'
* Given a balanced string s split it in the maximum amount of balanced strings.
* Return the maximum amount of spitted balanced strings.
*
* Example:
*
* Input: s = "RLRRLLRLRL", Output: 4
* Explanation: s can be split into "RL", "RRLL", "RL", "RL",
* each substring contains same number of 'L' and 'R'.
*
* Input: s = "RLLLLRRRLR", Output: 3
* Explanation: s can be split into "RL", "LLLRRR", "LR",
* each substring contains same number of 'L' and 'R'.
*
* Input: s = "RLRRRLLRLL", Output: 2
* Explanation: s can be split into "RL", "RRRLLRLL",
* since each substring contains an equal number of 'L' and 'R'
* */
@Singleton
class SplitStringToBalancedString @Inject constructor(): Solution<String, Int> {

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