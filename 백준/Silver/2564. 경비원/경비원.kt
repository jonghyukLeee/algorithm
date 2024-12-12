import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (w, h) = br.readLine().split(" ").map { it.toInt() }
    val perimeter = 2 * (w + h)

    fun getDistance(dir: Int, dist: Int): Int {
        return when (dir) {
            // 북 남 서 동
            1 -> dist
            2 -> w + h + (w - dist)
            3 -> perimeter - dist
            4 -> w + dist
            else -> -1
        }
    }

    val storeCount = br.readLine().toInt()
    val storeList = mutableListOf<List<Int>>()
    repeat(storeCount) {
        storeList.add(br.readLine().split(" ").map { it.toInt() })
    }

    val (dir, dist) = br.readLine().split(" ").map { it.toInt() }
    val dongDist = getDistance(dir, dist)

    var answer = 0
    for (store in storeList) {
        val storeDist = getDistance(store[0], store[1])
        val diff = Math.abs(storeDist - dongDist)

        answer += minOf(diff, perimeter - diff)
    }

    print(answer)
}