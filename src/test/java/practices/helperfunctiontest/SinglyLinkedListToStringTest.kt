package practices.helperfunctiontest

import org.junit.Assert
import org.junit.Before
import org.junit.Test
import practices.datastructure.SinglyLinkedList
import practices.datastructure.SinglyLinkedList.ListNode
import practices.singlyLinkedListToString

class SinglyLinkedListToStringTest {

    private lateinit var testListNode1: ListNode
    private lateinit var testListNode2: ListNode
    private lateinit var testListNode3: ListNode
    private lateinit var testListNode4: ListNode

    @Before
    fun setUp() {
        testListNode1 = SinglyLinkedList.ListNode(2).apply {
            next = SinglyLinkedList.ListNode(4)
            next?.next = SinglyLinkedList.ListNode(3)
        }
        testListNode2 = SinglyLinkedList.ListNode(5).apply {
            next = SinglyLinkedList.ListNode(6)
            next?.next = SinglyLinkedList.ListNode(4)
        }
        testListNode3 = SinglyLinkedList.ListNode(1).apply {
            next = SinglyLinkedList.ListNode(0)
            next?.next = SinglyLinkedList.ListNode(0)
        }
        testListNode4 = SinglyLinkedList.ListNode(1)
    }

    @Test
    fun singlyLinkedListToStringTest1() {
        Assert.assertEquals("[2,4,3,]", singlyLinkedListToString(testListNode1))
    }

    @Test
    fun singlyLinkedListToStringTest2() {
        Assert.assertEquals("[5,6,4,]", singlyLinkedListToString(testListNode2))
    }

    @Test
    fun singlyLinkedListToStringTest3() {
        Assert.assertEquals("[1,0,0,]",  singlyLinkedListToString(testListNode3))
    }

    @Test
    fun singlyLinkedListToStringTest4() {
        Assert.assertEquals("[1,]",  singlyLinkedListToString(testListNode4))
    }
}