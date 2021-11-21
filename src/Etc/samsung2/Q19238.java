package Etc.samsung2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Loc
{
    int x,y;
    int dist;

    public Loc(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    public Loc(int x, int y, int dist)
    {
        this.x = x;
        this.y = y;
        this.dist = dist;
    }
}
public class Q19238 {
    static int N,M,fuel;
    static Loc taxi;
    static boolean [][] visited;
    static int [][] map;
    static Loc [][] guest;
    static int end_cnt;
    static int [] dx = {-1,0,0,1};
    static int [] dy = {0,-1,1,0};
    static PriorityQueue<Loc> pq;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        fuel = Integer.parseInt(st.nextToken());

        map = new int[N+1][N+1];
        guest = new Loc[N+1][N+1];

        for(int i = 1; i <= N; ++i)
        {
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= N; ++j)
            {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //택시 시작위치
        st = new StringTokenizer(br.readLine());
        taxi = new Loc(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));

        //손님 위치
        for(int i = 0; i < M; ++i)
        {
            st = new StringTokenizer(br.readLine());
            int start_x = Integer.parseInt(st.nextToken());
            int start_y = Integer.parseInt(st.nextToken());
            Loc start = new Loc(start_x,start_y);
            Loc end = new Loc(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));

            guest[start_x][start_y] = getDistance(start,end);
            if(guest[start_x][start_y].dist == 0) // 애초에 도착지까지 못갈경우
            {
                System.out.print("-1");
                return;
            }
        }
        pq = new PriorityQueue<>(new Comparator<Loc>() {
            @Override
            public int compare(Loc o1, Loc o2) {
                if(o1.dist == o2.dist)
                {
                    if(o1.x == o2.x) return o1.y - o2.y;
                    return o1.x - o2.x;
                }
                return o1.dist - o2.dist;
            }
        });
        while(true)
        {
            if(end_cnt == M) break;
            if(!findGuest()) break;
        }

        if(end_cnt != M) fuel = -1;
        System.out.print(fuel);
    }
    static Loc getDistance(Loc start, Loc end)
    {
        Queue<Loc> q = new LinkedList<>();
        visited = new boolean[N+1][N+1];
        visited[start.x][start.y] = true;
        q.add(new Loc(start.x,start.y,0));

        while(!q.isEmpty())
        {
            Loc cur = q.poll();

            if(cur.x == end.x && cur.y == end.y)
            {
                return cur;
            }
            for(int idx = 0; idx < 4; ++idx)
            {
                int mx = cur.x + dx[idx];
                int my = cur.y + dy[idx];

                if(!isValid(mx,my) || visited[mx][my] || map[mx][my] > 0) continue;
                visited[mx][my] = true;
                q.add(new Loc(mx,my,cur.dist+1));
            }
        }
        return new Loc(0,0);
    }
    static boolean findGuest()
    {
        Queue<Loc> q = new LinkedList<>();
        visited = new boolean[N+1][N+1];
        visited[taxi.x][taxi.y] = true;
        q.add(new Loc(taxi.x,taxi.y,0));

        int tmp_dist = Integer.MAX_VALUE;
        while(!q.isEmpty())
        {
            Loc cur = q.poll();

            if(cur.dist > tmp_dist) break;
            if(guest[cur.x][cur.y] != null)
            {
                tmp_dist = cur.dist;
                pq.add(new Loc(cur.x,cur.y,cur.dist));
                continue;
            }
            for(int idx = 0; idx < 4; ++idx)
            {
                int mx = cur.x + dx[idx];
                int my = cur.y + dy[idx];

                if(!isValid(mx,my) || visited[mx][my] || map[mx][my] > 0) continue;
                visited[mx][my] = true;
                q.add(new Loc(mx,my,cur.dist+1));
            }
        }
        if(!pq.isEmpty())
        {
            Loc start = pq.poll();
            Loc end = guest[start.x][start.y];

            taxi.x = end.x;
            taxi.y = end.y;

            fuel -= (start.dist + end.dist); // taxi -> guest -> dest

            if(fuel < 0) return false;

            fuel += (end.dist * 2);
            end_cnt++;
            guest[start.x][start.y] = null;
            pq.clear();
            return true;
        }
        return false;
    }
    static boolean isValid(int x, int y)
    {
        return x > 0 && y > 0 && x <= N && y <= N;
    }
}
