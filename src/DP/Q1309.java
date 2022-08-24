package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1309 {
    static int N;
    static int [][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        /*
         * dp[N][M]
         * N = 라인 수
         * M = 0 사자가 없는경우
         * M = 1 사자가 왼쪽에만 있는경우
         * M = 2 사자가 오른쪽에만 있는경우
        */

        dp = new int[N + 1][3];

        dp[1][0] = 1;
        dp[1][1] = 1;
        dp[1][2] = 1;

        // dp[N] 이 N번씩 반복
        for (int i = 2; i <= N; i++) {
            dp[i][0] = (dp[i-1][0] + dp[i-1][1] + dp[i-1][2]) % 9901;
            dp[i][1] = (dp[i-1][0] + dp[i-1][2]) % 9901;
            dp[i][2] = (dp[i-1][0] + dp[i-1][1]) % 9901;
        }

        System.out.print(dp[N][0] + dp[N][1] + dp[N][2]);
    }
}
