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

    fun invertTreeBfs(root: TreeNode?): TreeNode? {
        val q = ArrayDeque<TreeNode?>()

        if (root != null)
            q.addLast(root)

        while (q.isNotEmpty()) {
            val first = q.removeFirst()

            val tmp = first?.right
            first?.right = first?.left
            first?.left = tmp

            if (first?.right != null)
                q.addLast(first.right)

            if (first?.left != null)
                q.addLast(first.left)
        }

        return root
    }

    fun invertTreeDfs(root: TreeNode?): TreeNode? {
        if (root == null)
            return null

        val left = invertTreeDfs(root.left)
        val right = invertTreeDfs(root.right)

        root.left = right
        root.right = left

        return root
    }

    data class TreeNode(var `val`: Int, var left: TreeNode? = null, var right: TreeNode? = null)
}

fun main() {

}

