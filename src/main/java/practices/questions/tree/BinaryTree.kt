package practices.questions.tree

import java.util.*

// Create a BST with insert and delete
class BinaryTree {

    class Node(val content: Int,
               var left: Node? = null,
               var right: Node? = null)

    val rootNode: BinaryTree.Node

    constructor(content: Int) {
        rootNode = Node(content)
    }

    fun insert(content: Int) {
        val node = Node(content)
        val queue: Queue<Node> = ArrayDeque()
        queue.add(rootNode)
        loop@ while (queue.isNotEmpty()) {
            queue.peek().left?.let { queue.add(it) }
            queue.peek().right?.let { queue.add(it) }
            when {
                queue.peek().content < content && queue.peek().right == null -> {
                    queue.peek().right = node
                    break@loop
                }
                queue.peek().content > content && queue.peek().left == null -> {
                    queue.peek().left = node
                    break@loop
                }
                queue.peek().content == content && queue.peek().left == null -> {
                    queue.peek().left = node
                    break@loop
                }
                queue.peek().content == content && queue.peek().right == null -> {
                    queue.peek().right = node
                    break@loop
                }
            }
            queue.poll()
        }
    }

    fun insert2(content: Int) {
        val node = Node(content)
        val queue: Queue<Node> = ArrayDeque()
        queue.add(rootNode)
        loop@ while (queue.isNotEmpty()) {
            var fo = queue.poll()
            if (content <= fo.content) {
                if (fo.left == null) {
                    fo.left = node
                    return
                }
                queue.add(fo.left)
            } else {
                if (fo.right == null) {
                    fo.right = node
                    return
                } else {
                    queue.add(fo.right)
                }
            }
        }
    }

    fun delete(content: Int): Boolean {
        val queue: Queue<Node> = ArrayDeque()
        queue.add(rootNode)
        while (queue.isNotEmpty()) {
            queue.peek().left?.let { queue.add(it) }
            queue.peek().right?.let { queue.add(it) }
            if (queue.peek().content == content) {
                return true
            }
        }
        return false
    }

    fun breadthFirstTraversalPrint() {
        var queue: Queue<Node> = ArrayDeque()
        queue.add(rootNode)
        while (queue.isNotEmpty()) {
            queue.peek().left?.let { queue.add(it) }
            queue.peek().right?.let { queue.add(it) }
            print(queue.poll().content)
        }
    }
}

fun main() {
    val tree = BinaryTree(4)
    tree.insert2(3)
    tree.insert2(1)
    tree.insert2(7)
    tree.insert2(6)
    tree.breadthFirstTraversalPrint()
    println()
    print("${tree.rootNode.left?.content}!")
    print("${tree.rootNode.right?.content}!")
    println()
    print("${tree.rootNode.left!!.left?.content}!")
    print("${tree.rootNode.left!!.right?.content}!")
    print("${tree.rootNode.right!!.left?.content}!")
    print("${tree.rootNode.right!!.right?.content}!")
    println()
    tree.breadthFirstTraversalPrint()
}