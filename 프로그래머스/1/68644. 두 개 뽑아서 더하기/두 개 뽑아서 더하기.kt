import java.util.*

class Solution {
    fun solution(numbers: IntArray): IntArray {
        val len = numbers.size
    val set = mutableSetOf<Int>()
    
    for (i in 0 until len) {
        for (j in i + 1 until len) {
            set.add(numbers[i] + numbers[j])
        }
    }
    return set.toIntArray().sortedArray()
    }
}