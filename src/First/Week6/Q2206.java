package First.Week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q2206 {
    static int [][] map;
    static boolean [][][] isVis;
    static int [] dx = {-1,1,0,0};
    static int [] dy = {0,0,-1,1};
    static int res;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        String str;
        res = Integer.MAX_VALUE;

        map = new int[n][m];
        isVis = new boolean[n][m][2];

        for(int i = 0; i < n; ++i)
        {
            str = br.readLine();
            for(int j = 0; j < m; ++j)
            {
                map[i][j] = str.charAt(j)-'0';
            }
        }
        if(n == 1 && m == 1)
        {
            int res = map[0][0] == 0 ? 1 : -1;
            System.out.print(res);
            System.exit(0);
        }

        Queue<Point2> q = new LinkedList<>();
        q.add(new Point2(0,0,1,0));
        isVis[0][0][0] = true;
        isVis[0][0][1] = true;

        while(!q.isEmpty())
        {
            Point2 tmp = q.poll();
            for(int i = 0; i < 4; ++i)
            {
                int mx = tmp.x + dx[i];
                int my = tmp.y + dy[i];
                int cnt = tmp.cnt;
                int isBroken = tmp.br;

                if(!chkRange(mx,my)) continue;
                if(mx == n-1 && my == m-1)
                {
                    res = Math.min(res,cnt+1);
                    continue;
                }
                if(isVis[mx][my][isBroken]) continue;
                if(map[mx][my] == 1)
                {
                   if(isBroken == 0)
                   {
                       isVis[mx][my][1] = true;
                       q.add(new Point2(mx,my,cnt+1,1));
                       continue;
                   }
                   else continue;
                }
                isVis[mx][my][isBroken] = true;
                q.add(new Point2(mx,my,cnt+1,isBroken));
            }
        } // end of loop
        if(res == Integer.MAX_VALUE) System.out.print("-1");
        else System.out.print(res);
    }
    static boolean chkRange(int x, int y)
    {
        if(x < 0 || y < 0 || x >= map.length || y >= map[0].length) return false;
        return true;
    }
}
class Point2
{
    int x,y,cnt,br;
    public Point2(int x, int y,int cnt, int br)
    {
        this.x = x;
        this.y = y;
        this.cnt = cnt;
        this.br = br;
    }
}
