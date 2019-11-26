package practices.questionstest.easytest

import org.junit.Assert.assertEquals
import org.junit.After
import org.junit.Before
import org.junit.Test
import practices.di.DaggerTestAppComponent
import practices.intArrayToString
import practices.questions.easy.TwoSum

class TwoSumTest {

    private lateinit var twoSum: TwoSum

    @Before
    fun setUp() {
        twoSum = DaggerTestAppComponent.create().provideTwoSum()
    }

    @Test
    fun getNameTest() {
        assertEquals("TwoSum", twoSum.getName())
    }

    @Test
    fun solve1() {
        val testPairVal = Pair(intArrayOf(1, 4, 6, 7, 8), 8)
        val correctSolution = intArrayOf(0, 3)
        assertEquals(intArrayToString(correctSolution), intArrayToString(twoSum.firstAttempt(testPairVal)))
        assertEquals(intArrayToString(correctSolution), intArrayToString(twoSum.solve(testPairVal)))
    }

    @Test
    fun solve2() {
        val testPairVal = Pair(intArrayOf(0, 4, 4, 8), 8)
        val correctSolution = intArrayOf(1, 2)
        assertEquals(intArrayToString(correctSolution), intArrayToString(twoSum.firstAttempt(testPairVal)))
        assertEquals(intArrayToString(correctSolution), intArrayToString(twoSum.solve(testPairVal)))
    }

    @Test
    fun solve3() {
        val testPairVal = Pair(intArrayOf(0, 0, 0, 0, 0), 0)
        val correctSolution = intArrayOf(0, 1)
        assertEquals(intArrayToString(correctSolution), intArrayToString(twoSum.firstAttempt(testPairVal)))
        assertEquals(intArrayToString(correctSolution), intArrayToString(twoSum.solve(testPairVal)))
    }

    @Test
    fun solve4() {
        val testPairVal = Pair(intArrayOf(0, 0, 0, 0, 1), 1)
        val correctSolution = intArrayOf(0, 4)
        assertEquals(intArrayToString(correctSolution), intArrayToString(twoSum.firstAttempt(testPairVal)))
    }

    @Test
    fun solve4Alternative() {
        val testPairVal = Pair(intArrayOf(0, 0, 0, 0, 1), 1)
        val correctSolution = intArrayOf(3, 4)
        assertEquals(intArrayToString(correctSolution), intArrayToString(twoSum.solve(testPairVal)))
    }

    @Test
    fun solve5() {
        val testPairVal = Pair(intArrayOf(1, 1), 2)
        val correctSolution = intArrayOf(0, 1)
        assertEquals(intArrayToString(correctSolution), intArrayToString(twoSum.firstAttempt(testPairVal)))
        assertEquals(intArrayToString(correctSolution), intArrayToString(twoSum.solve(testPairVal)))
    }

    @Test
    fun solve6() {
        val testPairVal = Pair(intArrayOf(2, 7, 11, 15), 9)
        val correctSolution = intArrayOf(0, 1)
        assertEquals(intArrayToString(correctSolution), intArrayToString(twoSum.firstAttempt(testPairVal)))
        assertEquals(intArrayToString(correctSolution), intArrayToString(twoSum.solve(testPairVal)))
    }

    @Test
    fun exceptionTest() {
        val testPair = null
        try {
            twoSum.solve(testPair)
        } catch (exception: Exception) {
            assertEquals("Empty solutionIn", exception.message)
        }
    }

    @After
    fun tearDown() {
        // no - op
    }
}