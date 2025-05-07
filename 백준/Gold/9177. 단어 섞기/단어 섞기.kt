import java.util.LinkedList
import java.util.Queue

fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()

    val sb = StringBuilder()
    for (caseNum in 1..n) {
        val parts = br.readLine().split(" ")
        val word1 = parts[0]
        val word2 = parts[1]
        val target = parts[2]

        sb.append("Data set $caseNum: ")

        if (word1.length + word2.length != target.length) {
            sb.append("no\n")
            continue
        }

        val q: Queue<Pair<Int, Int>> = LinkedList()
        // visited[i][j] : word1에서 i개, word2에서 j개 문자를 사용한 상태 방문 여부
        val visited = Array(word1.length + 1) { BooleanArray(word2.length + 1) }

        q.offer(Pair(0, 0)) // (word1 사용 개수, word2 사용 개수)
        visited[0][0] = true
        var possible = false

        while (q.isNotEmpty()) {
            val (idx1, idx2) = q.poll()
            val targetIdx = idx1 + idx2

            if (targetIdx == target.length) {
                possible = true
                break
            }

            // 1. word1의 다음 문자를 사용하는 경우
            if (idx1 < word1.length && word1[idx1] == target[targetIdx]) {
                if (!visited[idx1 + 1][idx2]) {
                    visited[idx1 + 1][idx2] = true
                    q.offer(Pair(idx1 + 1, idx2))
                }
            }

            // 2. word2의 다음 문자를 사용하는 경우
            if (idx2 < word2.length && word2[idx2] == target[targetIdx]) {
                if (!visited[idx1][idx2 + 1]) {
                    visited[idx1][idx2 + 1] = true
                    q.offer(Pair(idx1, idx2 + 1))
                }
            }
        }

        if (possible) {
            sb.append("yes\n")
        } else {
            sb.append("no\n")
        }
    }
    print(sb.toString())
}