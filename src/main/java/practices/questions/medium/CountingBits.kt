package practices.questions.medium

import practices.questions.EMPTY_SOLUTION_IN
import practices.questions.Solution
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CountingBits @Inject constructor() : Solution<Int, IntArray> {
    override fun getName() = "CountingBits"

    override fun solve(solutionIn: Int?): IntArray {
        solutionIn?.let {
            secondAttempt(it)
        }
        throw Exception(EMPTY_SOLUTION_IN)
    }

    /*
    * Runtime: 168 ms, faster than 92.16% of Kotlin online submissions for Counting Bits.
    * Memory Usage: 38.4 MB, less than 100.00% of Kotlin online submissions for Counting Bits.
    * */
    fun secondAttempt(solutionIn: Int): IntArray {
        val result = IntArray(solutionIn + 1)
        for (int in 1..solutionIn) {
            result[int] = result[int shr 1] + (int and 1)
        }
        return result
    }

    /*
    * Runtime: 180 ms, faster than 56.86% of Kotlin online submissions for Counting Bits.
    * Memory Usage: 37.6 MB, less than 100.00% of Kotlin online submissions for Counting Bits.
    * */
    fun firstAttempt(solutionIn: Int): IntArray {
        var countArr = IntArray((solutionIn + 1))
        var currentNumber = 0
        for (int in 0 .. solutionIn) {
            var binaryString = int.toString(2)
            for (char in binaryString) {
                when(char) {
                    '1' -> countArr[currentNumber]++
                    else-> Unit
                }
            }
            currentNumber++
        }
        return countArr
    }
}