import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val minQ = PriorityQueue<Int>()
    val maxQ = PriorityQueue<Int>(compareByDescending { it })

    val sb = StringBuilder()
    repeat(n) {
        val input = br.readLine().toInt()

        if (maxQ.size == minQ.size) {
            maxQ.add(input)
        } else {
            minQ.add(input)
        }

        if (minQ.isNotEmpty() && minQ.peek() < maxQ.peek()) {
            val tmp = minQ.poll()
            minQ.add(maxQ.poll())
            maxQ.add(tmp)
        }

        sb.append(maxQ.peek()).append("\n")
    }

    print(sb.toString().trimEnd())
}