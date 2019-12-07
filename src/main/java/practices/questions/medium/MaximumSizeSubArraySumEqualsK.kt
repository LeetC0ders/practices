package practices.questions.medium

import practices.questions.EMPTY_SOLUTION_IN
import practices.questions.Solution
import javax.inject.Inject
import javax.inject.Singleton
import kotlin.math.max

/*
* 325-Problem - Maximum Size Sub-array Sum Equals k
* Given an array and a target value k, find the maximum length of a sub array that sums to k. If there isn't one, return 0 instead.
*
* Note:
* The sum of the entire array is guaranteed to fit within the 32-bit signed integer range.
*
* Example 1:
*
* Input: [1, -1, 5, -2, 3], k = 3
* Output: 4
* Explanation: The sub-array [1, -1, 5, -2] sums to 3 and is the longest.
* Example 2:
*
* Input: [-2, -1, 2, 1], k = 1
* Output: 2
* Explanation: The sub array [-1, 2] sums to 1 and is the longest.
* Follow Up:
* Can you do it in O(n) time?
* */
@Singleton
class MaximumSizeSubArraySumEqualsK @Inject constructor() : Solution<Pair<IntArray, Int>, Int> {

    override fun getName() = "MaxSubArrayLength"

    override fun solve(solutionIn: Pair<IntArray, Int>?): Int {
        solutionIn?.let {
            firstAttempt(it)
        }
        throw Exception(EMPTY_SOLUTION_IN)
    }

    /*
    * Runtime: 480 ms, faster than 10.00% of Kotlin online submissions for Maximum Size Subarray Sum Equals k.
    * Memory Usage: 39.4 MB, less than 100.00% of Kotlin online submissions for Maximum Size Subarray Sum Equals k.
    * */
    fun firstAttempt(solutionIn: Pair<IntArray, Int>): Int {

        var intArray = solutionIn.first
        val target = solutionIn.second

        if (intArray.size == 1 && intArray[0] == target) return 1

        var maxLength = 0
        var isFound = false


        for (index in intArray.indices) {
            var sumToTarget = intArray[index]
            var length: Int
            if (intArray[index] == target) maxLength = max(maxLength, 1)
            for (subIndex in index + 1 until intArray.size) {
                sumToTarget += intArray[subIndex]
                if (sumToTarget == target) {
                    isFound = true
                    length = subIndex - index
                    maxLength = max(maxLength, length)
                }
            }
        }
        return if (isFound) maxLength + 1 else maxLength
    }
}

//TODO: Use the main as test cases for Unit Test
//fun main() {
//    var test = Pair(intArrayOf(1), 1)
//    var test = Pair(intArrayOf(-1), 1)
//    var test = Pair(intArrayOf(-1, 1), 1)
//    var test = Pair(intArrayOf(1, -1), 1)
//    var test = Pair(intArrayOf(), 0)
//    var test = Pair(intArrayOf(1, -1, 5, -2, 3), 3)
//    var test = Pair(intArrayOf(-2, -1, 2, 1), 1)
//    var test = Pair(intArrayOf(-2,1,-3,4,-1,2,1,-5,4), 1)
//    println(MaxSubArrayLength().firstAttempt(test))
//}