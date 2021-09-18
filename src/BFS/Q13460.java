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
    static int [] dx = {0,0,-1,1};
    static int [] dy = {1,-1,0,0};
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

        Queue<Ball> q= new LinkedList<>();
        q.add(new Ball(bx,by,rx,ry,0));

        while(!q.isEmpty())
        {
            Ball cur = q.poll();

            for(int i = 0; i < 4; ++i)
            {
                int b_mx = cur.bx;
                int b_my = cur.by;
                while(!isValid(b_mx,b_my) || !(map[b_mx][b_my] == '.'))
                {
                    b_mx += dx[i];
                    b_my += dy[i];
                }
                int r_mx = cur.rx;
                int r_my = cur.ry;
                while(!isValid(r_mx,r_my)) // 0을 만났을 경우 추가해야함
                {
                    r_mx += dx[i];
                    r_my += dy[i];
                }
                //이동 전과 후와 같을경우 그냥 컨티뉴, 아닐경우는 각 좌표마다 -1해서 큐에 add
            }
        }

    }
    static boolean isValid(int x, int y)
    {
        return x > 0 && y > 0 && x < n-1 && y < m-1;
    }
}
