import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val s = br.readLine()

    val set = mutableSetOf<String>()
    for (i in s.indices) {
        for (j in i + 1 .. s.length) {
            set.add(s.substring(i, j))
        }
    }

    print(set.size)
}