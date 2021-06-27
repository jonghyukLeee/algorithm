package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1987 {
    static char [][] map;
    static boolean [] alpha;
    static boolean [][] isVis;
    static int [] dx = {0,0,-1,1};
    static int [] dy = {1,-1,0,0};
    static int max_val;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String tmp_str;
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        map = new char[r][c];
        isVis = new boolean[r][c];
        alpha = new boolean[26];
        max_val = Integer.MIN_VALUE;

        for(int i = 0; i < r; ++i)
        {
            tmp_str = br.readLine();
            for(int j = 0; j < c; ++j)
            {
                map[i][j] = tmp_str.charAt(j);
            }
        }
        dfs(0,0,1);
        System.out.print(max_val);
    }
    static void dfs(int i, int j,int cnt)
    {
        if(max_val < cnt) max_val = cnt;
        isVis[i][j] = true;
        alpha[map[i][j]-65] = true;
        for(int idx = 0; idx < 4; ++idx)
        {
            int x = i + dx[idx];
            int y = j + dy[idx];
            if(!isValid(x,y)) continue;
            if(isVis[x][y] || alpha[map[x][y]-65]) continue;
            dfs(x,y,cnt+1);
            isVis[x][y] = false;
            alpha[map[x][y]-65] = false;
        }
    }
    static boolean isValid(int x, int y)
    {
        if(x < 0 || y < 0 || x >= map.length || y >= map[0].length) return false;
        return true;
    }
}
