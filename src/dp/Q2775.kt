package dp

import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.StringBuilder
import kotlin.math.max

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var tc = br.readLine().toInt()

    var maxK = Integer.MIN_VALUE
    val list = mutableListOf<Pair<Int, Int>>()

    while (tc-- > 0) {
        var k = br.readLine().toInt()
        var n = br.readLine().toInt()

        list.add(k to n)
        maxK = max(maxK, k)
    }

    var dp = Array(maxK + 1) { Array(15) { i -> i } }

    for (i in 1..maxK) {
        for (j in 1..14) {
            dp[i][j] = dp[i][j - 1] + dp[i - 1][j]
        }
    }
    val sb = StringBuilder()

    list.forEach { (k, n) ->
        sb.append("${dp[k][n]}\n")
    }
    print(sb.deleteCharAt(sb.length - 1).toString())
}