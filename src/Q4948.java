import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Q4948 {
    static boolean [] notPrime;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> inputs = new ArrayList<>();
        int maxValue = Integer.MIN_VALUE;

        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n < 1) break;
            //입력값 중 최댓값
            maxValue = Math.max(maxValue, n);
            inputs.add(n);
        }
        notPrime = new boolean[(maxValue * 2) + 1];
        getPrime(notPrime.length);

        int[] primeCount = new int[notPrime.length];
        for (int i = 1; i < primeCount.length; i++) {
            // 소수가 아니면 그대로, 맞으면 + 1
            primeCount[i] = notPrime[i] ? primeCount[i - 1] : primeCount[i - 1] + 1;
        }

        StringBuilder sb = new StringBuilder();
        for (int start : inputs) {
            int end = start * 2;
            sb.append(primeCount[end] - primeCount[start]).append("\n");
        }
        System.out.print(sb);
    }
    static void getPrime(int size) {
        for (int i = 2; i * i < size; i++) {
            if (!notPrime[i]) {
                for (int j = i * i; j < size; j += i) {
                    notPrime[j] = true;
                }
            }
        }
    }
}
