import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.math.abs

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val n = br.readLine().toInt()

    val inputArray = br.readLine().split(" ").map { it.toInt() }.toIntArray()

    var min = Integer.MAX_VALUE

    var l = 0
    var r = n - 1
    var answer = Pair(inputArray[l], inputArray[r])

    while (l < r) {
        val lv = inputArray[l]
        val rv = inputArray[r]

        val sum = lv + rv
        if (abs(sum) < min) {
            answer = Pair(lv, rv)
            min = abs(sum)

            if (sum == 0) break
        }

        if (sum > 0) {
            r--
        } else {
            l++
        }
    }

    print("${answer.first} ${answer.second}")
}