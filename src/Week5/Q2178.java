package Week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q2178 {
    static int [][] map;
    static boolean [][] isVis;
    static int [] dx = {0,1,0,-1};
    static int [] dy = {1,0,-1,0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        int res = Integer.MAX_VALUE;
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        isVis = new boolean[n][m];

        for(int i = 0; i < n; ++i)
        {
            str = br.readLine();
            for(int j = 0; j < m; ++j)
            {
                map[i][j] = str.charAt(j)-'0';
            }
        }

        Queue<Point3> q = new LinkedList<>();
        q.add(new Point3(0,0,1));
        while(!q.isEmpty())
        {
            Point3 tmp = q.poll();
            for(int i = 0; i < 4; ++i)
            {
                int mx = tmp.x + dx[i];
                int my = tmp.y + dy[i];
                int tmpCnt = tmp.cnt;
                if(!chkRange(mx,my)) continue;
                if(mx == map.length-1 && my == map[0].length-1)
                {
                    res = Math.min(res,++tmpCnt);
                }
                if(isVis[mx][my] || map[mx][my] == 0) continue;
                q.add(new Point3(mx,my,++tmpCnt));
                isVis[mx][my] = true;
            }
        }
        System.out.print(res);
    }
    static boolean chkRange(int x, int y)
    {
        if(x < 0 || y < 0 || x >= map.length || y >= map[0].length) return false;
        return true;
    }
}
class Point3
{
    int x,y,cnt;
    public Point3(int x, int y,int cnt)
    {
        this.x = x;
        this.y = y;
        this.cnt = cnt;
    }
}
