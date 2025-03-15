import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() {
    class Mirror(
        val x: Int,
        val y: Int,
        val dir: Int,
        val count: Int
    )

    val br = BufferedReader(InputStreamReader(System.`in`))
    val (w, h) = br.readLine().split(" ").map { it.toInt() }

    val map = Array(h) { CharArray(w) }
    val isVisited = Array(4) { Array(h) { IntArray(w) { Integer.MAX_VALUE } } }
    var c = 0 to 0
    for (i in 0 until h) {
        map[i] = br.readLine().toCharArray()
    }

    loop@ for (i in 0 until h) {
        for (j in 0 until w) {
            if (map[i][j] == 'C') {
                c = i to j
                break@loop
            }
        }
    }

    val q: Queue<Mirror> = LinkedList()
    val dx = intArrayOf(-1, 1, 0, 0)
    val dy = intArrayOf(0, 0, -1, 1)
    q.add(Mirror(c.first, c.second, -1, -1))
    for (i in 0 .. 3) isVisited[i][c.first][c.second] = -1

    fun isValid(x: Int, y: Int): Boolean {
        return x >= 0 && y >= 0 && x < h && y < w
    }

    var answer = Integer.MAX_VALUE
    while (q.isNotEmpty()) {
        val current = q.poll()

        for (idx in 0..3) {
            val mx = current.x + dx[idx]
            val my = current.y + dy[idx]

            if (isValid(mx, my) && map[mx][my] != '*') {
                val nextCount = current.count + if (current.dir == idx) 0 else 1

                if (isVisited[idx][mx][my] > nextCount) {
                    if (map[mx][my] == 'C') {
                        answer = minOf(answer, nextCount)
                    } else {
                        q.add(Mirror(mx, my, idx, nextCount))
                        isVisited[idx][mx][my] = nextCount
                    }
                }
            }
        }
    }

    print(answer)
}