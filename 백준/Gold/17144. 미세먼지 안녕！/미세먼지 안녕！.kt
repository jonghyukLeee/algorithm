import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() {
    class Dust(
        val x: Int,
        val y: Int,
        val origin: Int
    )
    val br = BufferedReader(InputStreamReader(System.`in`))
    var st = StringTokenizer(br.readLine())

    val r = st.nextToken().toInt()
    val c = st.nextToken().toInt()
    var t = st.nextToken().toInt()
    val cleaners = mutableListOf<Pair<Int, Int>>()
    val q: Queue<Dust> = LinkedList()

    val map = Array(r) { IntArray(c) }
    for (i in 0 until r) {
        st = StringTokenizer(br.readLine())
        for (j in 0 until c) {
            val n = st.nextToken().toInt()

            if (n < 0) {
                cleaners.add(i to j)
            }

            if (n > 0) {
                q.add(Dust(i, j, n))
            }
            map[i][j] = n
        }
    }

    val dx = intArrayOf(-1, 1, 0, 0)
    val dy = intArrayOf(0, 0, -1, 1)

    fun isValid(x: Int, y: Int): Boolean {
        return x >= 0 && y >= 0 && x < r && y < c
    }

    while (t-- > 0) {
        while (q.isNotEmpty()) {
            val cur = q.poll()

            for (idx in 0 until 4) {
                val mx = cur.x + dx[idx]
                val my = cur.y + dy[idx]

                val amount = cur.origin / 5
                if (isValid(mx, my) && map[mx][my] > -1) {
                    map[mx][my] += amount
                    map[cur.x][cur.y] -= amount
                }
            }
        }

        // 위쪽 공기청정기
        var prev = map[cleaners[0].first][cleaners[0].second + 1]
        map[cleaners[0].first][cleaners[0].second + 1] = 0
        var tmp = 0
        for (i in cleaners[0].second + 2 until c) {
            tmp = map[cleaners[0].first][i]
            map[cleaners[0].first][i] = prev
            prev = tmp
        }

        for (i in cleaners[0].first - 1 downTo 0) {
            tmp = map[i][c - 1]
            map[i][c - 1] = prev
            prev = tmp
        }

        for (i in c - 2 downTo 0) {
            tmp = map[0][i]
            map[0][i] = prev
            prev = tmp
        }

        for (i in 1 until cleaners[0].first) {
            tmp = map[i][0]
            map[i][0] = prev
            prev = tmp
        }

        // 아래쪽
        prev = map[cleaners[1].first][cleaners[1].second + 1]
        map[cleaners[1].first][cleaners[1].second + 1] = 0
        for (i in cleaners[1].second + 2 until c) {
            tmp = map[cleaners[1].first][i]
            map[cleaners[1].first][i] = prev
            prev = tmp
        }

        for (i in cleaners[1].first + 1 until r) {
            tmp = map[i][c - 1]
            map[i][c - 1] = prev
            prev = tmp
        }

        for (i in c - 2 downTo 0) {
            tmp = map[r - 1][i]
            map[r - 1][i] = prev
            prev = tmp
        }

        for (i in r - 2 downTo cleaners[1].first + 1) {
            tmp = map[i][0]
            map[i][0] = prev
            prev = tmp
        }

        for (i in 0 until r) {
            for (j in 0 until c) {
                if (map[i][j] > 0) {
                    q.add(Dust(i, j, map[i][j]))
                }
            }
        }
    }

    var answer = 0
    for (i in 0 until r) {
        for (j in 0 until c) {
            if (map[i][j] > 0) {
                answer += map[i][j]
            }
        }
    }

    print(answer)
}