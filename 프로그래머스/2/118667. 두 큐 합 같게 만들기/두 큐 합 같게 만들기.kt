import java.util.*

class Solution {
    fun solution(queue1: IntArray, queue2: IntArray): Int {
        val q1 = ArrayDeque<Int>()
        val q2 = ArrayDeque<Int>()
        
        val N = queue1.size
        var total = 0L
        var lTotal = 0L
        var rTotal = 0L
        
        for (i in 0 until N) {
            val l = queue1[i].toLong()
            val r = queue2[i].toLong()
            
            lTotal += l
            rTotal += r
            total += (l + r)
            
            q1.addLast(l.toInt())
            q2.addLast(r.toInt())
        }
        
        var count = 0
        return if ((total % 2L).toInt() == 1) {
            -1
        } else {
            var maxCount = N * 3
            while (lTotal != rTotal) {
                if (count > maxCount) {
                    count = -1
                    break
                }
            count++
            if (lTotal > rTotal) {
                val n = q1.removeFirst()
                q2.addLast(n)
                lTotal -= n.toLong()
                rTotal += n.toLong()
            } else {
                val n = q2.removeFirst()
                q1.addLast(n)
                lTotal += n.toLong()
                rTotal -= n.toLong()
            }
        }
        count
        }
    }
}