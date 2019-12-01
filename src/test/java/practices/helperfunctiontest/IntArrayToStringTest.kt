package practices.helperfunctiontest

import org.junit.Assert.assertEquals
import org.junit.Test
import practices.intArrayToString

class IntArrayToStringTest {

    @Test
    fun intArrayToStringTest1() {
        assertEquals("[1,2,3,]", intArrayToString(intArrayOf(1, 2, 3)))
    }

    @Test
    fun intArrayToStringTest2() {
        assertEquals("[0,]", intArrayToString(intArrayOf(0)))
    }

    @Test
    fun intArrayToStringTest3() {
        assertEquals("[]", intArrayToString(intArrayOf()))
    }
}