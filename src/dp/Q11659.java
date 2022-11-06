package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q11659 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int [] map = new int[n+1];
        int [] dp = new int[n+1];
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; ++i)
        {
            map[i] = Integer.parseInt(st.nextToken());
            dp[i] = dp[i-1] + map[i];
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < m; ++i)
        {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            sb.append(dp[end]- dp[start-1]).append("\n");
        }
        System.out.print(sb);
    }
}
