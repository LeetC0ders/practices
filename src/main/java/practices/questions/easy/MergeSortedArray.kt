package practices.questions.easy

import practices.questions.EMPTY_SOLUTION_IN
import practices.questions.Solution
import javax.inject.Inject
import javax.inject.Singleton

/*
* 88-problem-merge sorted array
* Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
*
* Note:
*
* The number of elements initialized in nums1 and nums2 are m and n respectively.
* You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2.
* Example:
*
* Input:
* nums1 = [1,2,3,0,0,0], m = 3
* nums2 = [2,5,6],       n = 3
*
* Output: [1,2,2,3,5,6]
* */
@Singleton
class MergeSortedArray @Inject constructor(): Solution<MergeSortedArray.ParamsIn, Unit> {

    data class ParamsIn(
            var nums1: IntArray,
            val m: Int,
            var nums2: IntArray,
            val n: Int
    )

    override fun getName() = "MergeSortedArray"

    override fun solve(solutionIn: ParamsIn?) {
        solutionIn?.let {
            firstAttempt(it.nums1, it.m, it.nums2, it.n)
            return
        }
        throw Exception(EMPTY_SOLUTION_IN)
    }

    /*
    * Runtime: 172 ms, faster than 41.30% of Kotlin online submissions for Merge Sorted Array.
    * Memory Usage: 33 MB, less than 100.00% of Kotlin online submissions for Merge Sorted Array.
    * This is an O(n) solution
    * */
    fun firstAttempt(numsOne: IntArray, m: Int, numsTwo: IntArray, n: Int) {
        val nums1 = numsOne
        val nums2 = numsTwo
        if (m == 0 && n == 0) for (index in 0 until nums1.size) numsOne[index] = 0 //clear array 1
        else if (m == 0 && n != 0) {
            for (index in 0 until nums1.size) numsTwo[index] = 0 //clear array 1
            for (index in 0 until n) nums1[index] = nums2[index]
        } else if (m != 0 && n == 0) return

        val nums1After = IntArray(m)
        val nums2After = IntArray(n)
        val returnArray = nums1

        for (index in 0 until m) nums1After[index] = nums1[index]
        for (index in 0 until n) nums2After[index] = nums2[index]

        var index1 = 0
        var index2 = 0
        var returnIndex = 0

        while (index1 < nums1After.size || index2 < nums2After.size) {
            when {
                index1 < nums1After.size && index2 == nums2After.size -> {
                    returnArray[returnIndex] = nums1After[index1]
                    index1++
                }
                index1 == nums1After.size && index2 < nums2After.size -> {
                    returnArray[returnIndex] = nums2After[index2]
                    index2++
                }
                nums1After[index1] < nums2After[index2] -> {
                    returnArray[returnIndex] = nums1After[index1]
                    index1++
                }
                nums1After[index1] > nums2After[index2] -> {
                    returnArray[returnIndex] = nums2After[index2]
                    index2++
                }
                nums1After[index1] == nums2After[index2] -> {
                    returnArray[returnIndex] = nums1After[index1]
                    index1++
                }
            }
            returnIndex++
        }
    }
}

//TODO: use main as the base to create Unit Test
//fun main() {
//    val testData = MergeSortedArray.ParamsIn(
//            nums1 = intArrayOf(1,2,3,0,0,0),
//            m = 3,
//            nums2 = intArrayOf(3,8,5),
//            n = 3
//    )
//    MergeSortedArray().solve(testData)
//    testData.nums1.forEach {
//        print("$it, ")
//    }
//}