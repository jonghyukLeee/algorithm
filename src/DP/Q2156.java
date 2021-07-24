package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q2156 {
    static int [] map;
    static int [] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        map = new int[n+1];
        dp = new int[n+1];

        for(int i = 1; i <= n; ++i)
        {
            map[i] = Integer.parseInt(br.readLine());
        }
        dp[0] = 0;
        dp[1] = map[1];

        if(n > 1)
        {
            dp[2] = map[1] + map[2];
        }

        for(int i = 3; i <= n; ++i)
        {
            dp[i] = Math.max(dp[i - 1], Math.max(dp[i - 2] + map[i], dp[i - 3] + map[i - 1] + map[i]));
        }

        Arrays.sort(dp);

        System.out.print(dp[n]);
    }
}
