package practices.datastructure

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

    data class ListNodeD(
            val nodeValue: Int,
            var next: ListNodeD? = null
    )

}

fun main() {
    val node1 = SinglyLinkedList.ListNode(2)
    val node1d = SinglyLinkedList.ListNodeD(2)
    val node2 = SinglyLinkedList.ListNode(2)
    val node2d = SinglyLinkedList.ListNodeD(2)
    val node3 = node1
    val node3d = node1d

    println("hash code = ${node1.hashCode()}")
    println("hash code = ${node2.hashCode()}")
    println("hash code = ${node3.hashCode()}")
    println("hash code = ${node1d.hashCode()}")
    println("hash code = ${node2d.hashCode()}")
    println("hash code = ${node3d.hashCode()}")

    val set: MutableSet<SinglyLinkedList.ListNode> = HashSet()
    set.add(node1)
    set.add(node2)
    set.add(node3)
    set.forEach {
        println("${it.nodeValue}, ")
    }

    val setd: MutableSet<SinglyLinkedList.ListNodeD> = HashSet()
    setd.add(node1d)
    setd.add(node2d)
    setd.add(node3d)
    set.forEach {
        println("${it.nodeValue}, ")
    }


}