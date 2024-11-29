import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val lost = br.readLine().split(" ").map { it.toInt() }
    val happy = br.readLine().split(" ").map { it.toInt() }

    val dp = IntArray(100) { 0 }

    for (i in 0 until n) {
        for (hp in 99 downTo lost[i]) {
            dp[hp] = maxOf(dp[hp], dp[hp - lost[i]] + happy[i])
        }
    }

    print(dp.maxOrNull() ?: 0)
}