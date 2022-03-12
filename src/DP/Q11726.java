package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q11726 {
    static int [] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        if(n == 1)
        {
            System.out.print("1");
            return;
        }
        dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;

        for(int i = 3; i <= n; ++i)
        {
            dp[i] = (dp[i-2] + dp[i-1]) % 10007;
        }

        System.out.print(dp[n]);
    }
}
