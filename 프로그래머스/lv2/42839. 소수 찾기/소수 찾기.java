import java.util.HashSet;
import java.util.Set;
class Solution {
    static int SIZE;
    static char [] charArray;
    static Set<Integer> set;
    static boolean [] isNotPrime;
    static int MAX_VALUE = 10_000_000;
    public int solution(String numbers) {
        int answer = 0;
        SIZE = numbers.length();
        charArray = numbers.toCharArray();
        set = new HashSet<>();
        // 만들 수 있는 수
        makeNumbers("", new boolean[SIZE], 0);

        // 소수 모두구함 최댓값 9,999,999
        isNotPrime = new boolean[MAX_VALUE];
        isNotPrime[0] = true;
        isNotPrime[1] = true;
        makePrimes();
        for (int n: set) {
            if (!isNotPrime[n]) answer++;
        }
        return answer;
    }
    static void makeNumbers(String number, boolean [] isVisited, int count) {
        if (count == SIZE) {
            if (number.length() > 0) {
                set.add(Integer.parseInt(number));
            }
            return;
        }

        for (int i = 0; i < SIZE; i++) {
            if (!isVisited[i]) {
                isVisited[i] = true;
                makeNumbers(number + charArray[i], isVisited, count + 1);
                isVisited[i] = false;
                makeNumbers(number, isVisited, count + 1);
            }
        }
    }
    static void makePrimes() {
        for (int i = 2; i*i < MAX_VALUE; i++) {
            if (!isNotPrime[i]) {
                for (int j = i * i; j < MAX_VALUE; j += i) {
                    isNotPrime[j] = true;
                }
            }
        }
    }
}