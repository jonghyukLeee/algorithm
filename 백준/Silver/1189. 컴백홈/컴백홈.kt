import java.util.*

fun main() {
    val (R, C, K) = readLine()!!.split(" ").map { it.toInt() }
    val grid = Array(R) { readLine()!!.toCharArray() }
    val visited = Array(R) { BooleanArray(C) { false } }
    var result = 0

    val directions = arrayOf(
        Pair(-1, 0), // 위
        Pair(1, 0),  // 아래
        Pair(0, -1), // 왼쪽
        Pair(0, 1)   // 오른쪽
    )

    fun isValid(x: Int, y: Int): Boolean {
        return x in 0 until R && y in 0 until C && !visited[x][y] && grid[x][y] != 'T'
    }

    fun dfs(x: Int, y: Int, depth: Int) {
        if (x == 0 && y == C - 1) { // 도착지 도달
            if (depth == K) result++
            return
        }

        for ((dx, dy) in directions) {
            val nx = x + dx
            val ny = y + dy
            if (isValid(nx, ny)) {
                visited[nx][ny] = true
                dfs(nx, ny, depth + 1)
                visited[nx][ny] = false // 백트래킹
            }
        }
    }

    // 시작점 설정
    visited[R - 1][0] = true
    dfs(R - 1, 0, 1)

    print(result)
}
