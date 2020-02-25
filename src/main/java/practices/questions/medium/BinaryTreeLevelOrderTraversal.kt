package practices.questions.medium

import practices.datastructureutil.Tree
import practices.questions.EMPTY_SOLUTION_IN
import practices.questions.Solution
import javax.inject.Inject
import javax.inject.Singleton
import kotlin.math.max

/*
* problem-102: Binary Tree Level Order Traversal
* Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
*
* You may expect the tree to be balance
*
* Sample:
* in:
*               4
*       2               7
*   1       3       6       9
*
* out: [ [4], [2, 7], [1, 3, 6, 9]]
*
* in:      3
*         / \
*        9  20
*          /  \
*        15   7
* out: [[3], [9,20], [15,7]]
* */
@Singleton
class BinaryTreeLevelOrderTraversal @Inject constructor(): Solution<Tree.TreeNode?, List<List<Int>>> {

    override fun getName() = "TraverseBinaryTreeByLevel"

    override fun solve(solutionIn: Tree.TreeNode?): List<List<Int>> {
        solutionIn?.let {
            firstAttempt(solutionIn)
        }
        throw Exception(EMPTY_SOLUTION_IN)
    }

    /*
    * Runtime: 184 ms, faster than 82.98% of Kotlin online submissions for Binary Tree Level Order Traversal.
    * Memory Usage: 34 MB, less than 100.00% of Kotlin online submissions for Binary Tree Level Order Traversal.
    * */
    fun firstAttempt(root: Tree.TreeNode): List<List<Int>> {

        var map: MutableMap<Int, List<Int>> = HashMap()
        var flattenedTreeList: MutableList<List<Int>> = ArrayList()
        var tracker = 0
        var maxLevel = 0

        fun helperFunction(node: Tree.TreeNode?, map: MutableMap<Int, List<Int>>, levelTracker: Int) {
            if (node == null) {
                tracker--
                return
            }

            if (map[levelTracker] == null) map[levelTracker] = ArrayList()
            (map[levelTracker] as MutableList<Int>).add(node.content)

            helperFunction(node.leftNode, map, ++tracker)
            helperFunction(node.rightNode, map, ++tracker)
            maxLevel = max(maxLevel, tracker)
            tracker--
        }

        helperFunction(root, map, tracker)
        for (level in 0 .. maxLevel) {
            flattenedTreeList.add(map[level] as List<Int>)
        }
        return flattenedTreeList
    }

}

//TODO: Use this sample for UnitTest base case
//fun main() {
//    val sampleTree = Tree.TreeNode(4).apply {
//        leftNode = Tree.TreeNode(2)
//        rightNode = Tree.TreeNode(7)
//        leftNode?.leftNode = Tree.TreeNode(1)
//        leftNode?.rightNode = Tree.TreeNode(3)
//        rightNode?.leftNode = Tree.TreeNode(6)
//        rightNode?.rightNode = Tree.TreeNode(9)
//    }
//    TraverseBinaryTreeByLevel().firstAttempt(root = sampleTree).forEach {
//        print("$it, ")
//    }
//}