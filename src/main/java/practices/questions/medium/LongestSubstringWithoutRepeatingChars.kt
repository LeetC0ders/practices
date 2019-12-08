package practices.questions.medium

import practices.questions.EMPTY_SOLUTION_IN
import practices.questions.Solution
import javax.inject.Inject
import javax.inject.Singleton

/*
* 003-LongestSubstringWithoutRepeatingCharacters
*
* Question:
* Given a string, find the length of the longest substring without repeating characters.
*
* - If the number is a multiple of 3, print "Fizz" instead of the number.
* - If the number is a multiple of 5, print "Buzz" instead of the number.
* - If the number is a multiple of 15, print "FizzBuzz" instead of the number.
* - Otherwise, print the number itself.
*
* Each output should be followed by a new line.
*
* */
@Singleton
class LongestSubstringWithoutRepeatingChars @Inject constructor(): Solution<String, Int> {

    override fun getName() = "LongestSubstringWithoutRepeatingChars"

    override fun solve(solutionIn: String?): Int {
        solutionIn?.let {
            return firstAttempt(it)
        }
        throw Exception(EMPTY_SOLUTION_IN)
    }

    /*
    * Runtime: 196 ms, faster than 86.48% of Kotlin online submissions for Longest Substring Without Repeating Characters.
    * Memory Usage: 35.2 MB, less than 100.00% of Kotlin online submissions for Longest Substring Without Repeating Characters.
    * */
    fun firstAttempt(solutionIn: String): Int {
        val stringLength = solutionIn.length

        var uniqueCharSet: MutableSet<Char> = HashSet()
        var longestLength = 0
        var startIndex = 0
        var endIndex = 0

        while (startIndex < stringLength && endIndex < stringLength) {
            when (!uniqueCharSet.contains(solutionIn[endIndex])) {
                true -> {
                    uniqueCharSet.add(solutionIn[endIndex++])
                    longestLength = if (endIndex - startIndex > longestLength) endIndex - startIndex else longestLength
                }
                false -> uniqueCharSet.remove(solutionIn[startIndex++])
            }
        }

        return longestLength
    }
}