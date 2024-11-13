import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine()

    val line = br.readLine().split(" ").map { it.toInt() }

    val stk = Stack<Int>()
    var count = 1
    for (i in line) {
        if (i == count) {
            count++
        } else {
            stk.push(i)
        }

        while (stk.isNotEmpty() && stk.peek() == count) {
            stk.pop()
            count++
        }
    }

    var answer = "Nice"
    if (stk.isNotEmpty()) {
        answer = "Sad"
    }

    print(answer)
}