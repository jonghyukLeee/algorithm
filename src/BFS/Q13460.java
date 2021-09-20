package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Ball
{
    int bx,by,rx,ry,cnt;

    public Ball(int bx, int by, int rx, int ry, int cnt)
    {
        this.bx = bx;
        this.by = by;
        this.rx = rx;
        this.ry = ry;
        this.cnt = cnt;
    }
}
public class Q13460 {
    static int n,m;
    static char [][] map;
    static boolean [][][][] isVis;
    static int [] dx = {-1,1,0,0};
    static int [] dy = {0,0,-1,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new char[n][m];

        int bx=0,by=0,rx=0,ry=0;
        for(int i = 0; i < n; ++i)
        {
            String tmp = br.readLine();
            for(int j = 0; j < m; ++j)
            {
                map[i][j] = tmp.charAt(j);
                if(map[i][j] == 'B')
                {
                    bx = i;
                    by= j;
                }
                else if(map[i][j] == 'R')
                {
                    rx = i;
                    ry = j;
                }
            }
        }
        isVis = new boolean[n][m][n][m];
        Queue<Ball> q= new LinkedList<>();
        q.add(new Ball(bx,by,rx,ry,1));
        boolean exitFlag = false;
        loop : while(!q.isEmpty())
        {
            Ball cur = q.poll();
            if(cur.cnt > 10)
            {
                System.out.print("-1");
                return;
            }
            if(isVis[cur.bx][cur.by][cur.rx][cur.ry]) continue;

            for(int i = 0; i < 4; ++i)
            {
                int b_mx = cur.bx;
                int b_my = cur.by;
                boolean [] isExit = new boolean[2];
                while(true)
                {
                    b_mx += dx[i];
                    b_my += dy[i];
                    if(!isValid(b_mx,b_my) || map[b_mx][b_my] == '#')
                    {
                        b_mx -= dx[i];
                        b_my -= dy[i];
                        break;
                    }
                    if(map[b_mx][b_my] == 'O')
                    {
                        isExit[0] = true;
                        break;
                    }
                }
                int r_mx = cur.rx;
                int r_my = cur.ry;
                while(true)
                {
                    r_mx += dx[i];
                    r_my += dy[i];
                    if(!isValid(r_mx,r_my) || map[r_mx][r_my] == '#')
                    {
                        r_mx -= dx[i];
                        r_my -= dy[i];
                        break;
                    }
                    if(map[r_mx][r_my] == 'O')
                    {
                        isExit[1] = true;
                        break;
                    }
                }
                if(b_mx == cur.bx && b_my == cur.by && r_mx == cur.rx && r_my == cur.ry) continue;
                if(isExit[1])
                {
                    if(isExit[0]) continue;
                    else
                    {
                        System.out.print(cur.cnt);
                        exitFlag = true;
                        break loop;
                    }
                }
                else if(isExit[0]) continue;
                if(b_mx == r_mx && b_my == r_my)
                {
                    if(i == 0)
                    {
                        if(cur.bx < cur.rx) r_mx += 1;
                        else b_mx += 1;
                    }
                    else if(i == 1)
                    {
                        if(cur.bx < cur.rx) b_mx -= 1;
                        else r_mx -= 1;
                    }
                    else if(i == 2)
                    {
                        if(cur.by < cur.ry) r_my += 1;
                        else b_my += 1;
                    }
                    else
                    {
                        if(cur.by < cur.ry) b_my -= 1;
                        else r_my -= 1;
                    }
                }
                q.add(new Ball(b_mx,b_my,r_mx,r_my,cur.cnt+1));
            }
            isVis[cur.bx][cur.by][cur.rx][cur.ry] = true;
        }
        if(!exitFlag) System.out.print("-1");

    }
    static boolean isValid(int x, int y)
    {
        return x > 0 && y > 0 && x < n-1 && y < m-1;
    }
}
