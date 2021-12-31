package Review_30days.day8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Point
{
    int x,y;
    int mv_cnt;

    public Point(int x, int y,int mv_cnt)
    {
        this.x = x;
        this.y = y;
        this.mv_cnt = mv_cnt;
    }
}
public class Q16948 {
    static int N;
    static int [] dx = {-2,-2,0,0,2,2};
    static int [] dy = {-1,1,-2,2,-1,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int r1 = Integer.parseInt(st.nextToken());
        int c1 = Integer.parseInt(st.nextToken());
        int r2 = Integer.parseInt(st.nextToken());
        int c2 = Integer.parseInt(st.nextToken());

        Queue<Point> q = new LinkedList<>();
        q.add(new Point(r1,c1,0));

        int answer = Integer.MAX_VALUE;
        boolean [][] visited = new boolean[N][N];
        visited[r1][c1] = true;
        while(!q.isEmpty())
        {
            Point cur = q.poll();
            if((cur.x == r2) && (cur.y == c2))
            {
                answer = Math.min(answer,cur.mv_cnt);
                continue;
            }

            for(int idx = 0; idx < 6; ++idx)
            {
                int mx = cur.x + dx[idx];
                int my = cur.y + dy[idx];

                if(!isValid(mx,my) || visited[mx][my]) continue;
                visited[mx][my] = true;
                q.add(new Point(mx,my,cur.mv_cnt+1));
            }
        }
        if(answer == Integer.MAX_VALUE) answer = -1;
        System.out.print(answer);
    }
    static boolean isValid(int x, int y)
    {
        return x >= 0 && y >= 0 && x < N && y < N;
    }
}
