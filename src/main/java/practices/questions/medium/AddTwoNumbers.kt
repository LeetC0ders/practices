package practices.questions.medium

import practices.datastructure.SinglyLinkedList
import practices.datastructure.SinglyLinkedList.ListNode
import practices.di.DaggerDataStructureComponent
import practices.questions.EMPTY_SOLUTION_IN
import practices.questions.Solution
import java.lang.Exception
import java.util.*
import javax.inject.Inject
import javax.inject.Singleton

/*
* 002-Add Two Numbers
*
* Question:
* You are given 2 non-empty linked lists representing 2 non-negative integers
* However, the digits are stored in reverse order and each of their nodes contains
* a single digit.
*
* You need to add these 2 numbers that is represented by the linked-list.
* And returned the result as a single Linked list node.
*
* You may assume the 2 numbers do not contain any leading zero, except the number 0 itself.
*
* Example:
* Given linked list:
*  - (2 -> 4 -> 3) and (5 -> 6 -> 4) // which is 342 and 465
*  - The output is = (7 -> 0 -> 8)   // which is 807 = 342 + 456
* */
@Singleton
class AddTwoNumbers @Inject constructor() : Solution<Pair<ListNode, ListNode>, ListNode> {

    @Inject lateinit var singlyLinkedList: SinglyLinkedList

    init {
        DaggerDataStructureComponent.create().inject(this)
    }

    override fun getName() = "AddTwoNumbers"

    override fun solve(solutionIn: Pair<ListNode, ListNode>?): ListNode {
        solutionIn?.let {
            return firstAttempt(it)
        }
        throw Exception(EMPTY_SOLUTION_IN)
    }

    //TODO: Add a better solution in WEEK 2
    fun secondAttempt(solutionIn: Pair<ListNode, ListNode>): ListNode {
        return ListNode(-1)
    }

    /*
    * Runtime: 212 ms, faster than 46.28% of Kotlin online submissions for Add Two Numbers.
    * Memory Usage: 40.4 MB, less than 83.33% of Kotlin online submissions for Add Two Numbers.
    * */
    fun firstAttempt(solutionIn: Pair<ListNode, ListNode>): ListNode {

        // recursive call could cause some issue if the number is too big
        fun iterateNodeToGenerateQueue(listNode: ListNode, returnQueue: Queue<Int>): Queue<Int> {
            if (listNode.next != null) {
                returnQueue.add(listNode.nodeValue)
                iterateNodeToGenerateQueue(listNode.next as ListNode, returnQueue)
            } else returnQueue.add(listNode.nodeValue)
            return returnQueue
        }

        val firstNodeForFirstNumber = solutionIn.first
        val firstNodeForSecondNumber = solutionIn.second
        val firstListQueue: Queue<Int> = iterateNodeToGenerateQueue(firstNodeForFirstNumber, returnQueue = LinkedList<Int>())
        val secondListQueue: Queue<Int> = iterateNodeToGenerateQueue(firstNodeForSecondNumber, returnQueue = LinkedList<Int>())
        val longerQueue = if (firstListQueue.size >= secondListQueue.size) firstListQueue else secondListQueue
        val shorterQueue = if (firstListQueue.size < secondListQueue.size) firstListQueue else secondListQueue

        var returnNodeHead = ListNode(-1)
        var returnNodeHeadBkup = returnNodeHead
        var overFlowDigit = 0

        // handle shorter node add
        while (shorterQueue.isNotEmpty()) {
            val lastDigitResult = shorterQueue.poll() + longerQueue.poll() + overFlowDigit
            overFlowDigit = if (lastDigitResult >= 10) 1 else 0
            returnNodeHead.next = ListNode(if (overFlowDigit > 0) lastDigitResult - 10 else lastDigitResult)
            returnNodeHead = returnNodeHead.next!!
        }

        while (longerQueue.isNotEmpty()) {
            val lastDigitResult = longerQueue.poll() + overFlowDigit
            overFlowDigit = if (lastDigitResult >= 10) 1 else 0
            returnNodeHead.next = ListNode(if (overFlowDigit > 0) lastDigitResult - 10 else lastDigitResult)
            returnNodeHead = returnNodeHead.next!!
        }

        if (overFlowDigit != 0) { returnNodeHead.next = ListNode(overFlowDigit) }

        return returnNodeHeadBkup.next!!
    }
}