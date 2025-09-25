import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.Math.abs
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var st = StringTokenizer(br.readLine())

    val n = st.nextToken().toInt()
    val l = st.nextToken().toInt()
    val r = st.nextToken().toInt()

    val map = Array(n) { IntArray(n) }

    for (i in 0 until n) {
        st = StringTokenizer(br.readLine())
        for (j in 0 until n) {
            map[i][j] = st.nextToken().toInt()
        }
    }

    var answer = 0
    val q: Queue<Pair<Int, Int>> = LinkedList()
    val dx = intArrayOf(-1, 1, 0, 0)
    val dy = intArrayOf(0, 0, -1, 1)
    var flag = true

    fun isValid(x: Int, y: Int): Boolean {
        return x >= 0 && y >= 0 && x < n && y < n
    }

    fun bfs(i: Int, j: Int, isVisited: Array<BooleanArray>) {
        val resultQ: Queue<Pair<Int, Int>> = LinkedList()
        isVisited[i][j] = true
        q.add(i to j)
        resultQ.add(i to j)

        var total = map[i][j]
        var count = 1
        while (q.isNotEmpty()) {
            val cur = q.poll()

            for (idx in 0 until 4) {
                val mx = cur.first + dx[idx]
                val my = cur.second + dy[idx]

                if (isValid(mx, my) && !isVisited[mx][my]) {
                    if (abs(map[mx][my] - map[cur.first][cur.second]) in l..r) {
                        isVisited[mx][my] = true
                        total += map[mx][my]
                        count++
                        q.add(mx to my)
                        resultQ.add(mx to my)
                    }
                }
            }
        }
        if (resultQ.size > 1) {
            val population = total / count
            flag = true

            while (resultQ.isNotEmpty()) {
                val cur = resultQ.poll()
                map[cur.first][cur.second] = population
            }
        }
    }
    while (flag) {
        flag = false
        val isVisited = Array(n) { BooleanArray(n) }
        for (i in 0 until n) {
            for (j in 0 until n) {
                if (!isVisited[i][j]) {
                    bfs(i, j, isVisited)
                }
            }
        }
        if (flag) answer++
    }

    print(answer)
}