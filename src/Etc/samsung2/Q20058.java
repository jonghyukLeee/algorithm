package Etc.samsung2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Point2
{
    int x,y;

    public Point2(int x, int y)
    {
        this.x = x;
        this.y = y;
    }
}
public class Q20058 {
    static int N,Q;
    static int area;
    static int total;
    static int sum = Integer.MIN_VALUE;
    static boolean [][] visited;
    static int [][] map;
    static int [][] tmp_map;
    static int [] dx = {-1,1,0,0};
    static int [] dy = {0,0,-1,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = (int)Math.pow(2,Integer.parseInt(st.nextToken()));
        Q = Integer.parseInt(st.nextToken());

        map = new int[N][N];

        for(int i = 0; i < N; ++i)
        {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; ++j)
            {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < Q; ++i)
        {
            cast(Integer.parseInt(st.nextToken()));
            melt();
        }
        check();
        System.out.printf("%d\n%d",sum,area);
    }
    static void cast(int n)
    {
        tmp_map = new int[N][N];
        for(int i = 0; i < N; ++i) System.arraycopy(map[i],0,tmp_map[i],0,N);

        int l = (int)Math.pow(2,n);
        for(int i = 0; i < N; i+=l)
        {
            for(int j = 0; j < N; j+=l)
            {
                rotate(i,j,l);
            }
        }
    }
    static void rotate(int x, int y, int size)
    {
        for(int i = 0; i < size; ++i)
        {
            for(int j = 0; j < size; ++j)
            {
                map[x+j][y+size-i-1] = tmp_map[x+i][y+j];
            }
        }
    }
    static void melt()
    {
        for(int i = 0; i < N; ++i)
        {
            for(int j = 0; j < N; ++j)
            {
                if(map[i][j] < 1) continue;
                int cnt = 0;
                for(int idx = 0; idx < 4; ++idx)
                {
                    int mx = i + dx[idx];
                    int my = j + dy[idx];

                    if(isValid(mx,my))
                    {
                        if(map[mx][my] > 0) cnt++;
                    }
                }
                if(cnt < 3) map[i][j]--;
            }
        }
    }
    static void check()
    {
        visited = new boolean[N][N];
        Queue<Point2> q = new LinkedList<>();
        for(int i = 0; i < N; ++i)
        {
            for(int j = 0; j < N; ++j)
            {
                if(map[i][j] < 1) continue;
                total += map[i][j];
                if(!visited[i][j])
                {
                    visited[i][j] = true;
                    q.add(new Point2(i,j));
                    int tmp_sum = 0;
                    int cnt = 0;
                    while(!q.isEmpty())
                    {
                        Point2 cur = q.poll();
                        tmp_sum += map[cur.x][cur.y];
                        cnt++;

                        for(int idx = 0; idx < 4; ++idx)
                        {
                            int mx = cur.x + dx[idx];
                            int my = cur.y + dy[idx];

                            if(!isValid(mx,my) || visited[mx][my] || map[mx][my] < 1) continue;
                            visited[mx][my] = true;
                            q.add(new Point2(mx,my));
                        }
                    }
                    if(tmp_sum > sum)
                    {
                        sum = tmp_sum;
                        area = cnt;
                    }
                }
            }
        }
    }
    static boolean isValid(int x, int y)
    {
        return x >= 0 && y >= 0 && x < N && y < N;
    }
}
