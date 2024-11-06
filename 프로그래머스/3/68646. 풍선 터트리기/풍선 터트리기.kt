class Solution {
    fun solution(a: IntArray): Int {
        val len = a.size
    if (len <= 2) return len
    val lMin = IntArray(len)
    val rMin = IntArray(len)

    // left
    lMin[0] = a[0]
    for (i in 1 until len) {
       lMin[i] = minOf(lMin[i - 1], a[i])
    }

    rMin[len - 1] = a[len - 1]
    for (i in len - 2 downTo 0) {
        rMin[i] = minOf(rMin[i + 1], a[i])
    }

    var answer = 2

    for(i in 1 until len - 1) {
        if (a[i] <= lMin[i - 1] || a[i] <= rMin[i + 1]) answer++
    }
    
    return answer
    }
}