package Review_30days.day8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Loc
{
    int x,y;
    int break_cnt, mv_cnt;

    public Loc(int x, int y, int break_cnt, int mv_cnt)
    {
        this.x = x;
        this.y = y;
        this.break_cnt = break_cnt;
        this.mv_cnt = mv_cnt;
    }
}
public class Q14442 {
    static int N,M,K;
    static int [][] map;
    static int [] dx = {-1,1,0,0};
    static int [] dy = {0,0,-1,1};
    static boolean [][][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for(int i = 0; i < N; ++i)
        {
            String tmp = br.readLine();
            for(int j = 0; j < M; ++j) map[i][j] = tmp.charAt(j)-'0';
        }

        System.out.print(bfs());
    }
    static int bfs()
    {
        Queue<Loc> q = new LinkedList<>();
        q.add(new Loc(0,0,0,1));

        visited = new boolean[N][M][K+1];
        visited[0][0][0] = true;
        while(!q.isEmpty())
        {
            Loc cur = q.poll();

            if((cur.x == N-1) && (cur.y == M-1)) return cur.mv_cnt;
            for(int idx = 0; idx < 4; ++idx)
            {
                int mx = cur.x + dx[idx];
                int my = cur.y + dy[idx];

                if(!isValid(mx,my) || visited[mx][my][cur.break_cnt]) continue;
                if(map[mx][my] == 0)
                {
                    visited[mx][my][cur.break_cnt] = true;
                    q.add(new Loc(mx,my,cur.break_cnt,cur.mv_cnt+1));
                }
                else if(cur.break_cnt < K)
                {
                    if(visited[mx][my][cur.break_cnt+1]) continue;
                    visited[mx][my][cur.break_cnt+1] = true;
                    q.add(new Loc(mx,my,cur.break_cnt+1,cur.mv_cnt+1));
                }
            }
        }
        return -1;
    }
    static boolean isValid(int x,int y)
    {
        return x >= 0 && y >= 0 && x < N && y < M;
    }
}
