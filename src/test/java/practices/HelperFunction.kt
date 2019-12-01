package practices

import practices.datastructure.SinglyLinkedList
import java.lang.StringBuilder

/**
 * @param = IntArray
 * sample return:
 * passed in: intArrayOf(1, 2, 3)
 * return in "[1,2,3,]" as String
 *
 * sample return, EMPTY intArray
 * passed in: intArrayOf()
 * return in "[]" as String
 */
fun intArrayToString(intArray: IntArray): String {
    return "[${StringBuilder().apply { intArray.forEach { append("$it,") } }}]"
}

/**
 * @param = SinglyLinkedList.ListNode
 * sample return:
 * passed in: startNode 7 -> 8 -> 9
 * return in "[7,8,9,]" as String
 *
 * sample return, 1 node
 * passed in: 1 ->
 * return in "[1,]" as String
 */
fun singlyLinkedListToString(startNode: SinglyLinkedList.ListNode): String {
    var localStartNode = startNode
    return StringBuilder().apply {
        append("[")
        while (localStartNode.next != null) {
            append("${localStartNode.nodeValue},")
            localStartNode = localStartNode.next!!
        }
        append("${localStartNode.nodeValue},]")
    }.toString()
}