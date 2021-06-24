package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q4963 {
    static int [][] map;
    static boolean [][] isVis;
    static int answer;
    static StringBuilder sb;
    static int [] dx = {0,0,1,-1,1,1,-1,-1};
    static int [] dy = {1,-1,0,0,-1,1,1,-1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();
        int w,h;

        while(true)
        {
            st= new StringTokenizer(br.readLine());
            h = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());

            if(w == 0 && h == 0) break;

            map = new int[w][h];
            isVis = new boolean[w][h];
            answer = 0;

            for(int i = 0; i < w; ++i)
            {
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < h; ++j)
                {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for(int i = 0; i < w; ++i)
            {
                for(int j = 0; j < h; ++j)
                {
                    if(map[i][j] == 1 && !isVis[i][j])
                    {
                        dfs(i,j);
                        answer++;
                    }
                }
            }
            sb.append(answer).append("\n");
        }

        System.out.print(sb.toString());


    }
    static void dfs(int i, int j)
    {
        isVis[i][j] = true;

        for(int idx = 0; idx < 8; ++idx)
        {
            int x = i + dx[idx];
            int y = j + dy[idx];

            if(!isValid(x,y)) continue;
            if(isVis[x][y] || map[x][y] == 0) continue;

            isVis[x][y] = true;
            dfs(x,y);

        }
    }
    static boolean isValid(int x, int y)
    {
        if(x < 0 || y < 0 || x >= map.length || y >= map[0].length) return false;
        return true;
    }
}
