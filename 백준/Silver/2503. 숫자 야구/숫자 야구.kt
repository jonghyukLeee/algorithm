import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val numberList = mutableListOf<Int>()
    val isVisited = BooleanArray(10)

    for (i in 1 .. 9) {
        isVisited[i] = true
        dfs(numberList, isVisited, i.toString())
        isVisited[i] = false
    }

    val answerList: MutableList<MutableList<Int>> = mutableListOf()
    val n = br.readLine().toInt()
    repeat(n) {
        answerList.add(br.readLine().split(" ").map { it.toInt() }.toMutableList())
    }

    var answerCount = 0
    for (number in numberList) {
        val set = hashSetOf<Int>()
        val tmpNumbers = mutableListOf<Int>()
        var isValid = true
        number.toString().forEach {
            val cur = it - '0'
            set.add(cur)
            tmpNumbers.add(cur)
        }
        for (answer in answerList) {
            val (q, s, b) = answer
            var (sCount, bCount) = 0 to 0

            for (i in 0 .. 2) {
                val cur = q.toString()[i] - '0'

                // 자릿수가 동일하면
                if (cur == tmpNumbers[i]) {
                    sCount++
                } else if (set.contains(cur)) {
                    bCount++
                }
            }

            if (sCount != s || bCount != b) {
                isValid = false
                break
            }
        }

        if (isValid) {
            answerCount++
        }
    }

    print(answerCount)
}

fun dfs(numberList: MutableList<Int>, isVisited: BooleanArray, str: String) {
    if (str.length == 3) {
        numberList.add(str.toInt())
    } else {
        for (i in 1 .. 9) {
            if (!isVisited[i]) {
                isVisited[i] = true
                dfs(numberList, isVisited, str + i)
                isVisited[i] = false
            }
        }
    }
}