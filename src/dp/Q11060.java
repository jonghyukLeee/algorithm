package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q11060 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int [] map = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            map[i] = Integer.parseInt(st.nextToken());
        }

        int [] dp = new int[N];
        Arrays.fill(dp,Integer.MAX_VALUE - 1);
        dp[0] = 0;

        for (int i = 0; i < N; i++) {
            int steps = map[i];
            int jumpCount = dp[i] + 1;
            for (int j = i + steps; j > i; j--) {
                if (j < N) {
                    dp[j] = Math.min(dp[j], jumpCount);
                }
            }
        }

        System.out.print(dp[N-1] == Integer.MAX_VALUE - 1 ? -1 : dp[N-1]);
    }
}
