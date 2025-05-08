fun main() {
    while (true) {
        val board = readLine()!!
        if (board == "end") break

        val xCount = board.count { it == 'X' }
        val oCount = board.count { it == 'O' }

        fun isWin(c: Char): Boolean {
            val winPos = listOf(
                listOf(0,1,2), listOf(3,4,5), listOf(6,7,8), // 가로
                listOf(0,3,6), listOf(1,4,7), listOf(2,5,8), // 세로
                listOf(0,4,8), listOf(2,4,6)                // 대각
            )
            return winPos.any { (a,b,cIdx) -> 
                board[a]==c && board[b]==c && board[cIdx]==c 
            }
        }

        val xWin = isWin('X')
        val oWin = isWin('O')

        val isValid = when {
            oCount > xCount || xCount - oCount > 1 -> false
            oWin && xWin -> false
            oWin && xCount != oCount -> false
            xWin && xCount != oCount +1 -> false
            !xWin && !oWin && xCount + oCount != 9 -> false
            else -> true
        }

        println(if (isValid) "valid" else "invalid")
    }
}
