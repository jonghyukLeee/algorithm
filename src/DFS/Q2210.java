package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q2210 {
    static String [][] map;
    static int [] dx = {-1,1,0,0};
    static int [] dy = {0,0,-1,1};
    static Set<String> hs;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        map = new String[5][5];

        for(int i = 0; i < 5; ++i)
        {
            st = new StringTokenizer(br.readLine());
            for(int j =0; j < 5; ++j)
            {
                map[i][j] = st.nextToken();
            }
        }

        hs = new HashSet<>();
        for(int i = 0; i < 5; ++i)
        {
            for(int j = 0; j < 5; ++j)
            {
                dfs(i,j,map[i][j],1);
            }
        }
        System.out.println(hs.size());
    }
    static void dfs(int x, int y, String str,int len)
    {
        if(len == 6)
        {
            hs.add(str);
            return;
        }
        for(int idx = 0; idx < 4; ++idx)
        {
            int mx = x + dx[idx];
            int my = y + dy[idx];

            if(!isValid(mx,my)) continue;
            dfs(mx,my,str+map[mx][my],len+1);
        }
    }
    static boolean isValid(int x, int y)
    {
        return x >= 0 && y >= 0 && x < 5 && y < 5;
    }
}
