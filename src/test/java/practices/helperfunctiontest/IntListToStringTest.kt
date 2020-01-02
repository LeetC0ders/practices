package practices.helperfunctiontest

import org.junit.Assert.*
import org.junit.Test
import practices.intListToString

class IntListToStringTest {

    @Test
    fun intListToStringTest1() {
        assertEquals("[1,2,3,]", intListToString(listOf(1,2,3)))
    }

    @Test
    fun intListToStringTest2() {
        assertEquals("[0,]", intListToString(listOf(0)))
    }

    @Test
    fun intListToStringTest3() {
        assertEquals("[]", intListToString(listOf()))
    }
}