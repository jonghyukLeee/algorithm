import java.util.*

class Solution {
    fun solution(survey: Array<String>, choices: IntArray): String {
        val countMap = mutableMapOf<Char, Int>()
    val types = charArrayOf('R', 'T', 'C', 'F', 'J', 'M', 'A', 'N')

    for (type in types) countMap[type] = 0

    val size = survey.size
    for (i in 0 until size) {
        val l = survey[i][0]
        val r = survey[i][1]

        val choice = choices[i]
        var side: Char? = null

        var point = 0
        if (choice > 4) {
            point = choice - 4
            side = r
        } else if (choice < 4) {
            point = 4 - choice
            side = l
        }

        if (side != null) {
            countMap[side] = countMap.getOrDefault(side, 0) + point
        }
    }

    val typeSize = types.size
    val sb = StringBuilder()
    for(i in 0 until typeSize - 1 step 2) {
        sb.append(
            if (countMap[types[i]]!! < countMap[types[i + 1]]!!) types[i + 1]
            else types[i]
        )
    }

    return sb.toString()
    }
}