package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Q9095 {
    static int [] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        int max = Integer.MIN_VALUE;
        ArrayList<Integer> al = new ArrayList<>();

        for(int i = 0; i < t; ++i)
        {
            int tmp = Integer.parseInt(br.readLine());
            max = Math.max(max,tmp);
            al.add(tmp);
        }

        dp = new int[max+1];

        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        for(int i = 4; i < dp.length; ++i)
        {
            dp[i] = dp[i-3] + dp[i-2] + dp[i-1];
        }

        StringBuilder sb = new StringBuilder();

        for(Integer i : al)
        {
            sb.append(dp[i]).append("\n");
        }

        System.out.print(sb.toString());
    }
}
