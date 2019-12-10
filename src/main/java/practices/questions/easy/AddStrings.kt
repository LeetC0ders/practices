package practices.questions.easy

import practices.questions.EMPTY_SOLUTION_IN
import practices.questions.Solution
import java.lang.StringBuilder
import java.util.*
import javax.inject.Inject
import javax.inject.Singleton
import kotlin.collections.HashMap

/*
* 415 - problem - Add Strings
* Given two non-negative integers num1 and num2 represented as string, return the sum of num1 and num2.
*
* Note:
*
* The length of both num1 and num2 is < 5100.
* Both num1 and num2 contains only digits 0-9.
* Both num1 and num2 does not contain any leading zero.
* You must not use any built-in BigInteger library or convert the inputs to integer directly.
* */
@Singleton
class AddStrings @Inject constructor() : Solution<Pair<String, String>, String> {
    override fun getName() = "AddStrings"

    override fun solve(solutionIn: Pair<String, String>?): String {
        solutionIn?.let {
            return firstAttempt(solutionIn.first, solutionIn.second)
        }
        throw Exception(EMPTY_SOLUTION_IN)
    }

    /*
    * Runtime: 236 ms, faster than 20.83% of Kotlin online submissions for Add Strings.
    * Memory Usage: 39.6 MB, less than 100.00% of Kotlin online submissions for Add Strings.
    * O(C*N) solution
    * */
    fun firstAttempt(num1: String, num2: String): String {

        val reversedNum1 = num1.reversed()
        val reversedNum2 = num2.reversed()

        fun condition1(index1: Int) = index1 < reversedNum1.length
        fun condition2(index2: Int) = index2 < reversedNum2.length
        fun Char.charToInt(): Int {
            val map = HashMap<Char, Int>().apply {
                this['0'] = 0
                this['1'] = 1
                this['2'] = 2
                this['3'] = 3
                this['4'] = 4
                this['5'] = 5
                this['6'] = 6
                this['7'] = 7
                this['8'] = 8
                this['9'] = 9
            }
            return map[this]!!
        }

        var numberStack: Stack<Int> = Stack()
        var carry = 0
        var index1 = 0
        var index2 = 0

        while (condition1(index1) || condition2(index2)) {
            var int1 = 0
            var int2 = 0

            if (!condition1(index1)) int2 = reversedNum2[index2].charToInt()
            else if (!condition2(index2)) int1 = reversedNum1[index1].charToInt()
            else {
                int1 = reversedNum1[index1].charToInt()
                int2 = reversedNum2[index2].charToInt()
            }

            var sum = int1 + int2 + carry

            carry = when (sum >= 10) {
                true -> {
                    sum -= 10
                    1
                }
                else -> 0
            }
            numberStack.push(sum)
            index1++
            index2++
        }

        if (carry != 0) numberStack.push(carry)

        return StringBuilder().apply {
            while (numberStack.isNotEmpty()) {
                append(numberStack.pop())
            }
        }.toString()
    }
}

//TODO: Use main as a base class for Unit Test
//fun main() {
//    val test1 = "1"
//    val test2 = "99"
//    print(AddStrings().firstAttempt(test1, test2))
//}