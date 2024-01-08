import java.io.BufferedReader
import java.io.InputStreamReader
    fun main() {
        val br = BufferedReader(InputStreamReader(System.`in`))
        val sb = StringBuilder()
        while (true) {
            val inputPassword = br.readLine()
            if (inputPassword == "end") break
            var flag = false
            var prev = '0'
            var count = 0
            for (current in inputPassword.toCharArray()) {
                if (isVowel(current)) {
                    flag = true
                }

                if (isVowel(prev) == isVowel(current)) {
                    count++
                } else {
                    count = 1
                }

                if (count > 2 || ((current == prev) && (current != 'e' && current != 'o'))) {
                    flag = false
                    break
                }

                prev = current
            }

            sb.append("<${inputPassword}> is ")
            if (!flag) sb.append("not ")
            sb.append("acceptable.\n")
        }
        sb.deleteCharAt(sb.lastIndex)
        print(sb)
    }
    private fun isVowel(alpha: Char): Boolean {
        return alpha == 'a' || alpha == 'e' || alpha == 'i' || alpha == 'o' || alpha == 'u'
    }