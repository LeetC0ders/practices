package practices.questions.easy

import practices.datastructure.Tree
import practices.questions.EMPTY_SOLUTION_IN
import practices.questions.Solution

class TreeTraversalForTarget : Solution<Pair<Tree.TreeNode?, Int>, Boolean> {

    override fun getName() = "TreeTraversalForTarget"

    override fun solve(solutionIn: Pair<Tree.TreeNode?, Int>?): Boolean {
        solutionIn?.let {
            firstAttempt(it)
        }
        throw Exception(EMPTY_SOLUTION_IN)
    }

    fun firstAttempt(solutionIn: Pair<Tree.TreeNode?, Int>): Boolean {

        val target = solutionIn.second
        var root: Tree.TreeNode? = solutionIn.first ?: return false

        var valueMap: MutableMap<Int, Int> = HashMap()
        var foundValue = false

        fun recursiveHelperFunction(node: Tree.TreeNode?) {
            if (node == null) return
            val need = target - node.content
            if (valueMap.contains(node.content)) foundValue = true
            if (!valueMap.containsKey(need)) valueMap[need] = node.content
            recursiveHelperFunction(node.leftNode)
            recursiveHelperFunction(node.rightNode)
        }

        recursiveHelperFunction(root)
        return foundValue
    }
}

//fun main() {
//    val sampleTree = Tree.TreeNode(4).apply {
//        leftNode = Tree.TreeNode(2)
//        rightNode = Tree.TreeNode(7)
//        leftNode?.leftNode = Tree.TreeNode(1)
//        leftNode?.rightNode = Tree.TreeNode(3)
//        rightNode?.leftNode = Tree.TreeNode(6)
//        rightNode?.rightNode = Tree.TreeNode(9)
//    }
//
//    println(TreeTraversalForTarget().firstAttempt(Pair(sampleTree, 16)))
//}