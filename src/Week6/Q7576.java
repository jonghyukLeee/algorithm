package Week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q7576 {
    static int [][] map;
    static boolean [][] isVis;
    static int day;
    static int [] dx = {-1,1,0,0};
    static int [] dy = {0,0,-1,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        Collection<Boolean> c = new ArrayList<>();
        Queue<Point> q = new LinkedList<>();

        st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        isVis = new boolean[n][m];

        for(int i = 0; i < n; ++i)
        {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; ++j)
            {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] > 0)
                {
                    q.add(new Point(i,j));
                    isVis[i][j] = true;
                }
            }
        }

        while(!q.isEmpty())
        {
            Point tmp = q.poll();
            isVis[tmp.x][tmp.y] = true;
            day = map[tmp.x][tmp.y];
            for(int i = 0 ; i < 4; ++i) {
                int mx = tmp.x + dx[i];
                int my = tmp.y + dy[i];
                if (!chkRange(mx, my)) continue;
                if (isVis[mx][my] || map[mx][my] == -1) continue;
                q.add(new Point(mx, my));
                map[mx][my] = day + 1;
                isVis[mx][my] = true;
            }
        }
        loop : for(int i = 0; i < n; ++i)
        {
            for(int j = 0; j < m; ++j)
            {
                if(map[i][j] == 0)
                {
                    System.out.print("-1");
                    break loop;
                }
            }
            if(i == n-1) System.out.print(day-1);
        }
    }
    static boolean chkRange(int x, int y)
    {
        if(x < 0 || y < 0 || x >= map.length || y >= map[0].length) return false;
        return true;
    }
}
class Point
{
    int x,y,cnt;
    public Point(int x, int y)
    {
        this.x = x;
        this.y = y;
    }
}