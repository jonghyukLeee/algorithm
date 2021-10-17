package Etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Dust
{
    int val,x,y;

    public Dust(int val, int x, int y)
    {
        this.val = val;
        this.x = x;
        this.y = y;
    }
}

public class Q17144 {
    static int R,C,T,answer;
    static int air_x,air_y;
    static int [][] map;
    static List<Dust> dust;
    static int [] dx = {-1,1,0,0};
    static int [] dy = {0,0,-1,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        dust = new ArrayList<>();
        map = new int[R][C];

        for(int i = 0; i < R; ++i)
        {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < C; ++j)
            {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] > 0)
                {
                    dust.add(new Dust(map[i][j],i,j));
                    map[i][j] = 0;
                }
                else if(map[i][j] < 0)
                {
                    air_x = i;
                    air_y = j;
                }
            }
        }

        while(T-- > 0)
        {
            //확산
            for(Dust d : dust)
            {
                int spread_val = d.val / 5;
                int spread_cnt = 0;
                for(int dir = 0; dir < 4; ++dir)
                {
                    int mx = d.x + dx[dir];
                    int my = d.y + dy[dir];

                    if(!isValid(mx,my) || map[mx][my] < 0) continue;
                    map[mx][my] += spread_val;
                    spread_cnt++;
                }
                map[d.x][d.y] += d.val - (spread_val * spread_cnt);
            }

            //공기청정기
            clean(true);
            clean(false);
        }
    }
    static void clean(boolean flag)
    {
        if(flag) //윗
        {

        }
    }
    static boolean isValid(int x, int y)
    {
        return x >= 0 && y >= 0 && x < R && y < C;
    }
}
