import java.io.BufferedReader
import java.io.InputStreamReader


fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    var t = Integer.parseInt(br.readLine())

    val inputList = mutableListOf<Int>()
    var max = Integer.MIN_VALUE
    while (t-- > 0) {
        val input = Integer.parseInt(br.readLine())
        inputList.add(input)
        max = Math.max(max, input)
    }

    val dp: Array<Long> = Array(max + 1) { 0 }
    dp[1] = 1
    dp[2] = 2
    dp[3] = 4

    if (max > 3) {
        for (i in 4 .. max) {
            dp[i] = (dp[i - 3] + dp[i - 2] + dp[i - 1]) % 1_000_000_009
        }
    }

    val sb = StringBuilder()
    for (input in inputList) {
        sb.append(dp[input]).append("\n")
    }
    sb.deleteCharAt(sb.length - 1)
    print(sb.toString())
}