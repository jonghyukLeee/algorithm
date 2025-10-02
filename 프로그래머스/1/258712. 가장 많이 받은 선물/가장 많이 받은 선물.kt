import java.util.*

class Solution {
    fun solution(friends: Array<String>, gifts: Array<String>): Int {
        val giftCount = mutableMapOf<String, Int>()
        val totalCount = mutableMapOf<String, Int>()
        for (name in friends) {
            giftCount.put(name, 0)
            totalCount.put(name, 0)
        }
        
        val history = mutableMapOf<String, Int>()
        for (gift in gifts) {
            val split = gift.split(" ")
            
            giftCount[split[0]] = giftCount[split[0]]!! + 1
            giftCount[split[1]] = giftCount[split[1]]!! - 1
            history[gift] = history.getOrPut(gift) { 0 } + 1
        }
        
        val size = friends.size
        
        for (i in 0 until size) {
            val l = friends[i]
            for (j in i until size) {
                val r = friends[j]
                val lStr = "$l $r"
                val rStr = "$r $l"
                
                val lCount = history.getOrDefault(lStr, 0)
                val rCount = history.getOrDefault(rStr, 0)
                
                val targetName = if (lCount == rCount) {
                    if (giftCount[l] == giftCount[r]) continue
                    else {
                        if (giftCount[l]!! > giftCount[r]!!) l else r
                    }
                } else {
                    if (lCount > rCount) l else r
                }
                totalCount[targetName] = totalCount[targetName]!! + 1
            }
        }
        var max = 0
        for (n in totalCount.values) {
            max = maxOf(max, n)
        }
        
        return max
    }
}