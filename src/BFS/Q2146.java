package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Island
{
    int x,y;
    int len;

    public Island(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public Island(int x, int y, int len) {
        this.x = x;
        this.y = y;
        this.len = len;
    }
}
public class Q2146 {
    static int N;
    static int [][] map;
    static boolean [][] visited;
    static int groupNum;
    static int [] dx = {-1,1,0,0};
    static int [] dy = {0,0,-1,1};
    static int minVal = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new int[N][N];

        StringTokenizer st;
        for(int i = 0; i < N; i++)
        {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++)
            {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visited = new boolean[N][N];

        //섬 구분
        for(int i = 0; i < N; i++)
        {
            for(int j = 0; j < N; j++)
            {
                if(map[i][j] > 0 && !visited[i][j])
                {
                    visited[i][j] = true;
                    map[i][j] += groupNum;
                    setIsland(i,j);
                    groupNum++;
                }
            }
        }

        visited = new boolean[N][N];
        //다리 연결
        for(int i = 0; i < N; i++)
        {
            for(int j = 0; j < N; j++)
            {
                if(map[i][j] > 0 && !visited[i][j])
                {
                    visited[i][j] = true;
                    setBridge(i,j,map[i][j]);
                    visited = new boolean[N][N];
                }
            }
        }
        System.out.print(minVal == Integer.MAX_VALUE ? "0" : minVal);
    }
    static void setBridge(int x, int y,int groupNum)
    {
        Queue<Island> q = new LinkedList<>();
        q.add(new Island(x,y,0));

        while(!q.isEmpty())
        {
            Island cur = q.poll();

            if(cur.len >= minVal) continue;

            for(int idx = 0; idx < 4; idx++)
            {
                int mx = cur.x + dx[idx];
                int my = cur.y + dy[idx];

                if(!isValid(mx,my) || visited[mx][my] || map[mx][my] == groupNum) continue;
                //바다
                if(map[mx][my] == 0)
                {
                    visited[mx][my] = true;
                    q.add(new Island(mx,my,cur.len+1));
                }
                //다른섬 도착
                else minVal = Math.min(minVal,cur.len);

            }
        }
    }
    static void setIsland(int x, int y)
    {
        Queue<Island> q = new LinkedList<>();
        q.add(new Island(x,y));

        while(!q.isEmpty())
        {
            Island cur = q.poll();

            for(int idx = 0; idx < 4; idx++)
            {
                int mx = cur.x + dx[idx];
                int my = cur.y + dy[idx];

                if(!isValid(mx,my) || visited[mx][my] || map[mx][my] == 0) continue;
                visited[mx][my] = true;
                map[mx][my] += groupNum;
                q.add(new Island(mx,my));
            }
        }
    }
    static boolean isValid(int x, int y)
    {
        return x >= 0 && y >= 0 && x < N && y < N;
    }
}
