import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val map = Array(4) { ArrayDeque<Int>() }
    for (i in 0 until 4) {
        map[i].addAll(br.readLine().map { it - '0' })
    }

    val n = br.readLine().toInt()

    repeat(n) {
        val cmdList = mutableListOf<Pair<Int, Int>>()
        var (number, dir) = br.readLine().split(" ").map { it.toInt() }
        val startDir = dir

        cmdList.add(number to dir)

        // 왼쪽
        for (i in number downTo 2) {
            val nine = map[i - 1].toList()[6]
            val three = map[i - 2].toList()[2]

            if (nine != three) {
                dir *= -1
                cmdList.add(i - 1 to dir)
            } else break
        }

        // 오른쪽
        dir = startDir
        for (i in number until 4) {
            val three = map[i - 1].toList()[2]
            val nine = map[i].toList()[6]

            if (three != nine) {
                dir *= -1
                cmdList.add(i + 1 to dir)
            } else break
        }

        fun rotate(number: Int, dir: Int) {
            val deque = map[number - 1]
            if (dir > 0) {
                deque.addFirst(deque.removeLast())
            } else deque.addLast(deque.removeFirst())
        }

        for (next in cmdList) {
            rotate(next.first, next.second)
        }
    }

    var point = 1
    var answer = 0
    for (deque in map) {
        if (deque.toList()[0] > 0) {
            answer += point
        }
        point *= 2
    }

    print(answer)
}