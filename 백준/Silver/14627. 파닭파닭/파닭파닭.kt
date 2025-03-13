import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (s, c) = readLine().split(" ").map { it.toInt() }
    val lengths = LongArray(s) { readLine().toLong() } // 파 길이 배열

    // 이분 탐색으로 최대 길이 찾기
    val maxLength = binarySearch(lengths, c)
    
    // 사용된 파와 남은 파 계산
    val totalLength = lengths.sum()
    val usedLength = maxLength * c
    val remaining = totalLength - usedLength

    println(remaining)
}

// 이분 탐색: 파닭에 넣을 수 있는 최대 길이 반환
fun binarySearch(lengths: LongArray, c: Int): Long {
    var left = 1L
    var right = lengths.maxOrNull() ?: 1L // 최대 파 길이

    while (left <= right) {
        val mid = (left + right) / 2
        val count = lengths.sumOf { it / mid } // mid 길이로 만들 수 있는 파닭 수

        if (count >= c) {
            // 더 큰 길이 시도
            left = mid + 1
        } else {
            // 길이 줄이기
            right = mid - 1
        }
    }
    return right // 가능한 최대 길이
}