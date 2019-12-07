package practices.questions.easy

import practices.datastructure.SinglyLinkedList
import practices.questions.EMPTY_SOLUTION_IN
import practices.questions.Solution
import javax.inject.Inject
import javax.inject.Singleton

/*
* 21-Problem - Merge Two Sorted List
* Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.
*
* NOTE: Return a new list, and you are not allowed to cause side effects
*
* Example:
* Input: 1->2->4, 1->3->4
* Output: 1->1->2->3->4->4
* */
@Singleton
class MergeTwoSortedList @Inject constructor() : Solution<Pair<SinglyLinkedList.ListNode?, SinglyLinkedList.ListNode?>, SinglyLinkedList.ListNode?> {

    override fun getName() = "MergeTwoSortedList"

    // input & output both can be nullable
    override fun solve(solutionIn: Pair<SinglyLinkedList.ListNode?, SinglyLinkedList.ListNode?>?): SinglyLinkedList.ListNode? {
        solutionIn?.let { return firstAttempt(it) }
        throw Exception(EMPTY_SOLUTION_IN)
    }

    /*
    * Runtime: 160 ms, faster than 67.09% of Kotlin online submissions for Merge Two Sorted Lists.
    * Memory Usage: 32.9 MB, less than 100.00% of Kotlin online submissions for Merge Two Sorted Lists.
    * */
    fun firstAttempt(solutionIn: Pair<SinglyLinkedList.ListNode?, SinglyLinkedList.ListNode?>): SinglyLinkedList.ListNode? {
        val operateSolutionIn: Pair<SinglyLinkedList.ListNode?, SinglyLinkedList.ListNode?> = solutionIn.copy()
        return when {
            //handle some edge case
            operateSolutionIn.first == null && operateSolutionIn.second == null -> null
            operateSolutionIn.first != null && operateSolutionIn.second == null -> operateSolutionIn.first
            operateSolutionIn.first == null && operateSolutionIn.second != null -> operateSolutionIn.second
            //returnNodeRef.next() = ans list start node, we do operation on return Node
            else -> {
                var firstListHead = operateSolutionIn.first
                var secondListHead = operateSolutionIn.second

                var returnNode: SinglyLinkedList.ListNode? = SinglyLinkedList.ListNode(-1)
                val returnNodeRef = returnNode

                //returnNodeRef.next() = ans list start node, we do operation on return Node
                while (firstListHead != null || secondListHead != null) {
                    when {
                        firstListHead == null -> {
                            returnNode?.next = SinglyLinkedList.ListNode(secondListHead!!.nodeValue)
                            secondListHead = secondListHead.next
                        }
                        secondListHead == null -> {
                            returnNode?.next = SinglyLinkedList.ListNode(firstListHead.nodeValue)
                            firstListHead = firstListHead.next
                        }
                        firstListHead.nodeValue > secondListHead.nodeValue -> {
                            returnNode?.next = SinglyLinkedList.ListNode(secondListHead.nodeValue)
                            secondListHead = secondListHead.next
                        }
                        firstListHead.nodeValue < secondListHead.nodeValue -> {
                            returnNode?.next =  SinglyLinkedList.ListNode(firstListHead.nodeValue)
                            firstListHead = firstListHead.next
                        }
                        firstListHead.nodeValue == secondListHead.nodeValue -> {
                            returnNode?.next =  SinglyLinkedList.ListNode(firstListHead.nodeValue)
                            firstListHead = firstListHead.next
                        }
                    }
                    returnNode = returnNode?.next
                }
                returnNodeRef?.next
            }
        }
    }
}

//TODO: Use this for Unit test
//fun main() {
//    val expendingListNodeHead: SinglyLinkedList.ListNode = SinglyLinkedList.ListNode(1).apply {
//        next = SinglyLinkedList.ListNode(2)
//        next?.next = SinglyLinkedList.ListNode(3)
//        next?.next?.next = SinglyLinkedList.ListNode(4)
//        next?.next?.next?.next = SinglyLinkedList.ListNode(5)
//    }
//    val expendingListNodeHead2: SinglyLinkedList.ListNode = SinglyLinkedList.ListNode(2).apply {
//        next = SinglyLinkedList.ListNode(6)
//        next?.next = SinglyLinkedList.ListNode(7)
//        next?.next?.next = SinglyLinkedList.ListNode(8)
//        next?.next?.next?.next = SinglyLinkedList.ListNode(9)
//    }
//    fun listIterator(listNode: SinglyLinkedList.ListNode?) {
//        var listNodeBk: SinglyLinkedList.ListNode? = listNode
//        while (listNodeBk != null) {
//            print("${listNodeBk.nodeValue}, ")
//            listNodeBk = listNodeBk?.next
//        }
//    }
//    listIterator(expendingListNodeHead)
//    println()
//    listIterator(expendingListNodeHead2)
//    println()
//    val result = MergeTwoSortedList().firstAttempt(Pair(expendingListNodeHead, expendingListNodeHead2))
//    val result2 = MergeTwoSortedList().firstAttempt(Pair(null, null))
//    val result3 = MergeTwoSortedList().firstAttempt(Pair(null, expendingListNodeHead))
//    val result4 = MergeTwoSortedList().firstAttempt(Pair(expendingListNodeHead, null))
//
//    listIterator(result)
//    println()
//    listIterator(result2)
//    println()
//    listIterator(result3)
//    println()
//    listIterator(result4)
//    println()
//    println("---")
//    listIterator(expendingListNodeHead)
//    println()
//    listIterator(expendingListNodeHead2)
//    println()
//}