import kotlin.math.abs
import java.util.*

class Solution {
    fun solution(n: Int, m: Int, x: Int, y: Int, r: Int, c: Int, k: Int): String {
        data class Location(val x: Int, val y: Int, val str: String = "")
    
    fun isValid(x: Int, y: Int): Boolean {
        return x > 0 && y > 0 && x <= n && y <= m
    }

    fun convert(idx: Int): String {
        return when (idx) {
            0 -> "d"
            1 -> "l"
            2 -> "r"
            else -> "u"
        }
    }

    val exit = r to c
    val dx = intArrayOf(1, 0, 0, -1)
    val dy = intArrayOf(0, -1, 1, 0)
    var flag = false
    
    fun canMove(i: Int, j: Int, moveCount: Int): Boolean {
        val dist = abs(i - exit.first) + abs(j - exit.second)
        val remain = k - moveCount
        
        return dist <= remain && (dist - remain) % 2 == 0
    }
    
    val sb = StringBuilder()
    fun dfs(i: Int, j: Int, depth: Int) {
        if (flag) return
        
        if(depth == k) {
            if (i == exit.first && j == exit.second) {
                flag = true
            }
            return
        }
        
        for(idx in 0 until 4) {
            val mx = i + dx[idx]
            val my = j + dy[idx]

            if(isValid(mx, my) && canMove(mx, my, depth + 1)) {
                sb.append(convert(idx))
                dfs(mx, my, depth + 1)
                if (flag) return
                sb.deleteCharAt(sb.length - 1)
            }
        }
    }

    dfs(x, y, 0)
    return if (flag) sb.toString() else "impossible"
    }
}