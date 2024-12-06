import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val N = br.readLine().toInt()
    val list = mutableListOf<Pair<Int, Int>>()
    repeat(N) {
        val (s, b) = br.readLine().split(" ").map { it.toInt() }
        list.add(s to b)
    }

    var answer = Integer.MAX_VALUE

    fun dfs (n: Int, s: Int, b: Int) {
        answer = minOf(answer, Math.abs(s - b))

        for (i in n + 1 until N) {
            val sTotal = s * list[i].first
            val bTotal = b + list[i].second

            dfs(i, sTotal, bTotal)
        }
    }

    for (i in 0 until N) {
        val s = list[i].first
        val b = list[i].second

        dfs(i, s, b)
    }

    print(answer)
}