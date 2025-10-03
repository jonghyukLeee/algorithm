import java.util.*

class Solution {
    fun solution(today: String, terms: Array<String>, privacies: Array<String>): IntArray {
    val term = mutableMapOf<String, Int>()
    for (str in terms) {
        val t = str.split(" ")
        term[t[0]] = t[1].toInt()
    }

    data class CustomDate(var year: Int, var month: Int, var day: Int, val expiry: Int) {
        fun calc(): CustomDate {
            val totalMonth = month + expiry
            var afterMonth = this.month
            var afterDay = this.day - 1
            if (totalMonth > 12) {
                this.year += (totalMonth / 12)
                afterMonth = totalMonth % 12
            } else {
                afterMonth = totalMonth
            }

            if (afterDay == 0) {
                afterDay = 28
                afterMonth--
            }

            if (afterMonth == 0) {
                this.year--
                afterMonth = 12
            }

            this.month = afterMonth
            this.day = afterDay
            return this
        }

        fun isExpired(target: CustomDate): Boolean {
            return if (this.year < target.year) {
                true
            } else if (this.year == target.year && this.month < target.month) {
                true
            } else if (
                this.year == target.year
                && this.month == target.month
                && this.day < target.day
            ) {
                true
            } else false
        }
    }

    val size = privacies.size
    val array = Array(size) { CustomDate(0, 0, 0, 0) }

    for (i in 0 until size) {
        val split = privacies[i].split(" ")
        val dateString = split[0]

        val dateSplit = dateString.split(".")
        array[i] = CustomDate(dateSplit[0].toInt(), dateSplit[1].toInt(), dateSplit[2].toInt(), term[split[1]]!!)
    }

    val answer = mutableListOf<Int>()
    val todaySplit = today.split(".")
    val todayCustomDate = CustomDate(todaySplit[0].toInt(), todaySplit[1].toInt(), todaySplit[2].toInt(), 0)
    for (i in 0 until size) {
        val result = array[i].calc()
        if (result.isExpired(todayCustomDate)) {
            answer.add(i + 1)
        }
    }

    return answer.toIntArray()
    }
}