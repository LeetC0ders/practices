package practices.questions.easy

import practices.questions.EMPTY_SOLUTION_IN
import practices.questions.Solution
import javax.inject.Inject
import javax.inject.Singleton
import kotlin.math.max
import kotlin.math.min


/*
* 121 - problem - Best time to buy and sell stock
*
* Say you have an array for which the ith element is the price of a given stock on day i.
*
* If you were only permitted to complete at most one transaction (i.e., buy one and sell one share of the stock), design an algorithm to find the maximum profit.
*
* Note that you cannot sell a stock before you buy one.
*
* */
@Singleton
class BestTimeToBuyAndSellStock @Inject constructor() : Solution<IntArray, Int> {

    override fun getName() = "BestTimeToBuyAndSellStock"

    override fun solve(solutionIn: IntArray?): Int {
        solutionIn?.let {
            // firstAttempt(it)
            return secondAttempt(it)
        }
        throw Exception(EMPTY_SOLUTION_IN)
    }

    /*
    * One pass solution: O(n)
    * Runtime: 172 ms, faster than 91.91% of Kotlin online submissions for Best Time to Buy and Sell Stock.
    * Memory Usage: 36.2 MB, less than 100.00% of Kotlin online submissions for Best Time to Buy and Sell Stock.
    * */
    fun secondAttempt(solutionIn: IntArray): Int {

        var lowest = solutionIn[0]
        var maximum = 0

        for (index in 0 until solutionIn.size - 1) {
            if (solutionIn[index] > solutionIn[index + 1]) {
                // no - op
            } else {
                lowest = min(lowest, solutionIn[index])
            }

            if (lowest < solutionIn[index + 1]) {
                maximum = max(maximum, solutionIn[index + 1] - lowest)
            }
        }
        return maximum
    }

    /*
    * Brute force solution: O(n^2)
    * Runtime: 424 ms, faster than 9.71% of Kotlin online submissions for Best Time to Buy and Sell Stock.
    * Memory Usage: 39 MB, less than 100.00% of Kotlin online submissions for Best Time to Buy and Sell Stock.
    * */
    fun firstAttempt(solutionIn: IntArray): Int {

        var maxProfit = 0

        for (buyIndex in solutionIn.indices) {
            for (sellIndex in buyIndex + 1 until solutionIn.size) {
                maxProfit = max(maxProfit, solutionIn[sellIndex] - solutionIn[buyIndex])
            }
        }

        return maxProfit
    }

}

//TODO: use main as the base of Unit Test
//fun main() {
//    val testArr = intArrayOf(7,1,5,3,6,4)
//    val testArr = intArrayOf(7, 6, 4, 3, 1)
//    println(BestTimeToBuyAndSellStock().solve(testArr))
//}