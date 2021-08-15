package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Land
{
    int x,y,time;

    public Land(int x, int y, int time)
    {
        this.x = x;
        this.y = y;
        this.time = time;
    }
}
public class Q2589 {
    static char [][] map;
    static boolean [][] isVis;
    static int maxVal = Integer.MIN_VALUE;
    static int [] dx = {0,0,-1,1};
    static int [] dy = {-1,1,0,0};
    static Queue<Land> q;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        q = new LinkedList<>();
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        map = new char[n][m];

        for(int i = 0; i < n; ++i)
        {
            String tmpStr = br.readLine();
            for(int j = 0; j < m; ++j)
            {
                map[i][j] = tmpStr.charAt(j);
            }
        }

        for(int i = 0; i < n; ++i)
        {
            for(int j = 0; j < m; ++j)
            {
                if(map[i][j] == 'L')
                {
                    q.add(new Land(i,j,0));
                    isVis = new boolean[n][m];
                    isVis[i][j] = true;
                    bfs();
                }
            }
        }
        System.out.print(maxVal);
    }
    static void bfs()
    {
        while(!q.isEmpty())
        {
            Land tmp = q.poll();

            for(int i = 0; i < 4; ++i)
            {
                int x = tmp.x + dx[i];
                int y = tmp.y + dy[i];

                if(!isValid(x,y) || isVis[x][y] || map[x][y] == 'W') continue;
                isVis[x][y] = true;
                q.add(new Land(x,y,tmp.time+1));
            }
            if(q.isEmpty())
            {
                maxVal = Math.max(maxVal,tmp.time);
            }
        }

    }
    static boolean isValid(int x, int y)
    {
        return x >= 0 && y >= 0 && x < map.length && y < map[0].length;
    }

}
