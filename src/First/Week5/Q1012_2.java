package First.Week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1012_2 {
    static int [][] map;
    static boolean [][] isVis;
    static int [] dx = {-1,1,0,0};
    static int [] dy = {0,0,-1,1};
    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        while(t-- > 0)
        {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            map = new int[y][x];
            isVis = new boolean[y][x];
            cnt = 0;
            while(k-- > 0)
            {
                st = new StringTokenizer(br.readLine());
                x = Integer.parseInt(st.nextToken());
                y = Integer.parseInt(st.nextToken());
                map[y][x] = 1;
            }
            for(int i = 0; i < map.length; ++i)
            {
                for(int j = 0; j < map[0].length; ++j)
                {
                    if(map[i][j] == 0 || isVis[i][j]) continue;
                    isVis[i][j] = true;
                    dfs(i,j);
                    cnt++;
                }
            }
            sb.append(cnt).append("\n");
        } // end of loop
        System.out.print(sb.toString());
        br.close();
    }
    static void dfs(int x, int y)
    {
        for(int i = 0; i < 4; ++i)
        {
            int mv_x = x + dx[i];
            int mv_y = y + dy[i];
            if(!chkRange(mv_x,mv_y)) continue;
            if(map[mv_x][mv_y] == 0 || isVis[mv_x][mv_y]) continue;
            isVis[mv_x][mv_y] = true;
            dfs(mv_x,mv_y);
        }
    }
    static boolean chkRange(int x, int y)
    {
        if(x < 0 || y < 0 || x >= map.length || y >= map[0].length) return false;
        return true;
    }
}
