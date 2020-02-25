package practices.questions.easy

import practices.datastructureutil.Tree
import practices.questions.EMPTY_SOLUTION_IN
import practices.questions.Solution
import javax.inject.Inject
import javax.inject.Singleton

/*
* 102 - Binary Tree Level Order Traversal
* Invert a binary tree.
* Input:
*      4
*    /   \
*   2     7
*  / \   / \
* 1   3 6   9
* Output:
*
*      4
*    /   \
*   7     2
*  / \   / \
* 9   6 3   1
*
* Note: the tree is by level order traversal, and verified by level order traversal
* */
@Singleton
class InvertBinaryTree @Inject constructor(): Solution<Tree.TreeNode, Tree.TreeNode> {

    override fun getName() = "InvertBinaryTree"

    override fun solve(solutionIn: Tree.TreeNode?): Tree.TreeNode {
        solutionIn?.let {
            firstAttempt(it)
        }
        throw Exception(EMPTY_SOLUTION_IN)
    }

    /*
    * Runtime: 144 ms, faster than 56.00% of Kotlin online submissions for Invert Binary Tree.
    * Memory Usage: 31.9 MB, less than 100.00% of Kotlin online submissions for Invert Binary Tree.
    * */
    fun firstAttempt(solutionIn: Tree.TreeNode): Tree.TreeNode? {

        fun invertTree(node: Tree.TreeNode?): Tree.TreeNode? {
            if (node == null) return null
            val left = invertTree(node.leftNode)
            val right = invertTree(node.rightNode)
            node.leftNode = right
            node.rightNode = left
            return node
        }

        return invertTree(solutionIn)
    }
}

//TODO: Use this sample for UnitTest base case
//fun main() {
//
//    val binaryTreeLevelOrderTraversal = DaggerAppComponent.builder()
//            .dataStructureComponent(DaggerDataStructureComponent.create()).build().provideBinaryTreeLevelOrderTraversal()
//
//    val sampleTree = Tree.TreeNode(4).apply {
//        leftNode = Tree.TreeNode(2)
//        rightNode = Tree.TreeNode(7)
//        leftNode?.leftNode = Tree.TreeNode(1)
//        leftNode?.rightNode = Tree.TreeNode(3)
//        rightNode?.leftNode = Tree.TreeNode(6)
//        rightNode?.rightNode = Tree.TreeNode(9)
//    }
//
//    binaryTreeLevelOrderTraversal.firstAttempt(root = sampleTree).forEach {
//        print("$it, ")
//    }
//
//    println()
//
//    binaryTreeLevelOrderTraversal.firstAttempt(root = InvertBinaryTree().firstAttempt(sampleTree)!!).forEach {
//        print("$it, ")
//    }
//}
