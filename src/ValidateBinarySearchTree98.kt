class ValidateBinarySearchTree98 {
    fun isValidBSTRange(root: TreeNode?): Boolean {
        fun isBst(root: TreeNode?, left: Int?, right: Int?): Boolean {
            if (root == null)
                return true

            if ((left != null && root.`val` <= left) || (right != null && root.`val` >= right))
                return false

            return isBst(root.left, left, root.`val`) && isBst(root.right, root.`val`, right)
        }

        return isBst(root, null, null)
    }

    fun isValidBSTInOrder(root: TreeNode?): Boolean {
        var prev: Int? = null
        fun inOrder(root: TreeNode?): Boolean {
            if (null == root)
                return true
            if (!inOrder(root.left))
                return false
            if (prev != null && root.`val` <= prev!!)
                return false

            prev = root.`val`

            return inOrder(root.right)
        }

        return inOrder(root)
    }

    class TreeNode(var `val`: Int) {
         var left: TreeNode? = null
         var right: TreeNode? = null
    }
}

fun main() {
    val s = ValidateBinarySearchTree98()

    val n2 = ValidateBinarySearchTree98.TreeNode(2)
    val n3 = ValidateBinarySearchTree98.TreeNode(3)
    val n1 = ValidateBinarySearchTree98.TreeNode(1)
    n1.left = n2; n1.right = n3

    println(s.isValidBSTInOrder(n1))
}