package practices.questionstest.mediumtest

import org.junit.After
import org.junit.Before
import org.junit.Test

import org.junit.Assert.*
import practices.di.DaggerDataStructureComponent
import practices.di.DaggerTestAppComponent
import practices.intArrayToString
import practices.questions.medium.CountingBits

class CountingBitsTest {

    private lateinit var countingBits: CountingBits

    @Before
    fun setUp() {
        countingBits = DaggerTestAppComponent
                .builder()
                .dataStructureComponent(DaggerDataStructureComponent.create())
                .build()
                .provideCountingBits()
    }

    @After
    fun tearDown() { /* no - op */}

    @Test
    fun getNameTest() {
        assertEquals("CountingBits", countingBits.getName())
    }

    /*
     * Test: Pair(passedInParam, output)
     * CountingBit solve() implementation is secondAttempt(), so ```fun secondAttemptTest()``` is not needed
    */
    @Test
    fun solveTest1() {
        val test = Pair(0, intArrayOf(0))
        assertEquals(intArrayToString(test.second), intArrayToString(countingBits.solve(test.first)))
    }

    @Test
    fun solveTest2() {
        val test = Pair(1, intArrayOf(0,1))
        assertEquals(intArrayToString(test.second), intArrayToString(countingBits.solve(test.first)))
    }

    @Test
    fun solveTest3() {
        val test = Pair(5, intArrayOf(0,1,1,2,1,2))
        assertEquals(intArrayToString(test.second), intArrayToString(countingBits.solve(test.first)))
    }

    @Test
    fun solveTest4() {
        val test = Pair(6, intArrayOf(0,1,1,2,1,2,2))
        assertEquals(intArrayToString(test.second), intArrayToString(countingBits.solve(test.first)))
    }

    @Test
    fun firstAttemptTest1() {
        val test = Pair(0, intArrayOf(0))
        assertEquals(intArrayToString(test.second), intArrayToString(countingBits.firstAttempt(test.first)))
    }

    @Test
    fun firstAttemptTest2() {
        val test = Pair(1, intArrayOf(0,1))
        assertEquals(intArrayToString(test.second), intArrayToString(countingBits.firstAttempt(test.first)))
    }

    @Test
    fun firstAttemptTest3() {
        val test = Pair(5, intArrayOf(0,1,1,2,1,2))
        assertEquals(intArrayToString(test.second), intArrayToString(countingBits.firstAttempt(test.first)))
    }

    @Test
    fun firstAttemptTest4() {
        val test = Pair(6, intArrayOf(0,1,1,2,1,2,2))
        assertEquals(intArrayToString(test.second), intArrayToString(countingBits.firstAttempt(test.first)))
    }
}