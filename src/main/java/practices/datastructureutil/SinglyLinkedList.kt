package practices.datastructureutil

/*
  * The class is a singly linked listL
  * You can imagine it be like
  * Explain:
  * Each ListNode will have the ability to save a value called NodeValue which is a int (actual value)
  * And each listNode will also have a value that called next, which is also a ListNode object that points
  * to the next ListNode. Together, they created a singly linked list.
  */
class SinglyLinkedList {

    class ListNode(val nodeValue: Int) {
        var next: ListNode? = null
    }

}