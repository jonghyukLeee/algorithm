package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q9251 {
    static int [][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String tmp1 = br.readLine();
        String tmp2 = br.readLine();

        String [] fst = tmp1.split("");
        String [] sec = tmp2.split("");
        dp = new int[fst.length+1][sec.length+1];

        for(int i = 1; i < dp.length; ++i)
        {
            for(int j = 1; j < dp[0].length; ++j)
            {
                if(fst[i-1].equals(sec[j-1])) dp[i][j] = dp[i-1][j-1] + 1;
                else dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
        System.out.print(dp[fst.length][sec.length]);
    }
}
