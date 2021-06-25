package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2468 {
    static int [][] map;
    static boolean [][] isVis;
    static int answer = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE,max = Integer.MIN_VALUE,size;
    static int [] dx = {0,0,-1,1};
    static int [] dy = {-1,1,0,0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        size = Integer.parseInt(br.readLine());
        StringTokenizer st;
        map = new int[size][size];

        for(int i = 0; i < size; ++i)
        {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < size; ++j)
            {
                int tmp_num = Integer.parseInt(st.nextToken());
                map[i][j] = tmp_num;
                if(tmp_num < min) min = tmp_num;
                if(tmp_num > max) max = tmp_num;
            }
        }

        int safe_cnt = Integer.MIN_VALUE;
        int tmp_cnt;
        for(int h = min-1; h < max; ++h) // 최솟값 ~ 최댓값-1까지 반복
        {
            tmp_cnt = 0;
            isVis = new boolean[size][size];
            for(int i = 0; i < size; ++i)
            {
                for(int j = 0; j < size; ++j)
                {
                    if(map[i][j] > h && !isVis[i][j])
                    {
                        tmp_cnt++;
                        dfs(i,j,h);
                    }
                }
            }
            safe_cnt = Math.max(tmp_cnt,safe_cnt);
        }
        System.out.print(safe_cnt);
    }
    static void dfs(int i, int j,int h)
    {
        isVis[i][j] = true;
        for(int idx = 0; idx < 4; ++idx)
        {
            int x = i + dx[idx];
            int y = j + dy[idx];
            if(!isValid(x,y)) continue;
            if(isVis[x][y] || map[x][y] <= h) continue;
            dfs(x,y,h);
        }
    }
    static boolean isValid(int x, int y)
    {
        if(x < 0 || y < 0 || x >= map.length || y >= map[0].length) return false;
        return true;
    }
}
