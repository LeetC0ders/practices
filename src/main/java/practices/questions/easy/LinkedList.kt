package practices.questions.easy

import practices.datastructure.SinglyLinkedList
import practices.questions.EMPTY_SOLUTION_IN
import practices.questions.Solution

class LinkedList : Solution<Pair<SinglyLinkedList.ListNode?, SinglyLinkedList.ListNode?>, SinglyLinkedList.ListNode?> {
    override fun getName(): String {
        return "linked list"
    }

    override fun solve(solutionIn: Pair<SinglyLinkedList.ListNode?, SinglyLinkedList.ListNode?>?): SinglyLinkedList.ListNode? {
        solutionIn?.let {
            firstAttempt(it)
        }
        throw Exception(EMPTY_SOLUTION_IN)
    }

    fun firstAttempt(solutionIn: Pair<SinglyLinkedList.ListNode?, SinglyLinkedList.ListNode?>): SinglyLinkedList.ListNode? {

        var headOfFirstList = solutionIn.first
        var headOfSecondList = solutionIn.second
        var headOfMergedList: SinglyLinkedList.ListNode? = SinglyLinkedList.ListNode(-1)
        val headOfMergedListRef = headOfMergedList

        // skipped if both list are null
        while (headOfFirstList != null || headOfSecondList != null) {

            when {
                //handle the case of [], and [1,3,5]
                (headOfFirstList != null && headOfSecondList == null) -> {
                    headOfMergedList?.next = SinglyLinkedList.ListNode(headOfFirstList.nodeValue)
                    headOfFirstList = headOfFirstList.next
                }
                //handle the case of [1,3,4] and []
                (headOfFirstList == null && headOfSecondList != null) -> {
                    headOfMergedList?.next = SinglyLinkedList.ListNode(headOfSecondList.nodeValue)
                    headOfSecondList = headOfSecondList.next
                }
                (headOfFirstList!!.nodeValue < headOfSecondList!!.nodeValue) -> {
                    headOfMergedList?.next = SinglyLinkedList.ListNode(headOfFirstList.nodeValue)
                    headOfFirstList = headOfFirstList.next
                }
                (headOfFirstList.nodeValue > headOfSecondList.nodeValue) -> {
                    headOfMergedList?.next = SinglyLinkedList.ListNode(headOfSecondList.nodeValue)
                    headOfSecondList = headOfSecondList.next
                }
                (headOfFirstList.nodeValue == headOfSecondList.nodeValue) -> {
                    headOfMergedList?.next = SinglyLinkedList.ListNode(headOfFirstList.nodeValue)
                    headOfFirstList = headOfFirstList.next
                }
            }

            headOfMergedList = headOfMergedList?.next

        }

        return headOfMergedListRef?.next
    }
}