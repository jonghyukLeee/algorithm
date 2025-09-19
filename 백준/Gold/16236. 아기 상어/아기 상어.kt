import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() {
    data class Fish(
        val x: Int,
        val y: Int,
        val moveCount: Int = 0
    )

    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val map = Array(n) { IntArray(n) { 0 } }
    val dx = intArrayOf(-1, 1, 0, 0)
    val dy = intArrayOf(0, 0, -1, 1)

    fun isValid(x: Int, y: Int): Boolean {
        return x >= 0 && y >= 0 && x < n && y < n
    }

    var sharkX: Int = 0
    var sharkY: Int = 0

    for (i in 0 until n) {
        val inputArray = br.readLine().split(" ")

        for (j in 0 until n) {
            var value = inputArray[j].toInt()

            if (value == 9) {
                sharkX = i
                sharkY = j
                value = 0
            }

            map[i][j] = value
        }
    }

    var sharkSize = 2
    var eatCount = 0

    fun bfs(x: Int, y: Int): Fish? {
        val q: Queue<Fish> = LinkedList()
        val isVisited = Array(n) { BooleanArray(n) }
        q.add(Fish(x, y))
        isVisited[x][y] = true

        val fishes = PriorityQueue(
            compareBy<Fish> { it.moveCount }
                .thenBy { it.x }
                .thenBy { it.y }
        )

        while (q.isNotEmpty()) {
            val cur = q.poll()

            for (i in 0 until 4) {
                val mx = cur.x + dx[i]
                val my = cur.y + dy[i]

                if (isValid(mx, my) && !isVisited[mx][my] && sharkSize >= map[mx][my]) {
                    isVisited[mx][my] = true
                    val nextCount = cur.moveCount + 1
                    if (map[mx][my] in 1 until sharkSize) {
                        fishes.add(Fish(mx, my, nextCount))
                    } else {
                        q.add(Fish(mx, my, nextCount))
                    }
                }
            }
        }

        return if (fishes.isNotEmpty()) fishes.poll() else null
    }

    var answer = 0
    while (true) {
        val result = bfs(sharkX, sharkY) ?: break

        sharkX = result.x
        sharkY = result.y
        eatCount++
        answer += result.moveCount
        map[sharkX][sharkY] = 0

        if (sharkSize == eatCount) {
            sharkSize++
            eatCount = 0
        }
    }

    print(answer)
}