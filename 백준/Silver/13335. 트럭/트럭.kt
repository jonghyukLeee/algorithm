import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val (n, w, l) = br.readLine().split(" ").map { it.toInt() }
    val trucks: Queue<Int> = LinkedList(br.readLine().split(" ").map { it.toInt() })

    var weight = 0
    var time = 0
    val bridge = LinkedList<Int>()
    repeat(w) {
        bridge.add(0)
    }

    while (trucks.isNotEmpty() || weight > 0) {
        time++

        weight -= bridge.poll()

        if (trucks.isNotEmpty() && weight + trucks.peek() <= l) {
            val next = trucks.poll()
            weight += next
            bridge.add(next)
        } else {
            bridge.add(0)
        }
    }

    print(time)
}