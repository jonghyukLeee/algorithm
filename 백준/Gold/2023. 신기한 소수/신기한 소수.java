import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static int N;
    static int[] defaultPrimeNumber = {1, 3, 5, 7, 9};
    static List<Integer> answerList;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        answerList = new ArrayList<>();
        N = Integer.parseInt(br.readLine());

        int[] startNumbers = {2, 3, 5, 7, 9};

        for (int startNumber: startNumbers) {
            dfs(startNumber, 1);
        }

        StringBuilder sb = new StringBuilder();

        for (int answer: answerList) {
            sb.append(answer).append("\n");
        }

        sb.deleteCharAt(sb.length() - 1);
        System.out.print(sb);
    }
    static void dfs(int number, int numberLength) {
        if (numberLength <= N) {
            if (isPrime(number)) {
                if (numberLength == N) {
                    answerList.add(number);
                } else {
                    for (int i = 0; i < 5; i++) {
                        int nextNumber = (number * 10) + defaultPrimeNumber[i];
                        dfs(nextNumber, numberLength + 1);
                    }
                }
            }
        }
    }

    static boolean isPrime(int number) {
        for (int i = 2; i <= number / 2; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
