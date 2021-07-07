package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1463 {
    static int [] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        dp = new int[n+1];

        dp[1] = 0;
        dp[2] = 1;
        dp[3] = 1;

        for(int i = 4; i < dp.length; ++i)
        {
            dp[i] = dp[i-1] + 1;
        }

        System.out.print(dp[n]);
    }
}
