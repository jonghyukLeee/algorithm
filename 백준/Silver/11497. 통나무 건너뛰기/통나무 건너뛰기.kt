import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val t = br.readLine().toInt()

    val sb = StringBuilder()
    val pq = PriorityQueue<Int>(Collections.reverseOrder())
    repeat(t) {
        val n = br.readLine().toInt()
        br.readLine().split(" ").forEach { pq.add(it.toInt()) }

        val max = pq.poll()

        var left = max
        var right = max

        var answer = Integer.MIN_VALUE

        var flag = 1
        while (pq.isNotEmpty()) {
            val cur = pq.poll()

            if (flag > 0) {
                answer = maxOf(answer, Math.abs(left - cur))
                left = cur
            } else {
                answer = maxOf(answer, Math.abs(right - cur))
                right = cur
            }

            flag = flag xor 1
        }

        answer = maxOf(answer, Math.abs(left - right))

        sb.append(answer).append("\n")
    }

    print(sb.toString().trimEnd('\n'))
}