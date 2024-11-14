import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

class Serial(
    val origin: String,
    val length: Int,
    val sum: Int
) {
    constructor(origin: String): this(
        origin = origin,
        length = origin.length,
        sum = origin.filter { it.isDigit() }
            .map { it - '0' }
            .sum()
    )
}
fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val n = br.readLine().toInt()

    val pq = PriorityQueue<Serial>(Comparator { o1, o2 ->
        if (o1.length == o2.length) {
            if (o1.sum == o2.sum) {
                o1.origin.compareTo(o2.origin)
            } else {
                o1.sum - o2.sum
            }
         } else {
             o1.length - o2.length
        }
    })

    (0 until n).forEach {
        pq.add(Serial(br.readLine()))
    }
    val sb = StringBuilder()
    while (pq.isNotEmpty()) {
        sb.append(pq.poll().origin).append("\n")
    }

    sb.deleteCharAt(sb.length - 1)

    print(sb.toString())
}