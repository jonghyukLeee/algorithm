import java.util.*

class Solution {
    fun solution(edges: Array<IntArray>): IntArray {
    data class Degree(var `in`: Int = 0, var out: Int = 0)

    val graph = mutableMapOf<Int, MutableList<Int>>()
    val inOutCountMap = mutableMapOf<Int, Degree>()

    // 그래프 구성 및 in/out 차수 계산
    var maxV = 0
    for ((from, to) in edges) {
        maxV = maxOf(maxV, maxOf(from, to))
        graph.getOrPut(from) { mutableListOf() }.add(to)
        graph.getOrPut(to) { mutableListOf() }.add(from)
        inOutCountMap.getOrPut(from) { Degree() }.out++
        inOutCountMap.getOrPut(to) { Degree() }.`in`++
    }

    val root = inOutCountMap.entries.first { it.value.`in` == 0 && it.value.out >= 2 }.key

    for (v in graph[root]!!) {
        inOutCountMap[v]!!.`in`--
    }

    val isVisited = BooleanArray(maxV + 1)
    isVisited[root] = true

    fun bfs(v: Int, list:MutableList<Int>) {
        val q = ArrayDeque<Int>()
        isVisited[v] = true
        q.addLast(v)
        while (q.isNotEmpty()) {
            val cur = q.removeFirst()
            list.add(cur)

            for (next in graph[cur]!!) {
                if (!isVisited[next]) {
                    isVisited[next] = true
                    q.addLast(next)
                }
            }
        }
    }

    var donut = 0
    var line = 0
    var eight = 0
    for (i in graph[root]!!) {
        if (!isVisited[i]) {
            val list = mutableListOf(i)
            bfs(i, list)

            if (list.all { inOutCountMap[it]!!.`in` == 1 && inOutCountMap[it]!!.out == 1 }) donut++
            else if (list.any { inOutCountMap[it]!!.`in` == 0 } && list.any { inOutCountMap[it]!!.out == 0 }) line++
            else eight++
        }
    }
    return intArrayOf(root, donut, line, eight)
}
}