import kotlin.math.max

/**
 * https://leetcode.com/problems/diameter-of-binary-tree/
 */
private class DiameterOfBinaryTree543 {
    var totalMax = 0

    fun diameterOfBinaryTree(root: TreeNode?): Int {
        findMax(root)

        return totalMax
    }

    fun findMax(root: TreeNode?): Int {
        if (root == null)
            return 0

        val left = findMax(root?.left)
        val right = findMax(root?.right)

        totalMax = max(totalMax, left + right)

        return 1 + max(left, right)
    }
}

fun main() {
    val n4 = TreeNode(4)
    val n5 = TreeNode(5)
    val n3 = TreeNode(3)
    val n2 = TreeNode(2, n4, n5)
    val n1 = TreeNode(1, n3, n2)
    println(DiameterOfBinaryTree543().diameterOfBinaryTree(n4))
}

private data class TreeNode(var `val`: Int, var left: TreeNode? = null, var right: TreeNode? = null)
