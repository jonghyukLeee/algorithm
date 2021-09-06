package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q14500 {
    static int [][] map;
    static int [] dx = {0,0,1,-1};
    static int [] dy = {1,-1,0,0};
    static int [][] ex = {{0,0,-1},{0,0,1},{0,-1,1},{-1,1,0}}; // ㅗ ㅜ ㅓ ㅏ
    static int [][] ey = {{-1,1,0},{-1,1,0},{-1,0,0},{0,0,1}};
    static boolean [][] isVis;
    static int n,m;
    static int maxVal = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];

        for(int i = 0; i < n; ++i)
        {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; ++j)
            {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        isVis = new boolean[n][m];
        for(int i = 0; i < n; ++i)
        {
            for(int j = 0; j < m; ++j)
            {
                isVis[i][j] = true;
                dfs(i,j,1,map[i][j]);
                isVis[i][j] = false;
                getElse(i,j);
            }
        }
        System.out.print(maxVal);
    }
    static void dfs(int x, int y,int cnt,int val)
    {
        if(cnt == 4)
        {
            maxVal = Math.max(maxVal,val);
            return;
        }
        for(int idx = 0; idx < 4; ++idx)
        {
            int mx = x + dx[idx];
            int my = y + dy[idx];

            if(!isValid(mx,my) || isVis[mx][my]) continue;
            isVis[mx][my] = true;
            dfs(mx,my,cnt+1,val+map[mx][my]);
            isVis[mx][my] = false;
        }
    }
    static boolean isValid(int x, int y)
    {
        return x >= 0 && y >= 0 && x < n && y < m;
    }
    static void getElse(int x, int y)
    {
        next : for(int i = 0; i < 4; ++i)
        {
            int res = map[x][y];
            for(int j = 0; j < 3; ++j)
            {
                int mx = x + ex[i][j];
                int my = y + ey[i][j];

                if(!isValid(mx,my)) continue next;
                res += map[mx][my];
            }
            maxVal = Math.max(maxVal,res);
        }
    }
}
