package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1937 {
    static int maxVal = Integer.MIN_VALUE;
    static int [][] map;
    static int [][] dp;
    static boolean [][] isVis;
    static int [] dx = {0,0,-1,1};
    static int [] dy = {1,-1,0,0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        map = new int[n][n];
        dp = new int[n][n];

        for(int i = 0; i < n; ++i)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; ++j)
            {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < n; ++i)
        {
            for(int j = 0; j < n; ++j)
            {
                dp[i][j] = dfs(i,j);
                maxVal = Math.max(dp[i][j],maxVal);
            }
        }
        System.out.print(maxVal);
    }
    static int dfs(int x, int y)
    {
        if(dp[x][y] > 0)
        {
            return dp[x][y];
        }
        dp[x][y] = 1;
        for(int i = 0; i < 4; ++i)
        {
            int mx = x + dx[i];
            int my = y + dy[i];

            if(!isValid(mx,my) || map[x][y] >= map[mx][my]) continue;
            dp[x][y] = Math.max(dfs(mx,my)+1,dp[x][y]);
        }
        return dp[x][y];
    }
    static boolean isValid(int x, int y)
    {
        return x >= 0 && y >= 0 && x < map.length && y < map[0].length;
    }
}
