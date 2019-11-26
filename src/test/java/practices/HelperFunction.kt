package practices

import java.lang.StringBuilder

fun intArrayToString(intArray: IntArray): String {
    return StringBuilder().apply {
        intArray.forEach {
            append("$it, ")
        }
    }.toString()
}