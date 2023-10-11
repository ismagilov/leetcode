class InvertBinaryTree226 {

    // [2,1,3]
    fun invertTreeA(root: TreeNode?): TreeNode? {
        if (root == null)
            return root

        val right = invertTreeA(root.left)
        val left = invertTreeA(right)
        root.right = left
        root.left = right

        return root
    }

    fun invertTreeB(root: TreeNode?): TreeNode? {
        val q = ArrayDeque<TreeNode?>()
        q.addLast(root)
        while (q.isNotEmpty()) {
            val head = q.removeFirst()

            val tmp = head?.right
            head?.right = head?.left
            head?.left = tmp

            if (head?.left != null)
                q.addLast(head.left)

            if (head?.right != null)
                q.addLast(head.right)
        }

        return root
    }

    data class TreeNode(var `val`: Int, var left: TreeNode? = null, var right: TreeNode? = null)
}

fun main() {

}

