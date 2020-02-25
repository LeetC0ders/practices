package practices.datastructuretest

import org.junit.Assert.assertEquals
import org.junit.Test
import practices.datastructureimpl.StackImpl

class StackImplTest {

    @Test
    fun testPushSuccess() {
        val stackImpl: StackImpl<Int> = StackImpl(10)

        for (i in 0 until 10) {
            assertEquals(true, stackImpl.push(i))
        }
    }

    @Test
    fun testPushFail() {
        val stackImpl: StackImpl<Int> = StackImpl(10)
        try {
            for (i in 0 .. 10) {
                assertEquals(stackImpl.push(i), true)
            }
        } catch (exception: Exception) {
            assertEquals("Stack Over Flow", exception.message)
        }

    }

    @Test
    fun testPeek() {
        val stackImpl: StackImpl<Int> = StackImpl(10)
        for (i in 0 until 10) stackImpl.push(i)
        assertEquals(stackImpl.peek(), 9)
        assertEquals(stackImpl.peek(), 9)
        assertEquals(stackImpl.peek(), 9)
        assertEquals(stackImpl.peek(), 9)

        try {
            stackImpl.push(10)
        } catch (ignored: Exception) {}
        finally {
            assertEquals(stackImpl.peek(), 9)
            assertEquals(stackImpl.peek(), 9)
            assertEquals(stackImpl.peek(), 9)
        }
    }

    @Test
    fun testPopSuccess() {
        val stackImpl: StackImpl<Int> = StackImpl(10)
        for (i in 0 until 10) stackImpl.push(i)

        assertEquals(stackImpl.pop(), 9)
        assertEquals(stackImpl.pop(), 8)
        assertEquals(stackImpl.pop(), 7)
        assertEquals(stackImpl.pop(), 6)
        assertEquals(stackImpl.pop(), 5)
        assertEquals(stackImpl.pop(), 4)
        assertEquals(stackImpl.pop(), 3)
        assertEquals(stackImpl.pop(), 2)
        assertEquals(stackImpl.pop(), 1)
        assertEquals(stackImpl.pop(), 0)
    }

    @Test
    fun testPopFail() {
        val stackImpl: StackImpl<Int> = StackImpl(10)
        for (i in 0 until 10) stackImpl.push(i)

        assertEquals(stackImpl.pop(), 9)
        assertEquals(stackImpl.pop(), 8)
        assertEquals(stackImpl.pop(), 7)
        assertEquals(stackImpl.pop(), 6)
        assertEquals(stackImpl.pop(), 5)
        assertEquals(stackImpl.pop(), 4)
        assertEquals(stackImpl.pop(), 3)
        assertEquals(stackImpl.pop(), 2)
        assertEquals(stackImpl.pop(), 1)
        assertEquals(stackImpl.pop(), 0)
        try {
            stackImpl.pop()
        } catch (exception: java.lang.Exception) {
            assertEquals("Stack Under Flow", exception.message)
        }

    }
}