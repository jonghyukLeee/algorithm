import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    br.readLine()

    val charArr = br.readLine().toCharArray()

    var answer = 0
    for (c in charArr) {
        answer += c - '0'
    }

    print(answer)
}