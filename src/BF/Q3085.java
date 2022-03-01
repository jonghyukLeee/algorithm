package BF;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class Point
{
    int x,y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
public class Q3085 {
    static int N;
    static char [][] map;
    static int [] dx = {0,1};
    static int [] dy = {1,0};
    static int max = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new char[N][N];

        for(int i = 0; i < N; ++i)
        {
            String tmp = br.readLine();
            map[i] = tmp.toCharArray();
        }

        for(int i = 0; i < N; ++i)
        {
            for(int j = 0; j < N; ++j) find(i,j,map[i][j]);
        }
        System.out.println(max);
    }
    static void find(int x, int y, char color)
    {
        for(int idx = 0; idx < 2; ++idx)
        {
            int mx = x + dx[idx];
            int my = y + dy[idx];

            if(!isValid(mx,my)) continue;
            if(map[mx][my] != color)
            {
                char nextColor = map[mx][my];
                map[x][y] = nextColor;
                map[mx][my] = color;
                check();
                //행,열 체크후 배열 원위치
                map[x][y] = color;
                map[mx][my] = nextColor;
            }
        }
    }

    static void check()
    {
        for(int i = 0; i < N; ++i)
        {
            //행
            eat(i,0,0);
            //열
            eat(0,i,1);
        }

    }
    static void eat(int x, int y,int dir)
    {
        int cnt = 1;
        char color = map[x][y];

        Queue<Point> q = new LinkedList<>();
        q.add(new Point(x,y));
        while(!q.isEmpty())
        {
            Point cur = q.poll();

            int mx = cur.x + dx[dir];
            int my = cur.y + dy[dir];

            if(!isValid(mx,my)) return;

            // 다음칸과 색상이 다를 시, 현재 탐색중이던 색상과 카운트값을 초기화.
            if(map[mx][my] != color)
            {
                color = map[mx][my];
                cnt = 1;

                // 만약 잔여 칸수(afterLen)가 현재 max값보다 작다면 더이상 탐색할 필요가 없으므로 이번 탐색을 종료.
                int afterLen = N - (x+y+1);
                if(afterLen <= max) return;
            }
            else
            {
                cnt++;
                max = Math.max(max,cnt);
            }
            q.add(new Point(mx,my));

        }
    }
    static boolean isValid(int x, int y)
    {
        return x >= 0 && y >= 0 && x < N && y < N;
    }

}
