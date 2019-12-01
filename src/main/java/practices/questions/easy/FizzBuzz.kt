package practices.questions.easy

import practices.questions.Solution
import javax.inject.Inject
import javax.inject.Singleton

/*
* 000-FizzBuzz
*
* Question:
* For the numbers from 1 to 100,
*
* - If the number is a multiple of 3, print "Fizz" instead of the number.
* - If the number is a multiple of 5, print "Buzz" instead of the number.
* - If the number is a multiple of 15, print "FizzBuzz" instead of the number.
* - Otherwise, print the number itself.
*
* Each output should be followed by a new line.
*
* */
@Singleton
class FizzBuzz @Inject constructor(): Solution<Int, Unit> {

    override fun getName() = "FizzBuzz"

    override fun solve(solutionIn: Int?) {
        solutionIn?.let {
            when {
                solutionIn % 3 == 0 && solutionIn % 5 == 0 -> print("FizzBuzz")
                solutionIn % 3 == 0 -> print("Fizz")
                solutionIn % 5 == 0 -> print("Buzz")
                solutionIn < 1 || solutionIn > 100 -> throw Exception("Number out of range")
                else -> print(solutionIn.toString())
            }
        }
    }

}