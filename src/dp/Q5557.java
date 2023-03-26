package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q5557 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int [] numbers = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        long [][] dp = new long[N][21];

        dp[0][numbers[0]] = 1;

        for (int i = 1; i < N; i++) {
            for (int j = 0; j <= 20; j++) {
                if (dp[i - 1][j] > 0) {
                    if (j + numbers[i] <= 20) dp[i][j + numbers[i]] += dp[i - 1][j];
                    if (j - numbers[i] >= 0) dp[i][j - numbers[i]] += dp[i - 1][j];
                }
            }
        }

        System.out.println(dp[N - 2][numbers[N - 1]]);
    }
}
