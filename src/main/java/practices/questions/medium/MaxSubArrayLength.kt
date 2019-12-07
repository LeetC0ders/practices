package practices.questions.medium

import practices.questions.EMPTY_SOLUTION_IN
import practices.questions.Solution

class MaxSubArrayLength : Solution<Pair<IntArray, Int>, Int> {
    override fun getName(): String {
        return "MaxSubArrayLength"
    }

    override fun solve(solutionIn: Pair<IntArray, Int>?): Int {
        solutionIn?.let {
            firstAttempt(it)
        }
        throw Exception(EMPTY_SOLUTION_IN)
    }

    fun firstAttempt(solutionIn: Pair<IntArray, Int>): Int {

        var intArray = solutionIn.first
        val target = solutionIn.second

        if (intArray.size == 1 && intArray[0] == target) return 1

        var maxLength = 0
        var isFound = false


        for (index in 0 until intArray.size) {
            var sumToTarget = intArray[index]
            var length = 0
            if (intArray[index] == target) maxLength = Math.max(maxLength, 1)
            for (smolIndex in index + 1 until intArray.size) {
                sumToTarget += intArray[smolIndex]
                if (sumToTarget == target) {
                    isFound = true
                    length = smolIndex - index
                    maxLength = Math.max(maxLength, length)
                }
            }
        }
        return if (isFound) maxLength + 1 else maxLength
    }
}

//TODO: Use the main as test cases for Unit Test
fun main() {
//    var test = Pair(intArrayOf(1), 1)
//    var test = Pair(intArrayOf(-1), 1)
//    var test = Pair(intArrayOf(-1, 1), 1)
//    var test = Pair(intArrayOf(1, -1), 1)
//    var test = Pair(intArrayOf(), 0)
//    var test = Pair(intArrayOf(1, -1, 5, -2, 3), 3)
//    var test = Pair(intArrayOf(-2, -1, 2, 1), 1)
//    var test = Pair(intArrayOf(-2,1,-3,4,-1,2,1,-5,4), 1)
//    println(MaxSubArrayLength().firstAttempt(test))
}