import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.system.exitProcess

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val N = br.readLine().toInt()

    if (N == 1) {
        print(4)
        exitProcess(0)
    }

    val sides: Array<Long> = Array(N + 1) { 0 }
    val perimeters: Array<Long> = Array(N + 1) { 0 }

    sides[1] = 1
    sides[2] = 1

    perimeters[1] = 4
    perimeters[2] = 6

    for (i in 3 .. N) {
        sides[i] = sides[i - 2].plus(sides[i - 1])
        perimeters[i] = perimeters[i - 1].plus(sides[i].times(2))
    }

    print(perimeters[N])
}