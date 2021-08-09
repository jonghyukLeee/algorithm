package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Ice
{
    int x,y;

    public Ice(int x, int y)
    {
        this.x = x;
        this.y = y;
    }
}
public class Q2573 {
    static int [][] map;
    static boolean [][] isVis;
    static boolean bool = true;
    static int answer = 0;
    static int [] dx = {0,0,-1,1};
    static int [] dy = {-1,1,0,0};
    static Queue<Ice> q;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        q = new LinkedList<>();

        for(int i = 0; i < n; ++i)
        {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; ++j)
            {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while(bool)
        {
            isVis = new boolean[n][m];
            boolean tmp = true;
            loop : for(int i = 1; i < n-1; ++i)
            {
                for(int j = 1; j < m-1; ++j)
                {
                    if(map[i][j] > 0)
                    {
                        q.add(new Ice(i,j));
                        tmp = false;
                        break loop;
                    }
                }
            }
            if(tmp)
            {
                System.out.print("0");
                return;
            }
            year();
            answer++;
            if(check())
            {
                bool = false;
            }
        }
        System.out.print(answer-1);
    }
    static void year()
    {
        while(!q.isEmpty())
        {
            Ice tmpIce = q.poll();
            int curX = tmpIce.x,curY = tmpIce.y;
            isVis[curX][curY] = true;

            for(int idx = 0; idx < 4; ++idx)
            {
                int x = curX + dx[idx];
                int y = curY + dy[idx];

                if(!isValid(x,y) || isVis[x][y]) continue;

                if(map[x][y] == 0)
                {
                    map[curX][curY] = map[curX][curY] > 0 ? map[curX][curY]-1 : 0;
                    continue;
                }
                if(map[x][y] > 0)
                {
                    q.add(new Ice(x,y));
                    isVis[x][y] = true;
                }
            }
        }

    }


    static boolean isValid(int x, int y)
    {
        return x >= 0 && y >= 0 && x < map.length && y < map[0].length;
    }

    static boolean check()
    {
        for(int i = 1; i < map.length-1; ++i)
        {
            for(int j = 1; j < map[0].length-1; ++j)
            {
                if(isVis[i][j]) continue;
                if(map[i][j] > 0) return true;
            }
        }
        return false;
    }
}
