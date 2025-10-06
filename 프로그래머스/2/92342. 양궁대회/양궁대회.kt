import java.util.*

class Solution {
    fun solution(n: Int, info: IntArray): IntArray {
    val q = ArrayDeque<Pair<Int, IntArray>>()
    var max = Integer.MIN_VALUE
    fun dfs(depth: Int, count: Int, board: IntArray, rScore: Int, aScore: Int) {
        if (depth > 10) {
            if (rScore > aScore) {
                val diff = rScore - aScore

                if (diff >= max) {
                    max = maxOf(max, diff)
                    q.addLast(diff to board.copyOf())
                }
            }
            return
        }

        val idx = 10 - depth

        if (count < n) {
            val arrow = info[idx] + 1
            if (count + arrow <= n) {
                board[idx] = arrow
                dfs(depth + 1, count + arrow, board, rScore + depth, aScore)
                board[idx] = 0
            }
        }

        // 지는경우
        for (i in info[idx] downTo 0) {
            if (count + i <= n) {
                board[idx] = i
                dfs(depth + 1, count + i, board, rScore, aScore + if(board[idx] == 0 && info[idx] == 0) 0 else depth)
                board[idx] = 0
            }
        }
    }

    dfs(0, 0, IntArray(11) { 0 }, 0, 0)

    var result: IntArray? = null

    while(q.isNotEmpty()) {
        val next = q.removeFirst()

        if (next.first == max) {
            result = next.second
            break
        }
    }

    return result ?: intArrayOf(-1)
    }
}