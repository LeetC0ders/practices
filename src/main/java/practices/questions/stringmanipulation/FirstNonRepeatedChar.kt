package practices.questions.stringmanipulation

import practices.questions.EMPTY_SOLUTION_IN
import practices.questions.Solution

//https://www.reddit.com/r/cscareerquestions/comments/20ahfq/heres_a_pretty_big_list_of_programming_interview/

//Find the first non-repeated character in a String

class FirstNonRepeatedChar : Solution<String, Char> {

    override fun getName() = "FirstNonRepeatedChar"

    override fun solve(solutionIn: String?): Char {
        solutionIn?.let {
            return firstAttempt(it)
        }
        throw Exception(EMPTY_SOLUTION_IN)
    }

    // consider the case that can be [a,a,c,a,b,b,a,d,d], and c is the one
    // O(N)
    fun firstAttempt(string: String): Char {
        var map: MutableMap<Char, Int> = HashMap()

        for (char in string) {
            if (!map.containsKey(char)) map[char] = 1
            else map[char] = map[char] as Int + 1
        }

        var uniqueChar: Char? = null
        map.forEach {
            if (it.value == 1) uniqueChar = it.key
        }

        return uniqueChar!!
    }

}

fun main() {
    val test = "aaddaavvbbnnznddqdnnasssjjjdddz"
    print(FirstNonRepeatedChar().firstAttempt(test))
}