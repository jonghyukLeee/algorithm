package Etc.samsung;

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
    static int air_x;
    static int [][] map;
    static List<Dust> dust;
    static int [] dx = {-1,1,0,0};
    static int [] dy = {0,0,-1,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        dust = new ArrayList<>();
        map = new int[R][C];

        for(int i = 0; i < R; ++i)
        {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < C; ++j)
            {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] < 0) air_x = i;
            }
        }
        while(T-- > 0)
        {
            getDust();
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
            dust.clear();
            //공기청정기
            clean(true);
            clean(false);
        }
        for(int [] i : map)
        {
            for(int j : i)
            {
                if(j > 0) answer+= j;
            }
        }
        System.out.print(answer);
    }
    static void clean(boolean flag)
    {
        if(flag) //위
        {
            map[air_x-2][0] = 0;
            for(int i = air_x-3; i >= 0; --i)
            {
                if(map[i][0] > 0)
                {
                    map[i+1][0] = map[i][0];
                    map[i][0] = 0;
                }
            }
            for(int i = 1; i < C; ++i)
            {
                if(map[0][i] > 0)
                {
                    map[0][i-1] = map[0][i];
                    map[0][i] = 0;
                }
            }
            for(int i = 1; i < air_x; ++i)
            {
                if(map[i][C-1] > 0)
                {
                    map[i-1][C-1] = map[i][C-1];
                    map[i][C-1] = 0;
                }
            }
            for(int i = C-2; i > 0; --i)
            {
                if(map[air_x-1][i] > 0)
                {
                    map[air_x-1][i+1] = map[air_x-1][i];
                    map[air_x-1][i] = 0;
                }
            }
        }
        else //아래
        {
            map[air_x+1][0] = 0;
            for(int i = air_x+2; i < R; ++i)
            {
                if(map[i][0] > 0)
                {
                    map[i-1][0] = map[i][0];
                    map[i][0] = 0;
                }
            }
            for(int i = 1; i < C; ++i)
            {
                if(map[R-1][i] > 0)
                {
                    map[R-1][i-1] = map[R-1][i];
                    map[R-1][i] = 0;
                }
            }
            for(int i = R-2; i >= air_x; --i)
            {
                if(map[i][C-1] > 0)
                {
                    map[i+1][C-1] = map[i][C-1];
                    map[i][C-1] = 0;
                }
            }
            for(int i = C-2; i > 0; --i)
            {
                if(map[air_x][i] > 0)
                {
                    map[air_x][i+1] = map[air_x][i];
                    map[air_x][i] = 0;
                }
            }
        }
    }
    static void getDust()
    {
        for(int i = 0; i < R; ++i)
        {
            for(int j = 0; j < C; ++j)
            {
                if(map[i][j] >= 5)
                {
                    dust.add(new Dust(map[i][j],i,j));
                    map[i][j] = 0;
                }
            }
        }
    }
    static boolean isValid(int x, int y)
    {
        return x >= 0 && y >= 0 && x < R && y < C;
    }
}
