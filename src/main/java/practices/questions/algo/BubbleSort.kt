package practices.questions.algo

import practices.questions.EMPTY_SOLUTION_IN
import practices.questions.Solution
import javax.inject.Inject
import javax.inject.Singleton

// In place bubble sort
// O(N^2)
@Singleton
class BubbleSort @Inject constructor(): Solution<IntArray, Unit> {

    override fun getName() = "BubbleSort"

    override fun solve(solutionIn: IntArray?) {
        solutionIn?.let {
            firstAttempt(it)
            return
        }
        throw Exception(EMPTY_SOLUTION_IN)
    }

    fun firstAttempt(intArray: IntArray) {

        var isSorted = false

        fun pass() {
            var isCalled = false
            for (index in 0 until intArray.size - 1) {
                if (intArray[index] > intArray[index+1]) {
                    isCalled = true
                    val temp = intArray[index]
                    intArray[index] = intArray[index+1]
                    intArray[index+1] = temp
                }
            }
            isSorted = !isCalled
        }

        while (!isSorted) {
            pass()
        }
    }
}

//TODO: Use main as the base class for the Unit Test
//fun main() {
//    val testArr = intArrayOf(2,1,3,5,1,6,10,9)
//    BubbleSort().firstAttempt(testArr)
//    testArr.forEach {
//        print("$it, ")
//    }
//}