import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.min

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, m) = br.readLine().split(" ").map { it.toInt() }

    val map = Array(n + 1) { Array(n + 1) { 100 } }

    for (i in 1 .. n) {
        map[i][i] = 0
    }

    repeat(m) {
        val (from, to) = br.readLine().split(" ").map { it.toInt() }

        map[from][to] = 1
        map[to][from] = 1
    }
    for (k in 1 .. n) {
        for (i in 1 .. n ) {
            for (j in 1 .. n) {
                if (i != j) {
                    map[i][j] = min(map[i][j], map[i][k] + map[k][j])
                }
            }
        }
    }

    var a = 0
    var b = 0
    var min = Integer.MAX_VALUE
    for (i in 1 until n) {
        for (j in i + 1 .. n) {
            var total = 0

            for (k in 1 .. n) {
                if (k != i && k != j) {
                    total += min(map[i][k], map[j][k]) * 2
                }
            }

            if (total < min) {
                min = total
                a = i
                b = j
            }
        }
    }

    print("$a $b $min")
}

