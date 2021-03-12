package Week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1904 {
    static int [] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        dp = new int[1000000];
        dp[0] = 1;
        dp[1] = 2;
        for(int i = 2; i < n; ++i)
        {
            dp[i] = (dp[i-2] + dp[i-1]) % 15746;
        }
        System.out.print(dp[n-1]);
    }
}
