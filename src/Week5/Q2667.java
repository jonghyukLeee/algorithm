package Week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Q2667 {

    static int [][] map;
    static boolean [][] isVis;
    static int [] dx = {-1,1,0,0};
    static int [] dy = {0,0,-1,1};
    static int cnt;
    static List<Integer> al;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        int n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        isVis = new boolean[n][n];
        al = new ArrayList<>();
        cnt = 1;

        for(int i = 0; i < n; ++i)
        {
            str = br.readLine();
            for(int j = 0; j < n; ++j)
            {
                map[i][j] = str.charAt(j)-'0';
            }
        }

        for(int i = 0; i < n; ++i)
        {
            for(int j = 0; j < n; ++j)
            {
                if(map[i][j] == 0 || isVis[i][j]) continue;
                isVis[i][j] = true;
                al.add(dfs(i,j));
                cnt = 1;
            }
        }
        Collections.sort(al);
        System.out.printf("%d\n",al.size());
        for(Integer i : al)
        {
            System.out.printf("%d\n",i);
        }
    }
    static int dfs(int x, int y)
    {
        for(int i = 0; i < 4; ++i)
        {
            int mv_x = x+dx[i];
            int mv_y = y+dy[i];
            if(!chkRange(mv_x,mv_y)) continue;
            if(map[mv_x][mv_y] == 0 || isVis[mv_x][mv_y]) continue;
            cnt++;
            isVis[mv_x][mv_y] = true;
            dfs(mv_x,mv_y);
        }
        return cnt;
    }
    static boolean chkRange(int x, int y)
    {
        if(x < 0 || y < 0 || x >= map.length || y >= map[0].length) return false;
        return true;
    }
}
