class Solution {
    fun solution(commands: Array<String>): Array<String> {
        val map = Array(51) { Array<String?>(51) { null } }
        val parent = Array(51) { i -> Array(51) { j -> i to j } }

        fun find(pair: Pair<Int, Int>): Pair<Int, Int> {
            val (r, c) = pair
            if (parent[r][c] == pair) return pair
            val root = find(parent[r][c])
            parent[r][c] = root
            return root
        }

        fun union(a: Pair<Int, Int>, b: Pair<Int, Int>) {
            val ra = find(a)
            val rb = find(b)
            if (ra == rb) return
            val (ar, ac) = ra
            val (br, bc) = rb
            // 값이 있는 쪽 우선
            val value = map[ar][ac] ?: map[br][bc]
            parent[br][bc] = ra
            map[ra.first][ra.second] = value
        }

        fun unmerge(pair: Pair<Int, Int>) {
            val root = find(pair)
            val value = map[root.first][root.second]
            val toReset = mutableListOf<Pair<Int, Int>>()
            for (i in 1..50) {
                for (j in 1..50) {
                    if (find(i to j) == root) toReset.add(i to j)
                }
            }
            for ((r, c) in toReset) {
                parent[r][c] = r to c
                map[r][c] = null
            }
            val (pr, pc) = pair
            map[pr][pc] = value
        }

        val answer = mutableListOf<String>()
        for (cmd in commands) {
            val parts = cmd.split(" ")
            when (parts[0]) {
                "UPDATE" -> {
                    if (parts.size == 4) {
                        val r = parts[1].toInt()
                        val c = parts[2].toInt()
                        val value = parts[3]
                        val (pr, pc) = find(r to c)
                        map[pr][pc] = value
                    } else {
                        val oldValue = parts[1]
                        val newValue = parts[2]
                        for (i in 1..50) {
                            for (j in 1..50) {
                                if (map[i][j] == oldValue) map[i][j] = newValue
                            }
                        }
                    }
                }
                "MERGE" -> {
                    val r1 = parts[1].toInt()
                    val c1 = parts[2].toInt()
                    val r2 = parts[3].toInt()
                    val c2 = parts[4].toInt()
                    union(r1 to c1, r2 to c2)
                }
                "UNMERGE" -> {
                    val r = parts[1].toInt()
                    val c = parts[2].toInt()
                    unmerge(r to c)
                }
                "PRINT" -> {
                    val r = parts[1].toInt()
                    val c = parts[2].toInt()
                    val (pr, pc) = find(r to c)
                    answer.add(map[pr][pc] ?: "EMPTY")
                }
            }
        }

        return answer.toTypedArray()
    }
}
