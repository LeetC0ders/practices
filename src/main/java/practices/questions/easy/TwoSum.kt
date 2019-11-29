package practices.questions.easy

import practices.questions.EMPTY_SOLUTION_IN
import practices.questions.Solution
import javax.inject.Inject
import javax.inject.Singleton

/*
* 001-TwoSum
*
* Question:
* Given an array of integers, return indices of the two numbers such that they add up to a specific target
*
* - You may assume that each input would have exactly one solution, and you may not use the same element twice.
*
* Example:
* Give nums = [2, 7, 11, 15] target = 9
*
* Return value should be [0] + [1] = 2 + 7 = 9
* returns -> [0, 1] The indices
*
* */
@Singleton
class TwoSum @Inject constructor() : Solution<Pair<IntArray, Int>, IntArray> {

    override fun getName() = "TwoSum"

    override fun solve(solutionIn: Pair<IntArray, Int>?): IntArray {
        solutionIn?.let {
            return secondAttempt(it)
        }
        throw Exception(EMPTY_SOLUTION_IN)
    }

    // Since this problem can have multiple implementation, we will have separate implementations

    /*
    * Runtime: 236 ms, faster than 30.21% of Kotlin online submissions for Two Sum.
    * Memory Usage: 37.3 MB, less than 81.82% of Kotlin online submissions for Two Sum.
    * */
    fun firstAttempt(solutionIn: Pair<IntArray, Int>): IntArray {
        val intArray = solutionIn.first
        val target = solutionIn.second
        val mutableMap: MutableMap<Int, Int> = HashMap()

        for (index in 0 until intArray.size) {
            val mapKey = target - intArray[index]
            if (mutableMap.containsKey(intArray[index])) return intArrayOf(mutableMap[intArray[index]]!!, index)
            else if (!mutableMap.containsKey(mapKey)) mutableMap[mapKey] = index
        }

        // return [0], if nothing is found
        return intArrayOf(0)
    }

    /*
    * Runtime: 188 ms, faster than 69.54% of Kotlin online submissions for Two Sum.
    * Memory Usage: 37.1 MB, less than 90.91% of Kotlin online submissions for Two Sum.
    * */
    private fun secondAttempt(solutionIn: Pair<IntArray, Int>): IntArray {
        val intArray = solutionIn.first
        val target = solutionIn.second
        val mutableMap: MutableMap<Int, Int> = HashMap()

        for (index in 0 until intArray.size) {
            if (!mutableMap.containsKey(intArray[index])) mutableMap[target - intArray[index]] = index
            else return intArrayOf(mutableMap[intArray[index]]!!, index)
        }

        // return [0], if nothing is found
        return intArrayOf(0)
    }
}