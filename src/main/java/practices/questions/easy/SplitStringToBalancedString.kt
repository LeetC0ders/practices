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

    fun firstAttempt(solutionIn: String): Int {

        var map: MutableMap<Char, Int> = HashMap()
        var counter = 0

        map['R'] = 0
        map['L'] = 0

        for (item in solutionIn) {
            map[item] = map[item]!! + 1
            if (map['R'] == map['L']) {
                map['R'] = 0
                map['L'] = 0
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