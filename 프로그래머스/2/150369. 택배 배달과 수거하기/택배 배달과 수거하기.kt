import java.util.*

class Solution {
    fun solution(cap: Int, n: Int, deliveries: IntArray, pickups: IntArray): Long {
        var lastDIndex = -1
    var lastPIndex = -1
    for (i in n - 1 downTo 0) {
        if (lastDIndex < 0 && deliveries[i] > 0) {
            lastDIndex = i
        }
        
        if (lastPIndex < 0 && pickups[i] > 0) {
            lastPIndex = i
        }
        
        if (lastDIndex > 0 && lastPIndex > 0) break
    }
    var dFlag = false
    var pFlag = false

    fun run(array: IntArray, lastIndex: Int, type: Int) {
        var capCount = 0
        var nextIndex = lastIndex
        for (i in lastIndex downTo 0) {
            if (array[i] < 1) continue

            if (capCount + array[i] <= cap) {
                capCount += array[i]
                array[i] = 0
                nextIndex = i - 1
            } else {
                array[i] -= (cap - capCount)
                capCount = cap
                nextIndex = i
                break
            }
        }

        for (i in nextIndex downTo 0) {
            if (array[i] < 1) {
                nextIndex = i - 1
            } else break
        }

        if (nextIndex < 0) {
            if (type > 0) {
                lastDIndex = -1
                dFlag = true
            } else {
                lastPIndex = -1
                pFlag = true
            }
        } else {
            if (type > 0) {
                lastDIndex = nextIndex
            } else {
                lastPIndex = nextIndex
            }
        }
    }

    var answer = 0L
    while (!dFlag || !pFlag) {
        val dist = maxOf(lastDIndex, lastPIndex) + 1
        answer += (dist * 2)

        if (!dFlag) run(deliveries, lastDIndex, 1)
        if (!pFlag) run(pickups, lastPIndex, 0)
    }

    return answer
    }
}