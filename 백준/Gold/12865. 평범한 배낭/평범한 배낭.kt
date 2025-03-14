import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, k) = br.readLine().split(" ").map { it.toInt() }
    val dp = Array(k + 1) { 0 }
    repeat(n) {
        val (w, v) = br.readLine().split(" ").map { it.toInt() }

        for (i in k downTo w) {
            dp[i] = maxOf(dp[i], dp[i - w] + v)
        }
    }

    print(dp[k])
}