import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.text.StringBuilder

fun main() {
    class Location(
        val x: Int,
        val y: Int,
        val time: Int
    )

    val dx = arrayOf(-1, 1, 0, 0)
    val dy = arrayOf(0, 0, -1, 1)

    val br = BufferedReader(InputStreamReader(System.`in`))
    val t = br.readLine().toInt()

    val sb = StringBuilder()
    val q: Queue<Location> = LinkedList()
    lateinit var startLocation: Location
    repeat(t) {
        val (w, h) = br.readLine().split(" ").map { it.toInt() }
        val map = Array(h) { CharArray(w) }
        val fireMap = Array(h) { IntArray(w) }

        fun isEscaped(x: Int, y: Int): Boolean {
            return x < 0 || y < 0 || x >= h || y >= w
        }

        for (i in 0 until h) {
            for (c in br.readLine().toCharArray().withIndex()) {
                map[i][c.index] = c.value

                if (c.value == '*') {
                    q.add(Location(i, c.index, 0))
                } else if (c.value == '@') {
                    startLocation = Location(i, c.index, 0)
                }
            }
        }

        // 불이야
        while (q.isNotEmpty()) {
            val cur = q.poll()

            for (i in 0 until 4) {
                val mx = cur.x + dx[i]
                val my = cur.y + dy[i]

                if (!isEscaped(mx, my) && (map[mx][my] == '.' || map[mx][my] == '@') && fireMap[mx][my] == 0) {
                    val nextTime = cur.time + 1
                    fireMap[mx][my] = nextTime

                    q.add(Location(mx, my, nextTime))
                }
            }
        }

        // 상근이
        q.add(startLocation)
        var answer = Integer.MAX_VALUE
        while (q.isNotEmpty()) {
            val cur = q.poll()

            val nextTime = cur.time + 1
            for (i in 0 until 4) {
                val mx = cur.x + dx[i]
                val my = cur.y + dy[i]

                if (isEscaped(mx, my)) {
                    answer = minOf(answer, nextTime)
                    break
                }

                if (map[mx][my] == '.' && (fireMap[mx][my] == 0 || fireMap[mx][my] > nextTime)) {
                    fireMap[mx][my] = Integer.MIN_VALUE // 방문처리
                    q.add(Location(mx, my, nextTime))
                }
            }
        }

        sb.append(if (answer == Integer.MAX_VALUE) "IMPOSSIBLE" else answer).append("\n")
    }
    print(sb.toString().trimEnd())
}

