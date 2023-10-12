import com.sun.source.tree.Tree

class SameTree100 {
    fun isSameTreeA(p: TreeNode?, q: TreeNode?): Boolean {
        if (p == null && q == null)
            return true

        if (p?.`val` != q?.`val`)
            return false

        val left = isSameTreeA(p?.left, q?.left)
        val right = isSameTreeA(p?.right, q?.right)

        return left && right
    }

    fun isSameTreeB(p: TreeNode?, q: TreeNode?): Boolean {
        return toList(p) == toList(q)
    }

    private fun toList(p: TreeNode?): List<Int?> {
        val l = mutableListOf<Int?>()

        val q = ArrayDeque<TreeNode?>()
        q.addLast(p)
        while (q.isNotEmpty()) {
            val first = q.removeFirst()
            l.add(first?.`val`)
            first?.let {
                q.addLast(it.left)
                q.addLast(it.right)
            }
        }

        return l
    }

    data class TreeNode(
        var `val`: Int,
        var left: TreeNode? = null,
        var right: TreeNode? = null,
    )
}

fun main() {
    val p = SameTree100.TreeNode(1, SameTree100.TreeNode(2), SameTree100.TreeNode(3))
    val q = SameTree100.TreeNode(1, SameTree100.TreeNode(2), SameTree100.TreeNode(3))

    val s = SameTree100()

    println(s.isSameTreeB(p, q))
}