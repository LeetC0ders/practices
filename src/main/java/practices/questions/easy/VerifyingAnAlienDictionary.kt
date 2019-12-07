package practices.questions.easy

import practices.questions.EMPTY_SOLUTION_IN
import practices.questions.Solution
import javax.inject.Inject
import javax.inject.Singleton

/*
* problem - 953 - Verifying an Alien Dictionary
* In an alien language, surprisingly they also use english lowercase letters, but possibly in a different order. The order of the alphabet is some permutation of lowercase letters.
*
* Given a sequence of words written in the alien language, and the order of the alphabet, return true if and only if the given words are sorted lexicographicaly in this alien language.
*
*
*
* Example 1:
*
* Input: words = ["hello","leetcode"], order = "hlabcdefgijkmnopqrstuvwxyz"
* Output: true
* Explanation: As 'h' comes before 'l' in this language, then the sequence is sorted.
* Example 2:
*
* Input: words = ["word","world","row"], order = "worldabcefghijkmnpqstuvxyz"
* Output: false
* Explanation: As 'd' comes after 'l' in this language, then words[0] > words[1], hence the sequence is unsorted.
* Example 3:
*
* Input: words = ["apple","app"], order = "abcdefghijklmnopqrstuvwxyz"
* Output: false
* Explanation: The first three characters "app" match, and the second string is shorter (in size.) According to lexicographical rules "apple" > "app", because 'l' > '∅', where '∅' is defined as the blank character which is less than any other character (More info).
*
*
* Constraints:
*
* 1 <= words.length <= 100
* 1 <= words[i].length <= 20
* order.length == 26
* All characters in words[i] and order are English lowercase letters.
*
* */
@Singleton
class VerifyingAnAlienDictionary @Inject constructor(): Solution<Pair<Array<String>, String>, Boolean> {

    override fun getName() = "VerifyingAnAlienDictionary"

    override fun solve(solutionIn: Pair<Array<String>, String>?): Boolean {
        solutionIn?.let {
            firstAttempt(it)
        }
        throw Exception(EMPTY_SOLUTION_IN)
    }

    /*
    * Runtime: 156 ms, faster than 97.06% of Kotlin online submissions for Verifying an Alien Dictionary.
    * Memory Usage: 32.3 MB, less than 100.00% of Kotlin online submissions for Verifying an Alien Dictionary.
    * */
    fun firstAttempt(solutionIn: Pair<Array<String>, String>): Boolean {

        val words = solutionIn.first
        val order = solutionIn.second
        val orderMap: MutableMap<Char, Int> = HashMap()
        var orderIndex = 0
        for (char in order) {
            orderMap[char] = orderIndex
            orderIndex++
        }
        for (index in 0 until words.size - 1) {
            loop@ for (charIndex in 0 until words[index].length) {
                try {
                    when {
                        orderMap[words[index].get(charIndex)]!! < orderMap[words[index + 1].get(charIndex)]!! -> {
                            break@loop
                        }
                        orderMap[words[index].get(charIndex)]!! > orderMap[words[index + 1].get(charIndex)]!! -> {
                            return false
                        }
                    }
                } catch (exception: java.lang.Exception) {
                    if (words[index].length > words[index + 1].length) return false
                }
            }
        }
        return true
    }
}

//TODO: use main as the base case for Unit Test
//fun main() {
//    val stringArr = arrayOf("hello","leetcode")
//    val stringArr = arrayOf("word","world","row")
//    val stringArr = arrayOf("apple","app")
//    val order = "hlabcdefgijkmnopqrstuvwxyz"
//    val order = "worldabcefghijkmnpqstuvxyz"
//    val order = "abcdefghijklmnopqrstuvwxyz"
//    val testPair = Pair(stringArr, order)
//    print(VerifyingAnAlienDictionary().firstAttempt(testPair))
//}