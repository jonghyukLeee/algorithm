import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val dp = Array(n + 1) { 1 }
    dp[1] = 1
    if (n >= 2) {
        dp[2] = 2
    }

    for (i in 3 .. n) {
        dp[i] = dp[i - 2] + dp[i - 1]
    }

    val m = br.readLine().toInt()
    var pivot = 0
    var total = 1
    repeat(m) {
        val vip = br.readLine().toInt()
        val len = vip - pivot - 1

        total *= dp[len]
        pivot = vip
    }

    total *= dp[n - pivot]

    print(total)
}