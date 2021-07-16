package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q11053 {
    static int [] map;
    static int [] dp;
    static int answer = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        map = new int[n];
        dp = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        if(n == 1)
        {
            System.out.print(1);
            return;
        }
        for(int i = 0; i < n; ++i)
        {
            map[i] = Integer.parseInt(st.nextToken());
            dp[i] = 1;
        }

        for(int i = 1; i < n; ++i)
        {
            dp[i] += findMax(i);
            answer = Math.max(dp[i],answer);
        }

        System.out.print(answer);

    }
    static int findMax(int idx)
    {
        int tmpMax = Integer.MIN_VALUE;
        for(int i = idx; i >= 0; --i)
        {
            if(map[idx] > map[i])
            {
                tmpMax = Math.max(dp[i],tmpMax);
            }
        }
        if(tmpMax == Integer.MIN_VALUE) return 0;
        return tmpMax;
    }
}
