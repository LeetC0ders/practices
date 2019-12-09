package practices.questions.medium

import practices.questions.EMPTY_SOLUTION_IN
import practices.questions.Solution
import javax.inject.Inject
import javax.inject.Singleton

/*
* problem-5-Longest palindromic subString
* Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
*
* Example 1:
*
* Input: "babad"
* Output: "bab"
* Note: "aba" is also a valid answer.
* Example 2:
*
* Input: "cbbd"
* Output: "bb"
* */
@Singleton
class LongestPalindromicSubString @Inject constructor() : Solution<String, String> {

    override fun getName() = "LongestPalindrome"

    override fun solve(solutionIn: String?): String {
        solutionIn?.let {
            firstAttempt(it)
        }
        throw Exception(EMPTY_SOLUTION_IN)
    }

    /*
    * Time Limit Exceeded
    * */
    fun firstAttempt(solutionIn: String): String {

        if (solutionIn.isEmpty()) return ""
        if (solutionIn.length == 1) return solutionIn

        val originString = solutionIn
        val reversedString = solutionIn.reversed()
        var max = 1
        var maxString = ""

        for (index in 0..originString.length) {
            for (endIndex in index + 1..originString.length) {
                val subString = originString.substring(index, endIndex)
                if (reversedString.contains(subString) && subString == subString.reversed()) {
                    if (subString.length > max) {
                        max = subString.length
                        maxString = subString
                    }
                }
            }
        }

        return if (max == 1) solutionIn[0].toString() else maxString
    }

}

//fun main() {
//    println(LongestPalindrome().firstAttempt("cbbd"))
//    println(LongestPalindrome().firstAttempt("ccc"))
//    println(LongestPalindrome().firstAttempt("c"))
//    println(LongestPalindrome().firstAttempt(""))
//    println(LongestPalindrome().firstAttempt("cc"))
//    println(LongestPalindrome().firstAttempt("bbbbbbbcxx"))
//    println(LongestPalindrome().firstAttempt("aacdefcaa"))
//}