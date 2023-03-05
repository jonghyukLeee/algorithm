package Etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1929 {
    static int M, N;
    static boolean [] notPrime;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        notPrime = new boolean [N + 1];

        // 2보다 작으면 끝
        if (N < 2) {
            return;
        }

        notPrime[1] = true;

        makePrimes();

        StringBuilder sb = new StringBuilder();
        for (int i = M; i <= N; i++) {
            if (!notPrime[i]) {
                sb.append(i).append("\n");
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.print(sb);
    }

    static void makePrimes() {
        for (int i = 2; i * i <= N; i++) {
            if (!notPrime[i]) {
                for (int j = i * i; j <= N; j += i) {
                    notPrime[j] = true;
                }
            }
        }
    }
}
