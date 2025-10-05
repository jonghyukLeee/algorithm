import java.util.*

class Solution {
    fun solution(id_list: Array<String>, report: Array<String>, k: Int): IntArray {
        val reportMap = mutableMapOf<String, MutableSet<String>>()
    val reportCountMap = mutableMapOf<String, Int>()

    for (id in id_list) {
        reportMap[id] = mutableSetOf()
        reportCountMap[id] = 0
    }

    for (r in report) {
        val split = r.split(" ")
        val map = reportMap[split[0]]!!

        if (!map.contains(split[1])) {
            map.add(split[1])
            reportCountMap[split[1]] = reportCountMap.getOrDefault(split[1], 0) + 1
        }
    }

    val size = id_list.size
    val result = IntArray(size) { 0 }

    for (i in 0 until size) {
        val reportList = reportMap[id_list[i]]!!

        for (name in reportList) {
            if (reportCountMap[name]!! >= k) result[i]++
        }
    }

    return result
    }
}