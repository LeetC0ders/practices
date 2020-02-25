package practices.datastructureutil

/*
 * Example:
 * var treeNode = TreeNode(5)
 * var content = treeNode.content
 * Definition for a binary tree node.
 */
class Tree constructor() {

    class TreeNode(val content: Int) {
        var rightNode: TreeNode? = null
        var leftNode: TreeNode? = null
    }
}
