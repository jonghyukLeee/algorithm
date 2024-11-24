import java.io.BufferedReader
import java.io.InputStreamReader

var MAX = 0
fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (c, n) = br.readLine().split(" ").map { it.toInt() }
    MAX = c + 101

    val dp = IntArray(MAX) {Integer.MAX_VALUE}
    dp[0] = 0

    repeat(n) {
        val (amount, customer) = br.readLine().split(" ").map { it.toInt() }

        for (i in customer until MAX) {
            if (dp[i - customer] != Integer.MAX_VALUE) {
                dp[i] = minOf(dp[i], dp[i - customer] + amount)
            }
        }
    }

    var min = Integer.MAX_VALUE

    for (amount in c until MAX) {
        min = minOf(min, dp[amount])
    }

    print(min)
}