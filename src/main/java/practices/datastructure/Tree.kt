package practices.datastructure

import javax.inject.Inject

/*
 * Example:
 * var treeNode = TreeNode(5)
 * var content = treeNode.content
 * Definition for a binary tree node.
 */
class Tree @Inject constructor() {

    class TreeNode(val content: Int) {
        var rightNode: TreeNode? = null
        var leftNode: TreeNode? = null
    }
}
