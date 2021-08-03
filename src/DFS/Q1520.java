package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Q1520 {
    static int [][] map;
    static int [][] dp;
    static int [] dx = {0,0,-1,1};
    static int [] dy = {1,-1,0,0};
    static int m,n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        map = new int[m][n];
        dp = new int[m][n];

        for(int i = 0; i < m; ++i)
        {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; ++j)
            {
                map[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = -1;
            }
        }

        System.out.print(dfs(0,0));

    }
    static int dfs(int i, int j)
    {
        if(i == m-1 && j == n-1)
        {
            return 1;
        }

        if(dp[i][j] != -1)
        {
            return dp[i][j];
        }
        dp[i][j] = 0;
        for(int idx = 0; idx < 4; ++idx)
        {
            int x = i + dx[idx];
            int y = j + dy[idx];

            if(!isValid(x,y) || map[x][y] >= map[i][j]) continue;

            dp[i][j] += dfs(x,y);
        }
        return dp[i][j];
    }
    static boolean isValid(int x, int y)
    {
        return x >= 0 && y >= 0 && x < m && y < n;
    }
}
