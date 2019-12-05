package practices.questions.easy

import practices.questions.EMPTY_SOLUTION_IN
import practices.questions.Solution
import javax.inject.Inject
import javax.inject.Singleton

/*
* 448 - Find All Numbers Disappeared in an Array
* Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.
* Find all the elements of [1, n] inclusive that do not appear in this array.
* Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.
*
* Sample:
* in = [1, 1] out = [2]
* in = [4,3,2,7,8,2,3,1] out = [5, 6]
* in = [1, 2, 3] out = []
* */
@Singleton
class FindAllNumberDisappearedInArr @Inject constructor(): Solution<IntArray, List<Int>> {

    override fun getName() = "FindAllNumberDisappearedInArr"

    override fun solve(solutionIn: IntArray?): List<Int> {
        solutionIn?.let {
            firstAttempt(solutionIn)
        }
        throw Exception(EMPTY_SOLUTION_IN)
    }

    /*
    * Big O (2n) Best solution is O (n) this is very close, but does not look good on stats
    * Runtime: 416 ms, faster than 28.92% of Kotlin online submissions for Find All Numbers Disappeared in an Array.
    * Memory Usage: 50.1 MB, less than 100.00% of Kotlin online submissions for Find All Numbers Disappeared in an Array.
    * */
    fun firstAttempt(intArr: IntArray): List<Int> {

        var set: MutableSet<Int> = HashSet()
        var list: MutableList<Int> = ArrayList()
        var largestNumber = 0

        for (int in intArr) {
            largestNumber = if (int > largestNumber) int else largestNumber
            if (!set.contains(int)) set.add(int)
        }

        largestNumber = if (intArr.size > largestNumber) intArr.size else largestNumber

        for (int in 1..largestNumber) {
            if (!set.contains(int)) list.add(int)
        }


        return list
    }
}