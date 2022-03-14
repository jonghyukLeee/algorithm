package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q10844 {
    static long [][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        dp = new long[N+1][10];

        //N = 1일때 초기화
        for(int i = 0; i < 10; ++i)
        {
            dp[1][i] = 1;
        }
        // 0으로 시작하는 수 초기화
        for(int i = 2; i <= N; ++i)
        {
            // 0으로 시작하는 수
            dp[i][0] = dp[i-1][1] % 1000000000;

            //1~8로 시작하는 수
            for(int j = 1; j < 9; ++j)
            {
                dp[i][j] = (dp[i-1][j-1] + dp[i-1][j+1]) % 1000000000;
            }

            //9로 시작하는 수
            dp[i][9] = dp[i-1][8] % 1000000000;
        }

        long answer = 0;
        for(int i = 1; i < 10; ++i) answer+=(dp[N][i]%1000000000);
        System.out.print(answer%1000000000);
    }
}
