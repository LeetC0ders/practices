package practices.questions.algo

import practices.questions.EMPTY_SOLUTION_IN
import practices.questions.Solution
import javax.inject.Inject
import javax.inject.Singleton

//In place selection sort
@Singleton
class SelectionSort @Inject constructor(): Solution<IntArray, Unit> {

    override fun getName() = "SelectionSort"

    override fun solve(solutionIn: IntArray?) {
        solutionIn?.let {
            firstAttempt(it)
            return
        }
        throw Exception(EMPTY_SOLUTION_IN)
    }

    fun firstAttempt(intArray: IntArray) {
        var tempValueHolder: Int?
        var startIndex = 0
        var thatMinIndex = 0
        while (startIndex < intArray.size) {
            var min = Int.MAX_VALUE
            for (index in startIndex until intArray.size) {
                if (intArray[index] < min) {
                    min = intArray[index]
                    thatMinIndex = index
                }
            }
            tempValueHolder = intArray[startIndex]
            intArray[startIndex] = min
            intArray[thatMinIndex] = tempValueHolder
            startIndex++
        }
    }
}

//TODO: Use main as the base class for the Unit Test
//fun main() {
//    var testData = intArrayOf(7,9,2,3,1,0)
//    SelectionSort().firstAttempt(testData)
//    testData.forEach {
//        print("$it, ")
//    }
//}