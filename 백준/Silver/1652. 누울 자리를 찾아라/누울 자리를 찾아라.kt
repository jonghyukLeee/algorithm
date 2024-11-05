import java.io.BufferedReader
import java.io.InputStreamReader

lateinit var isVisited: Array<Array<BooleanArray>>
lateinit var map: Array<CharArray>
var N = 0

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var w = 0
    var l = 0

    N = br.readLine().toInt()
    map = Array(N) { br.readLine().toCharArray() }
    isVisited = Array(2) { Array(N) { BooleanArray(N) } }
    for (i in 0 until N) {
        for (j in 0 until N) {
            if (map[i][j] == '.') {
                if (!isVisited[0][i][j]) {
                    w += lie(i, j, 0)
                }
                if (!isVisited[1][i][j]) {
                    l += lie(i, j, 1)
                }
            }
        }
    }

    print("$w $l")
}

fun lie(i: Int, j: Int, dir: Int): Int {
    var count = 1
    var result = 0
    // 0 가로 1 세로
    if (dir == 0) {
        for (next in j + 1 until N) {
            if (!isVisited[dir][i][next] && map[i][next] == '.') {
                isVisited[dir][i][next] = true
                count++
            } else break
        }
        if (count >= 2) result = 1
    } else {
        for (next in i + 1 until N) {
            if (!isVisited[dir][next][j] && map[next][j] == '.') {
                isVisited[dir][next][j] = true
                count++
            } else break
        }
        if (count >= 2) result = 1
    }

    return result
}