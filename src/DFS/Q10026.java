package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q10026 {
    static char [][] map;
    static boolean [][] isVis;
    static int [] dx = {0,0,-1,1};
    static int [] dy = {1,-1,0,0};
    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        map = new char[n][n];
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; ++i)
        {
            String tmp = br.readLine();
            for(int j = 0; j < n; ++j)
            {
                map[i][j] = tmp.charAt(j);
            }
        }

        for(int t = 0; t < 2; ++t)
        {
            isVis = new boolean[n][n];
            cnt = 0;
            for(int i = 0; i < n; ++i)
            {
                for(int j = 0; j < n; ++j)
                {
                    if(isVis[i][j]) continue;
                    cnt++;
                    dfs(i,j,map[i][j],t);
                }
            }
            sb.append(cnt).append(" ");
        }
        System.out.print(sb.toString());
    }
    static void dfs(int i, int j,char color,int isBlindness) // t = 0 -> 색맹x
    {
        isVis[i][j] = true;
        for(int idx = 0; idx < 4; ++idx)
        {
            int x = i + dx[idx];
            int y = j + dy[idx];
            if(!isValid(x,y) || isVis[x][y] || !checkColor(isBlindness,x,y,color)) continue;
            dfs(x,y,color,isBlindness);
        }
    }
    static boolean isValid(int x, int y)
    {
        return x >= 0 && y >= 0 && x < map.length && y < map[0].length;
    }
    static boolean checkColor(int isBlindness, int i, int j, char color)
    {
        if(isBlindness == 1)
        {
            if(color == 'R' || color == 'G')
            {
                return map[i][j] == 'R' || map[i][j] == 'G';
            }
        }
        return map[i][j] == color;
    }
}
