package practices.questions.medium

import practices.questions.EMPTY_SOLUTION_IN
import practices.questions.Solution
import java.lang.StringBuilder
import java.util.*
import kotlin.collections.HashSet

class LongestSubstringWithoutRepeatingChars: Solution<String, Int> {

    override fun getName() = "LongestSubstringWithoutRepeatingChars"

    override fun solve(solutionIn: String?): Int {
        solutionIn?.let {
            return firstAttempt(it)
        }
        throw Exception(EMPTY_SOLUTION_IN)
    }

    fun firstAttempt(solutionIn: String): Int {

        val solutionInArr = solutionIn.split("")

        var uniqueStringSet: MutableSet<String> = HashSet()
        var tempStringSet: MutableSet<String> = HashSet()
        var stringBuilder = StringBuilder()
        var heap = PriorityQueue<Int>(10, Collections.reverseOrder())

        for(char in solutionInArr) {
            if (!tempStringSet.contains(char)) {
                tempStringSet.add(char)
                stringBuilder.append(char)
            } else {
                tempStringSet.clear()
                if (!uniqueStringSet.contains(stringBuilder.toString())) {
                    uniqueStringSet.add(stringBuilder.toString())
                    heap.add(stringBuilder.toString().length)
                }
                stringBuilder = StringBuilder("$char")
                tempStringSet.add(char)
            }
        }
        return heap.poll()
    }

}

fun main() {
    val solve = LongestSubstringWithoutRepeatingChars()
    val p1 = "aab"
    print(solve.firstAttempt(p1))
}