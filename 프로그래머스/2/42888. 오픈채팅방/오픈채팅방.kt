import java.util.*

class Solution {
    fun solution(record: Array<String>): Array<String> {
        val map = mutableMapOf<String, String>()
        val cmdList = mutableListOf<String>()
        for (next in record) {
            val line = next.split(" ")
            val cmd = line[0]
            val uid = line[1]
            
            if (cmd != "Leave") {
                map[uid] = line[2]
            }
            
            if (cmd != "Change") {
                cmdList.add("$cmd $uid")
            }
        }
        
        val result = mutableListOf<String>()
        for(next in cmdList) {
            val line = next.split(" ")
            val cmd = line[0]
            val uid = line[1]
            val message = if (cmd == "Enter") "들어왔습니다" else "나갔습니다"
            result.add("${map[uid]}님이 ${message}.")
        }
        return result.toTypedArray()
    }
}