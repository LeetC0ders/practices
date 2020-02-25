package practices

import practices.datastructureutil.SinglyLinkedList

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
 * @param = List<Int>
 * sample return:
 * passed in: (1, 2, 3) of List
 * return in "[1,2,3,]" as String
 *
 * sample return, EMPTY list
 * passed in: empty list
 * return in "[]" as String
 */
fun intListToString(intList: List<Int>): String {
    return "[${StringBuilder().apply { intList.forEach { append("$it,") } }}]"
}

/**
 * @param = List<Int>
 * sample return:
 * passed in: (1, 2, 3) of List
 * return in "[1,2,3,]" as String
 *
 * sample return, EMPTY list
 * passed in: empty list
 * return in "[]" as String
 */
fun stringListToString(stringList: List<String>): String {
    return "[${StringBuilder().apply { stringList.forEach { append("$it,") } }}]"
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