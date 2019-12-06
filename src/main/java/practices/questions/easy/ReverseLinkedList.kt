package practices.questions.easy

import practices.datastructure.SinglyLinkedList
import practices.questions.Solution
import java.util.*
import javax.inject.Inject
import javax.inject.Singleton

/*
* 206-Reverse Linked List
*
* Question:
* Reverse a singly linked list.
*
* Example:
* Input: 1->2->3->4->5->NULL
* Output: 5->4->3->2->1->NULL
*
* Each output should be followed by a new line.
*
* Follow up:
* A linked list can be reversed either iteratively or recursively.
* Could you implement both?
* */
@Singleton
class ReverseLinkedList @Inject constructor(): Solution<SinglyLinkedList.ListNode?, SinglyLinkedList.ListNode?> {

    override fun getName() = "ReverseLinkedList"

    // No Exception thrown for this one, consider the case of nullable ListNode
    override fun solve(solutionIn: SinglyLinkedList.ListNode?): SinglyLinkedList.ListNode? {
        return firstAttempt(solutionIn)
    }

    /*
    * Runtime: 156 ms, faster than 70.41% of Kotlin online submissions for Reverse Linked List.
    * Memory Usage: 33.6 MB, less than 100.00% of Kotlin online submissions for Reverse Linked List.
    * */
    fun firstAttempt(head: SinglyLinkedList.ListNode?): SinglyLinkedList.ListNode? {
        var expendingListNodeHead: SinglyLinkedList.ListNode? = SinglyLinkedList.ListNode(-1)
        var expendingListNodeHeadRef = expendingListNodeHead
        var stack: Stack<Int> = Stack()
        fun recursiveHelperFunction(node: SinglyLinkedList.ListNode?) {
            if (node == null) return;
            stack.push(node.nodeValue)
            recursiveHelperFunction(node.next)
        }
        recursiveHelperFunction(head)
        while (stack.isNotEmpty()) {
            expendingListNodeHead?.next = SinglyLinkedList.ListNode(stack.pop())
            expendingListNodeHead = expendingListNodeHead?.next
        }
        return expendingListNodeHeadRef?.next
    }
}

//TODO: Use this for the future Unit Test
//fun main() {
//    var expendingListNodeHead: SinglyLinkedList.ListNode? = SinglyLinkedList.ListNode(1).apply {
//        next = SinglyLinkedList.ListNode(2)
//        next?.next = SinglyLinkedList.ListNode(3)
//        next?.next?.next = SinglyLinkedList.ListNode(4)
//        next?.next?.next?.next = SinglyLinkedList.ListNode(5)
//    }
//
//    val result = ReverseLinkedList().firstAttempt(expendingListNodeHead)
//    fun printResult(result: SinglyLinkedList.ListNode?) {
//        if (result == null) return
//        print("${result.nodeValue}, ")
//        printResult(result.next)
//    }
//    printResult(result)
//}