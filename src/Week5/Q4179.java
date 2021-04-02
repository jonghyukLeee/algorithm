package Week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q4179 {
    static char [][] map;
    static int [][] fmap;
    static int [] dx = {-1,1,0,0};
    static int [] dy = {0,0,-1,1};
    static Point2 fire, jh;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        Queue<Point2> q = new LinkedList<>();

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        map = new char[n][m];
        fmap = new int[n][m];
        for(int i = 0; i < n; ++i)
        {
            String str = br.readLine();
            for(int j = 0; j < m; ++j)
            {
                char tmp = str.charAt(j);
                map[i][j] = tmp;
                if(tmp == 'F')
                {
                    fire = new Point2(i,j,0);
                }
                if(tmp == 'J')
                {
                    jh = new Point2(i,j,0);
                }
            }
        } // end of loop

        // 불 bfs
        fmap[fire.x][fire.y]++;
        q.add(fire);
        while(!q.isEmpty())
        {
            Point2 tmp = q.poll();
            int time = ++tmp.t;
            for(int i = 0; i < 4; ++i)
            {
                int mv_x = tmp.x + dx[i];
                int mv_y = tmp.y + dy[i];
                if(!checkRange(mv_x,mv_y)) continue;
                if(fmap[mv_x][mv_y] > 0) continue;
                if(map[mv_x][mv_y] == '.')
                {
                    q.add(new Point2(mv_x,mv_y,time));
                    fmap[mv_x][mv_y] = time;
                }
            }
        }
        //지훈 bfs
        q.add(jh);
        while(!q.isEmpty())
        {
            Point2 tmp = q.poll();
            int time = ++tmp.t;
            for(int i = 0; i < 4; ++i)
            {
                int mv_x = tmp.x + dx[i];
                int mv_y = tmp.y + dy[i];
                if(!checkRange(mv_x,mv_y))
                {
                    System.out.print(time);
                    System.exit(0);
                }
                if(map[mv_x][mv_y] == '#' || map[mv_x][mv_y] == 'J' || map[mv_x][mv_y] == 'F') continue;
                if(map[mv_x][mv_y] == '.' && time < fmap[mv_x][mv_y])
                {
                    q.add(new Point2(mv_x,mv_y,time));
                }
            }
        }
        System.out.print("IMPOSSIBLE");
    }
    static public boolean checkRange(int x, int y)
    {
        if(x < 0 || y < 0 || x >= map.length || y >= map[0].length) return false;
        return true;
    }
}

class Point2
{
    int x,y,t;
    public Point2(int x, int y,int t)
    {
        this.x = x;
        this.y = y;
        this.t = t;
    }
}