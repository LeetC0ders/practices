package practices.questionstest.mediumtest

import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import practices.datastructure.SinglyLinkedList
import practices.datastructure.SinglyLinkedList.ListNode
import practices.di.DaggerDataStructureComponent
import practices.di.DaggerTestAppComponent
import practices.questions.medium.AddTwoNumbers
import practices.singlyLinkedListToString

class AddTwoNumbersTest {

    lateinit var addTwoNumbers: AddTwoNumbers

    @Before
    fun setUp() {
        addTwoNumbers = DaggerTestAppComponent.builder().dataStructureComponent(DaggerDataStructureComponent.create())
                .build().provideAddTwoNumbers()
    }

    @Test
    fun getNameTest() {
        assertEquals("AddTwoNumbers", addTwoNumbers.getName())
    }

    @Test
    fun solve1() {
        val firstListNode = SinglyLinkedList.ListNode(5)
        val secondListNode = SinglyLinkedList.ListNode(5)
        val solutionIn = Pair(firstListNode, secondListNode)
        assertEquals("[0,1,]", singlyLinkedListToString(addTwoNumbers.firstAttempt(solutionIn)))
        assertEquals("[0,1,]", singlyLinkedListToString(addTwoNumbers.solve(solutionIn)))
    }

    @Test
    fun solve2() {
        val firstListNode = ListNode(2).apply {
            next = ListNode(4)
            next?.next = ListNode(3)
        }
        val secondListNode = ListNode(5).apply {
            next = ListNode(6)
            next?.next = ListNode(4)
        }
        val solutionIn = Pair(firstListNode, secondListNode)
        var answer = addTwoNumbers.firstAttempt(solutionIn)
        assertEquals("[7,0,8,]", singlyLinkedListToString(addTwoNumbers.firstAttempt(solutionIn)))
        assertEquals("[7,0,8,]", singlyLinkedListToString(addTwoNumbers.solve(solutionIn)))
    }

    @Test
    fun solve3() {
        val firstListNode = ListNode(0).apply {
            next = ListNode(4)
        }
        val secondListNode = ListNode(0).apply {
            next = ListNode(6)
        }
        val solutionIn = Pair(firstListNode, secondListNode)
        var answer = addTwoNumbers.firstAttempt(solutionIn)
        assertEquals("[0,0,1,]", singlyLinkedListToString(addTwoNumbers.firstAttempt(solutionIn)))
        assertEquals("[0,0,1,]", singlyLinkedListToString(addTwoNumbers.solve(solutionIn)))
    }

    @Test
    fun solve4() {
        val firstListNode = ListNode(0).apply {
            next = ListNode(0)
            next?.next = ListNode(1)
        }
        val secondListNode = ListNode(5).apply {
            next = ListNode(6)
            next?.next = ListNode(4)
        }
        val solutionIn = Pair(firstListNode, secondListNode)
        var answer = addTwoNumbers.firstAttempt(solutionIn)
        assertEquals("[5,6,5,]", singlyLinkedListToString(addTwoNumbers.firstAttempt(solutionIn)))
        assertEquals("[5,6,5,]", singlyLinkedListToString(addTwoNumbers.solve(solutionIn)))
    }

    @Test
    fun solve5() {
        val firstListNode = ListNode(2).apply {
            next = ListNode(4)
            next?.next = ListNode(3)
        }
        val secondListNode = ListNode(0)
        val solutionIn = Pair(firstListNode, secondListNode)
        var answer = addTwoNumbers.firstAttempt(solutionIn)
        assertEquals("[2,4,3,]", singlyLinkedListToString(addTwoNumbers.firstAttempt(solutionIn)))
        assertEquals("[2,4,3,]", singlyLinkedListToString(addTwoNumbers.solve(solutionIn)))
    }

    @After
    fun tearDown() {
        // no - op
    }

}