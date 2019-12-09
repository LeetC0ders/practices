package practices.questions.easy

import practices.questions.Solution

class HouseRobber : Solution<IntArray, Int> {

    override fun getName() = "HouseRobber"

    override fun solve(solutionIn: IntArray?): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    fun firstAttempt(solutionIn: IntArray): Int {
        var prevMax = 0
        var currMax = 0

        for (x in solutionIn) {
            val temp = currMax
            currMax = Math.max(prevMax + x, currMax)
            prevMax = temp
        }

        return currMax
    }

    fun secondAttempt(solutionIn: IntArray): Int {

        var max1 = 0
        var max2 = 0

        for (index in 0 until solutionIn.size step 2) {
            max1 += solutionIn[index]
        }

        for (index in 1 until solutionIn.size step 2) {
            max2 += solutionIn[index]
        }

        return Math.max(max1, max2)
    }
}