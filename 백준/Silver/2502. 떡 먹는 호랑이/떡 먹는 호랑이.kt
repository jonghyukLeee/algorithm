import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (d, k) = br.readLine().split(" ").map { it.toInt() }

    val dp = Array(d + 1) { 0 }
    dp[d] = k

    for (start in k - 1 downTo k / 2) {
        dp[d - 1] = start
        dp[d - 2] = k - start

        for (i in d - 3 downTo 1) {
            val current = dp[i + 2] - dp[i + 1]
            if (current < dp[i + 1]) {
                dp[i] = current
            } else break
        }

        if (dp[1] > 0) {
            break
        }
    }

    print("${dp[1]}\n${dp[2]}")
}