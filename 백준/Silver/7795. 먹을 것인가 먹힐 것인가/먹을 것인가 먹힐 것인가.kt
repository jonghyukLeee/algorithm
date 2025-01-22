import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val t = br.readLine().toInt()
    val sb = StringBuilder()

    fun binarySearch(list: List<Int>, v: Int): Int {
        var left = 0
        val size = list.size
        var right = size

        while (left < right) {
            val mid = (left + right) / 2

            if (list[mid] <= v) {
                left = mid + 1
            } else {
                right = mid
            }
        }

        return size - left
    }

    repeat(t) {
        var answer = 0
        val (n, m) = br.readLine().split(" ").map { it.toInt() }

        val a = br.readLine().split(" ").map { it.toInt() }.sorted()

        br.readLine().split(" ").forEach {
            answer += binarySearch(a, it.toInt())
        }

        sb.append(answer).append("\n")
    }

    print(sb.toString().trimEnd('\n'))
}