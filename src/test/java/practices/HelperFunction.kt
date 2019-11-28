package practices

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