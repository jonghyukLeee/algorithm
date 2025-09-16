import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val (n, m) = br.readLine().split(" ").map { it.toInt() }

    val map = Array(n) {
        val input = br.readLine()
        IntArray(m) { input[it] - '0' }
    }

    var len = minOf(n, m)

    fun isValid(i: Int, j: Int, len: Int): Boolean {
        val l = len - 1
        return (i + l < n) && (j + l < m)
    }

    fun isSame(i: Int, j: Int, len: Int): Boolean {
        val l = len - 1
        val num = map[i][j]

        return (num == map[i + l][j]) && (num == map[i][j + l]) && (num == map[i + l][j + l])
    }

    var answer = 1

    while (len > 1) {
        out@ for (i in 0 until n) {
            for (j in 0 until m) {
                if (isValid(i, j, len)) {
                    if (isSame(i, j, len)) {
                        answer = len * len
                        break@out
                    }
                }
            }
        }

        if (answer > 1) break
        else len--
    }

    print(answer)
}