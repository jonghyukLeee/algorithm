import java.util.*

class Solution {
    fun solution(s: String): IntArray {
        val str = s.removePrefix("{{").removeSuffix("}}")
        val arrays = str.split("},{").sortedBy { it.length }
        
        val set = mutableSetOf<Int>()
        val answerList = mutableListOf<Int>()
        
        if (arrays.size > 1) {
            for (array in arrays) {
            val numbers = array.split(",")
            for (number in numbers) {
                val n = number.toInt()
                if (!set.contains(n)) {
                    set.add(n)
                    answerList.add(n)
                }
            }
        }
        } else {
            answerList.add(arrays[0].toInt())
        }
        
        return answerList.toIntArray()
    }
}