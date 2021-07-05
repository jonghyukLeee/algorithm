package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Shark
{
    int x,y,time;
    public Shark(int x, int y,int time)
    {
        this.x = x;
        this.y = y;
        this.time = time;
    }
}
public class Q16236 {
    static int [][] map;
    static int n;
    static boolean [][] isVis;
    static int answer = 0;
    static int eat_cnt = 0;
    static int shark_size = 2;
    static Shark cur_loc;
    static Queue<Shark> q;
    static int [] dx = {-1,0,0,1};
    static int [] dy = {0,-1,1,0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        isVis = new boolean[n][n];

        for(int i = 0; i < n; ++i)
        {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; ++j)
            {
                int tmp = Integer.parseInt(st.nextToken());
                if(tmp == 9)
                {
                    cur_loc = new Shark(i,j,0);
                    tmp = 0;
                }
                map[i][j] = tmp;
            }
        }

        while(true)
        {
            if(!hasPrey(shark_size)) break;
            isVis = new boolean[n][n];
            bfs(cur_loc);
        }
        System.out.print(answer);
    }

    static void bfs(Shark shark)
    {
        q = new LinkedList<>();

        q.add(new Shark(shark.x,shark.y,0));

        while(!q.isEmpty())
        {
            Shark tmp = q.poll();
            int cur_x = tmp.x;
            int cur_y = tmp.y;
            isVis[cur_x][cur_y] = true;

            if(map[cur_x][cur_y] > 0 && map[cur_x][cur_y] < shark_size)
            {
                answer += tmp.time;
               //System.out.printf("cur loc : (%d, %d) size = %d time = %d \n",cur_x,cur_y,shark_size,answer);
                map[cur_x][cur_y] = 0;
                eat_cnt++;
                if(eat_cnt == shark_size)
                {
                    shark_size++;
                    eat_cnt = 0;
                }
                cur_loc = new Shark(cur_x,cur_y,answer);
                return;
            }

            for(int idx = 0; idx < 4; ++idx)
            {
                int x = cur_x + dx[idx];
                int y = cur_y + dy[idx];
                if(!isValid(x,y) || isVis[x][y] || map[x][y] > shark_size) continue;
                q.add(new Shark(x,y,tmp.time+1));
            }
        }
    }
    static boolean isValid(int x, int y)
    {
        return x >= 0 && y >= 0 && x < map.length && y < map[0].length;
    }
    static boolean hasPrey(int size)
    {
        for(int [] i : map)
        {
            for(int j : i)
            {
                if(j > 0 && j < size) return true;
            }
        }
        return false;
    }
}
