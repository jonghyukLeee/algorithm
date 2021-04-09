package Week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q7562_2 {
    static int [][] map;
    static boolean [][] isVis;
    static int goalX,goalY;
    static Queue<Point3> q;
    static StringBuilder sb;
    static int [] dx = {1,2,2,1,-1,-2,-2,-1};
    static int [] dy = {2,1,-1,-2,-2,-1,1,2};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();
        int n;
        int t = Integer.parseInt(br.readLine());

        while(t-- > 0)
        {
            n = Integer.parseInt(br.readLine());
            map = new int[n][n];
            isVis = new boolean[n][n];
            int res = Integer.MAX_VALUE;

            st = new StringTokenizer(br.readLine());
            int startX = Integer.parseInt(st.nextToken());
            int startY = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int goalX = Integer.parseInt(st.nextToken());
            int goalY = Integer.parseInt(st.nextToken());

            q = new LinkedList<>();
            q.add(new Point3(startX,startY,0));
            isVis[startX][startY] = true;

            while(!q.isEmpty())
            {
                Point3 tmp = q.poll();
                if(tmp.x == goalX && tmp.y == goalY)
                {
                    res = Math.min(res,tmp.cnt);
                }
                for(int i = 0; i < 8; ++i)
                {
                    int mx = tmp.x + dx[i];
                    int my = tmp.y + dy[i];
                    if(!isValid(mx,my)) continue;
                    if(isVis[mx][my]) continue;

                    q.add(new Point3(mx,my,tmp.cnt+1));
                    isVis[mx][my] = true;
                }
            }
            sb.append(res).append("\n");
        } //end of loop
        System.out.print(sb.toString());
    }
    static boolean isValid(int x, int y)
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
