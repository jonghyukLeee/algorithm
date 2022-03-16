package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q15486 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int [] t = new int[N+1];
        int [] p = new int[N+1];
        StringTokenizer st;
        for(int i = 0; i < N; ++i)
        {
            st = new StringTokenizer(br.readLine());
            t[i] = Integer.parseInt(st.nextToken());
            p[i] = Integer.parseInt(st.nextToken());
        }

        int [] dp = new int[N+1];
        int max_val = Integer.MIN_VALUE;
        for(int i = 0; i <= N; ++i)
        {
            max_val = Math.max(max_val,dp[i]);

            int next = i + t[i];
            if(next <= N)
            {
                dp[next] = Math.max(dp[next],max_val+p[i]);
            }
        }
        System.out.print(max_val);
    }
}
