package practices.questions.easy

import practices.questions.EMPTY_SOLUTION_IN
import practices.questions.Solution


class LongestGcdInString: Solution<Pair<String, String>, String> {

    override fun getName() = "LongestGcdInString"

    override fun solve(solutionIn: Pair<String, String>?): String {
        solutionIn?.let {
            return firstAttempt(it)
        }
        throw Exception(EMPTY_SOLUTION_IN)
    }

    fun firstAttempt(solutionIn: Pair<String, String>): String {
        fun recursiveHelperFunction(strOne: String, strTwo: String): String {
            var str1 = strOne
            val str2 = strTwo
            if (str1.length < str2.length) return recursiveHelperFunction(str2, str1)
            if (str2.isEmpty()) return str1
            if (str1.startsWith(str2)) {
                str1 = str1.substring(str2.length)
                return recursiveHelperFunction(str1, str2)
            } else {
                return ""
            }
        }
        return recursiveHelperFunction(solutionIn.first, solutionIn.second)
    }
}

//fun main() {
//    var testPair = Pair("ABCABC", "ABC")
//    var testPair = Pair("LEET", "CODE")
//    var testPair = Pair("CCCABABQC", "AB")
//    println(LongestGcdInString().firstAttempt(testPair))
//}