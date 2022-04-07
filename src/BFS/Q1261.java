package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Location
{
    int x,y,cnt;

    public Location(int x, int y, int cnt) {
        this.x = x;
        this.y = y;
        this.cnt = cnt;
    }
}
public class Q1261 {
    static boolean [][] map;
    static int [] dx = {-1,1,0,0};
    static int [] dy = {0,0,-1,1};
    static boolean [][] visited;
    static int N,M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new boolean[M][N];
        visited = new boolean[M][N];

        for(int i = 0; i < M; i++)
        {
            String input = br.readLine();
            for(int j = 0; j < N; j++)
            {
                char next = input.charAt(j);
                if(next == '1') map[i][j] = true;
            }
        }

        PriorityQueue<Location> q = new PriorityQueue<>(new Comparator<Location>() {
            @Override
            public int compare(Location o1, Location o2) {
                return o1.cnt - o2.cnt;
            }
        });
        q.add(new Location(0,0,0));
        visited[0][0] = true;

        int answer = Integer.MAX_VALUE;
        while(!q.isEmpty())
        {
            Location cur = q.poll();

            if(cur.x == M-1 && cur.y == N-1)
            {
                answer = cur.cnt;
                break;
            }
            for(int idx = 0; idx < 4; idx++)
            {
                int mx = cur.x + dx[idx];
                int my = cur.y + dy[idx];

                if(!isValid(mx,my) || visited[mx][my]) continue;
                visited[mx][my] = true;
                int tmpCnt = cur.cnt;
                if(map[mx][my]) tmpCnt++;
                q.add(new Location(mx,my,tmpCnt));
            }
        }
        System.out.print(answer == Integer.MAX_VALUE ? 0 : answer);
    }
    static boolean isValid(int x, int y)
    {
        return x >= 0 && y >= 0 && x < M && y < N;
    }
}
