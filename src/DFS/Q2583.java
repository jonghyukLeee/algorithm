package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Q2583 {
    static boolean [][] map;
    static boolean [][] isVis;
    static ArrayList<Integer> al;
    static int [] dx = {0,0,-1,1};
    static int [] dy = {-1,1,0,0};
    static int area_max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        al = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        map = new boolean[m][n];
        isVis = new boolean[m][n];

        int t = Integer.parseInt(st.nextToken());

        for(int i = 0; i < t; ++i)
        {
            st = new StringTokenizer(br.readLine());
            drawSquare(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
        }
        for(int i = 0; i < map.length; ++i)
        {
            for(int j = 0; j < map[0].length; ++j)
            {
                if(isVis[i][j]) continue;
                area_max = 0;
                dfs(i,j);
                al.add(area_max);
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(al.size()).append("\n");
        Collections.sort(al);
        for(Integer i : al) sb.append(i).append(" ");

        System.out.print(sb.toString());
    }
    static void drawSquare(int x1 ,int x2, int y1, int y2) // 1 1 2 5
    {
        for(int i = x2; i < y2; ++i)
        {
            for(int j = x1; j < y1; ++j)
            {
                map[i][j] = true;
                isVis[i][j] = true;
            }
        }
    }
    static void dfs(int i, int j)
    {
        area_max++;
        isVis[i][j] = true;
        for(int idx = 0; idx < 4; ++idx)
        {
            int x = i + dx[idx];
            int y = j + dy[idx];
            if(!isValid(x,y)) continue;
            if(isVis[x][y] || map[i][j]) continue;
            dfs(x,y);
        }
    }
    static boolean isValid(int x, int y)
    {
        return x >= 0 && y >= 0 && x < map.length && y < map[0].length;
    }
}
