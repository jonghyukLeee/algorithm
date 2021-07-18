package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q1912 {
    static int [] map;
    static int [] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        map = new int[n];
        dp = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; ++i)
        {
            map[i] = Integer.parseInt(st.nextToken());
        }

        dp[0] = map[0];

        for(int i = 1; i < n; ++i)
        {
            dp[i] = Math.max(map[i],dp[i-1]+map[i]);
        }

        Arrays.sort(dp);

        System.out.print(dp[map.length-1]);
    }
}
