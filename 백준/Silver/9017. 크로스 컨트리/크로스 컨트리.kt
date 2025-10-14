import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.PriorityQueue

fun main() {
    data class Cross(val n: Int, var count: Int = 0, var score: Int = 0, var five: Int = 0) {
        fun setScore(score: Int): Cross {
            this.count += 1
            if (this.count <= 4) {
                this.score += score
            }
            if (this.count == 5) {
                this.five = score
            }

            return this
        }
    }
    val br = BufferedReader(InputStreamReader(System.`in`))
    val t = br.readLine().toInt()

    val sb = StringBuilder()
    repeat(t) {
        val n = br.readLine().toInt()

        val countMap = mutableMapOf<Int, Int>()
        val board = br.readLine().split(" ")

        for (i in 0 until n) {
            val team = board[i].toInt()
            countMap[team] = countMap.getOrDefault(team, 0) + 1
        }

        val teams = mutableMapOf<Int, Cross>()
        var nextScore = 1
        for (i in 0 until n) {
            val team = board[i].toInt()
            if (countMap[team]!! >= 6) {
                teams[team] = teams.getOrDefault(team, Cross(n = team)).setScore(nextScore++)
            }
        }

        val pq = PriorityQueue(compareBy<Cross> { it.score }.thenBy { it.five })

        for (team in teams.values) {
            pq.add(team)
        }

        sb.append("${pq.poll().n}\n")
    }

    print(sb.trimEnd('\n'))
}