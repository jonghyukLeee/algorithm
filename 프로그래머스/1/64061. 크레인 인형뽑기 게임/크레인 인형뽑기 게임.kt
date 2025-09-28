import java.util.*
class Solution {
    fun solution(board: Array<IntArray>, moves: IntArray): Int {
        val width = board[0].size
        
        val map = Array(width) { ArrayDeque<Int>() }
        for (line in board) {
            for (i in 0 until width) {
                if (line[i] > 0) {
                    map[i].addLast(line[i])
                }
            }
        }
        
        val basket = ArrayDeque<Int>()
        var answer = 0
        for (i in moves) {
            val doll = if (map[i - 1].isEmpty()) 0 else map[i - 1].removeFirst()
            if (doll > 0) {
                if (basket.isNotEmpty() && basket.last() == doll) {
                basket.removeLast()
                answer++
            } else {
                basket.addLast(doll)
            }
            }
        }
        return answer * 2
    }
}