import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val n = br.readLine().toInt()

    val sb = StringBuilder()
    repeat(n) {
        var result = "SYJKGW"

        val input = br.readLine().trim().split(" ").map { it.toLong() }
        val total = input[0].toInt()
        val countMap = hashMapOf<Long, Int>()
        var max = 1L to Integer.MIN_VALUE
        for (i in 1 .. total) {
            val idx = input[i]
            val count = countMap.getOrDefault(idx, 0) + 1

            if (count > max.second) {
                max = idx to count
            }

            countMap[idx] = count
        }

        if (max.second > total / 2) {
            result = max.first.toString()
        }

        sb.append(result).append("\n")
    }

    print(sb.toString().trimEnd('\n'))
}