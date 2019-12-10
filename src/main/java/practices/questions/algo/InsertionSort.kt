package practices.questions.algo

import practices.questions.EMPTY_SOLUTION_IN
import practices.questions.Solution

class InsertionSort: Solution<IntArray, Unit> {

    override fun getName() = "InsertionSort"

    override fun solve(solutionIn: IntArray?) {
        solutionIn?.let {
            firstAttempt(it)
            return
        }
        throw Exception(EMPTY_SOLUTION_IN)
    }

    fun firstAttempt(intArray: IntArray) {

        for (index in 1 until intArray.size) {
            val key = intArray[index]
            var j = index - 1

            /* Move elements of arr[0..i-1], that are
               greater than key, to one position ahead
               of their current position */
            while (j >= 0 && intArray[j] > key) {
                intArray[j + 1] = intArray[j]
                j -= 1
            }
            intArray[j + 1] = key
        }
    }

}

//fun main() {
//    val intArray = intArrayOf(3,5,6,7,8,3,4,2,1)
//    InsertionSort().firstAttempt(intArray)
//    intArray.forEach {
//        print("$it, ")
//    }
//}