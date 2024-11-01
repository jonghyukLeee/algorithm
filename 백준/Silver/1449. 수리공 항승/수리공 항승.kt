import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val st = StringTokenizer(br.readLine())
    val n = st.nextToken().toInt()
    val l = st.nextToken().toInt()

    val pipe = br.readLine().split(" ").map { it.toInt() }.toIntArray().sortedArray()

    var range = 0.0
    var answer = 0
    for (p in pipe) {
        if (p > range) {
            answer++
            range = p + l - 0.5
        }
    }

    print(answer)
}