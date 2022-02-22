package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Point
{
    int x,y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

}
public class Q2636 {
    static int N,M;
    static int [][] map;
    static boolean [][] visited;
    static Queue<Point> edges;
    static List<Point> next;
    static int [] dx = {-1,1,0,0};
    static int [] dy = {0,0,-1,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for(int i = 0; i < N; ++i)
        {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; ++j)
            {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        edges = new LinkedList<>();
        visited = new boolean[N][M];
        next = new ArrayList<>();
        next.add(new Point(0,0));
        visited[0][0] = true;

        int hour = -1;
        int area = 0;
        while(!next.isEmpty())
        {
            area = next.size();
            edges.addAll(next);
            next = new ArrayList<>();
            findEdge();
            hour++;
        }
        if(hour == 0) area = 0;
        System.out.printf("%d\n%d",hour,area);
    }
    static void findEdge()
    {
        while(!edges.isEmpty())
        {
            Point cur = edges.poll();

            for(int idx = 0; idx < 4; ++idx)
            {
                int mx = cur.x + dx[idx];
                int my = cur.y + dy[idx];

                if(!isValid(mx,my) || visited[mx][my]) continue;
                visited[mx][my] = true;
                // 치즈의 가장자리면 next , 공기중이면 현재 queue에 add;
                if(map[mx][my] > 0) next.add(new Point(mx,my));
                else edges.add(new Point(mx,my));
            }
        }
    }
    static boolean isValid(int x, int y)
    {
        return x >= 0 && y >= 0 && x < N && y < M;
    }
}
