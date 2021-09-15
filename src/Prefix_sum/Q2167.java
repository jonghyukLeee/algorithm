package Prefix_sum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2167 {
    static int [][] map;
    static int [][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        map = new int[n+1][m+1];
        dp = new int[n+1][m+1];

        for(int i = 1; i <= n; ++i)
        {
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= m; ++j)
            {
                map[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = dp[i-1][j] + dp[i][j-1] - dp[i-1][j-1] + map[i][j];
            }
        }

        StringBuilder sb = new StringBuilder();
        int k = Integer.parseInt(br.readLine());
        for(int t = 0; t < k; ++t)
        {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            int res = dp[x][y] - dp[x][j-1] - dp[i-1][y] + dp[i-1][j-1];
            sb.append(res).append("\n");
        }

        System.out.print(sb.toString());
    }
}
