package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Warrior
{
    int x,y,t;
    int sword;

    public Warrior(int x, int y, int t, int sword) {
        this.x = x;
        this.y = y;
        this.t = t;
        this.sword = sword;
    }
}
public class Q17836 {
    static int N,M,T;
    static int [][] map;
    static boolean [][][] visited;
    static int [] dx = {-1,1,0,0};
    static int [] dy = {0,0,-1,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M][2];

        for(int i = 0; i < N; i++)
        {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++)
            {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        Queue<Warrior> q = new LinkedList<>();
        q.add(new Warrior(0,0,0,0));
        visited[0][0][0] = true;
        int minVal = -1;
        while(!q.isEmpty())
        {
            Warrior cur = q.poll();
            //시간초과
            if(cur.t > T) continue;
            //공주한테 도달
            if((cur.x == N-1) && (cur.y == M-1))
            {
                minVal = cur.t;
                break;
            }
            for(int idx = 0; idx < 4; idx++)
            {
                int mx = cur.x + dx[idx];
                int my = cur.y + dy[idx];
                int hasSword = cur.sword;

                if(!isValid(mx,my)) continue;
                //검이 없을때
                if(hasSword == 0)
                {
                    if(visited[mx][my][0] || map[mx][my] == 1) continue;
                    //검을 주움
                    if(map[mx][my] == 2) hasSword++;

                }
                //있을때
                else
                {
                    if(visited[mx][my][1]) continue;
                }
                visited[mx][my][hasSword] = true;
                q.add(new Warrior(mx,my,cur.t+1,hasSword));

            }
        }
        System.out.print(minVal < 0 ? "Fail" : minVal);
    }
    static boolean isValid(int x, int y)
    {
        return x >= 0 && y >= 0 && x < N && y < M;
    }
}
