package First.Week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1018 {
    static boolean [][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        map = new boolean[n][m];

        for(int i = 0; i < n; ++i)
        {
            String str = br.readLine();
            for(int j = 0; j < m; ++j)
            {
                char tmp = str.charAt(j);
                if(tmp == 'W') map[i][j] = true;
                else map[i][j] = false;
            }
        }

        int x = n - 7, y = m - 7,res = Integer.MAX_VALUE;

        for(int i = 0; i < x; ++i)
        {
            for(int j = 0; j < y; ++j)
            {
                int tmp = func(i,j);
                res = Math.min(res,tmp);
            }
        }
        System.out.print(res);
    }
    static int func(int x, int y)
    {
        int endX = x + 8,endY = y + 8,cnt = 0;
        boolean bool = map[x][y];
        for(int i = x; i < endX; ++i)
        {
            for(int j = y; j < endY; ++j)
            {
                if(map[i][j] != bool)
                {
                    cnt++;
                }
                bool = !bool;
            }
            bool = !bool;
        }
        cnt = Math.min(cnt,64-cnt);
        return cnt;
    }
}
