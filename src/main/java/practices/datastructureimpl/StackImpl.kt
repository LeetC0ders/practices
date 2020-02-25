package practices.datastructureimpl

/**
 * We want a basic stack implementation with array at it's core, do it.
 */
class StackImpl<T>(size: Int): HasName {

    private var coreArray: Array<Any?> = arrayOfNulls(size = size)
    private var cursorIndex = 0

    override fun getName(): String {
        return "StackImpl"
    }

    fun push(content: T): Boolean {
        if (cursorIndex >= coreArray.size) {
            throw Exception("Stack Over Flow")
        } else {
            coreArray[cursorIndex] = content
            cursorIndex += 1
            return true
        }
    }

    fun peek(): T {
        return coreArray[cursorIndex - 1] as T;
    }

    fun pop(): T {
        if (cursorIndex == 0) {
            throw Exception("Stack Under Flow")
        } else {
            return coreArray[--cursorIndex] as T;
        }
    }

}