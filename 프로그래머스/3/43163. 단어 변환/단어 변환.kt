import java.util.*

class Solution {
    fun solution(begin: String, target: String, words: Array<String>): Int {
        // target이 words에 없으면 변환 불가
    if (target !in words) return 0
    
    // 큐에 시작 단어와 변환 횟수를 저장
    val queue: Queue<Pair<String, Int>> = LinkedList()
    queue.offer(Pair(begin, 0))
    
    // 방문 체크 배열
    val visited = BooleanArray(words.size)
    
    // BFS
    while (queue.isNotEmpty()) {
        val (currentWord, count) = queue.poll()
        
        // 현재 단어가 target과 같으면 변환 횟수 반환
        if (currentWord == target) return count
        
        // words 배열에서 한 글자만 다른 단어 찾기
        for (i in words.indices) {
            if (!visited[i] && isConvertible(currentWord, words[i])) {
                visited[i] = true
                queue.offer(Pair(words[i], count + 1))
            }
        }
    }
    
    // 변환할 수 없는 경우
    return 0
    }
    
    fun isConvertible(word1: String, word2: String): Boolean {
    var diffCount = 0
    for (i in word1.indices) {
        if (word1[i] != word2[i]) {
            diffCount++
        }
        if (diffCount > 1) return false
    }
    return diffCount == 1
}
}