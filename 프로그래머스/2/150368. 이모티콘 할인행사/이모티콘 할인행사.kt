import java.util.*

class Solution {
    fun solution(users: Array<IntArray>, emoticons: IntArray): IntArray {
        val sales = intArrayOf(10, 20, 30, 40)
        val N = emoticons.size
        
        var maxCount = 0
        var maxPrice = 0
        
        fun calc(arr: IntArray) {
            var pCount = 0
            var totalPrice = 0
            for ((sale, limit) in users) {
                var total = 0
                for (i in 0 until N) {
                    if (sale <= arr[i]) {
                        total += (emoticons[i] * (100 - arr[i]) / 100)
                    }
                }
                
                if (total < limit) {
                    totalPrice += total
                } else {
                   pCount++ 
                }
            }
            
            if (pCount > maxCount || pCount == maxCount && totalPrice > maxPrice) {
                maxCount = pCount
                maxPrice = totalPrice
            }
        }
        
        fun dfs(depth: Int, arr: IntArray) {
            if (depth == N) {
                calc(arr)
                return
            }
            
            for (rate in sales) {
                arr[depth] = rate
                dfs(depth + 1, arr)
            }
        }
        
        dfs(0, IntArray(N))
        
        return intArrayOf(maxCount, maxPrice)
    }
}