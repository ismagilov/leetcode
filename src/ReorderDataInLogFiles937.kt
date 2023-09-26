class ReorderDataInLogFiles937 {
    fun reorderLogFiles(logs: Array<String>): Array<String> {
        val dsLogs = mutableListOf<String>()
        val lsLogs = mutableListOf<String>()

        for (l in logs) {
            if (isDs(l))
                dsLogs.add(l)
            else
                lsLogs.add(l)
        }

        lsLogs.sortWith(compareBy<String> { getContent(it) }.thenBy { getId(it) })

        return (lsLogs + dsLogs).toTypedArray()
    }

    private fun getContent(log: String): String {
        return log.substringAfter(' ')
    }

    private fun getId(log: String): String {
        return log.substringBefore(' ')
    }

    private fun isDs(log: String): Boolean {
        return getContent(log)[0].isDigit()
    }
}