import java.util.*

class Solution {
    fun solution(fees: IntArray, records: Array<String>): IntArray {
        val board = mutableMapOf<Int, Int>()
        val history = mutableMapOf<Int, Int>()
        val pq = PriorityQueue(compareBy<Pair<Int, Int>> { it.first }.thenByDescending { it.second })
        
        for (str in records) {
            val split = str.split(" ")
            val (h, m) = split[0].split(":").map{ it.toInt() }
            val number = split[1].toInt()
            val cmd = split[2]
            val time = (h * 60) + m
            
            if (cmd == "IN") {
                board[number] = time
            } else {
                history.put(number, history.getOrDefault(number, 0) + time - board[number]!!)
                board.remove(number)
            }
        }
        
        for ((number, time) in board) {
            val outTime = 1439
            history.put(number, history.getOrDefault(number, 0) + outTime - time)
        }
        
        for ((number, time) in history) {
            var result = fees[1]
            
            if (time > fees[0]) {
                val diff = time - fees[0]
                
                var count = (diff / fees[2])
                if (diff % fees[2] > 0) count++
                
                result += (count * fees[3])
            }
            pq.add(number to result)
        }
        val resultList = mutableListOf<Int>()
        
        while(pq.isNotEmpty()) resultList.add(pq.poll().second)
        return resultList.toIntArray()
    }
}