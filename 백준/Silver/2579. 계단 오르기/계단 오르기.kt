import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.max

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val stairs = IntArray(n + 1)
    for (i in 1..n) {
        stairs[i] = br.readLine().toInt()
    }

    val dp = IntArray(n + 1)
    dp[1] = stairs[1]
    if (n >= 2) dp[2] = stairs[1] + stairs[2]

    for (i in 3..n) {
        dp[i] = max(dp[i - 3] + stairs[i - 1], dp[i - 2]) + stairs[i]
    }

    print(dp[n])
}