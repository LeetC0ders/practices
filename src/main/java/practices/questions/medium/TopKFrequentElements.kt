package practices.questions.medium

import practices.questions.EMPTY_SOLUTION_IN
import practices.questions.Solution
import java.util.*
import javax.inject.Inject
import javax.inject.Singleton
import kotlin.Comparator
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

/*
* 347 - problem - Top K Frequent Elements
* Given a non-empty array of integers, return the k most frequent elements.
*
* Example 1:
*
* Input: intArr = [1,1,1,2,2,3], k = 2
* Output: [1,2]
* Example 2:
*
* Input: intArr = [1], k = 1
* Output: [1]
* Note:
*
* You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
* Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
* */
@Singleton
class TopKFrequentElements @Inject constructor() : Solution<Pair<IntArray, Int>, List<Int>> {

    override fun getName() = "TopKFrequentElements"

    override fun solve(solutionIn: Pair<IntArray, Int>?): List<Int> {
        solutionIn?.let {
            return firstAttempt(solutionIn.first, solutionIn.second)
        }
        throw Exception(EMPTY_SOLUTION_IN)
    }

    /*
    * Runtime: 264 ms, faster than 66.67% of Kotlin online submissions for Top K Frequent Elements.
    * Memory Usage: 43.1 MB, less than 66.67% of Kotlin online submissions for Top K Frequent Elements.
    * O(NLog(N))
    * */
    fun firstAttempt(intArr: IntArray, k: Int): List<Int> {

        val comparator = Comparator<Pair<Int, Int>> { p1, p2 ->
            when {
                p1.second > p2.second -> -1
                p1.second == p2.second -> 0
                else -> 1
            }
        }

        val map: MutableMap<Int, Pair<Int, Int>> = HashMap()
        val pq: PriorityQueue<Pair<Int, Int>> = PriorityQueue(comparator)
        val returnArr: MutableList<Int> = ArrayList()

        for (int in intArr) {
            if (!map.contains(int)) {
                map[int] = Pair(int, 1)
            } else {
                val count = (map[int] as Pair<Int, Int>).second + 1
                map[int] = Pair(int, count)
            }
        }
        for ((_, value) in map) pq.add(value)
        for (index in 0 until k) returnArr.add(pq.poll().first)
        return returnArr
    }
}

//TODO: Use main as Unit Test base cases
//fun main() {
//    val intArray = intArrayOf(1,1,1,2,2,3)
//    val ans = TopKFrequentElements().firstAttempt(intArray, 2)
//    ans.forEach {
//        print("$it, ")
//    }
//}