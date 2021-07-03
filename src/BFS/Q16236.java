package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Shark
{
    int x,y,time,size;
    public Shark(int x, int y,int time, int size)
    {
        this.x = x;
        this.y = y;
        this.time = time;
        this.size = size;
    }
}
public class Q16236 {
    static int [][] map;
    static boolean [][] isVis;
    static int answer = 0;
    static int eat_cnt = 0;
    static Queue<Shark> q;
    static int [] dx = {-1,0,0,1};
    static int [] dy = {0,-1,1,0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        isVis = new boolean[n][n];

        q = new LinkedList<>();
        for(int i = 0; i < n; ++i)
        {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; ++j)
            {
                int tmp = Integer.parseInt(st.nextToken());
                if(tmp == 9)
                {
                    q.add(new Shark(i,j,0,2));
                }
                map[i][j] = tmp;
            }
        }

        while(!q.isEmpty())
        {
            Shark tmp = q.poll();
            int cur_x = tmp.x;
            int cur_y = tmp.y;
            isVis[cur_x][cur_y] = true;

            if(map[cur_x][cur_y] > 0 && map[cur_x][cur_y] < tmp.size)
            {
                answer += tmp.time;
                tmp.time = 0;
                map[cur_x][cur_y] = 0;
                eat_cnt++;
                if(eat_cnt == tmp.size)
                {
                    tmp.size++;
                    eat_cnt = 0;
                }
            }

            for(int idx = 0; idx < 4; ++idx)
            {
                int x = cur_x + dx[idx];
                int y = cur_y + dy[idx];
                if(!isValid(x,y) || isVis[x][y]) continue;
                q.add(new Shark(x,y,tmp.time+1,tmp.size));
            }
        }
        System.out.print(answer);
    }
    static boolean isValid(int x, int y)
    {
        return x >= 0 && y >= 0 && x < map.length && y < map[0].length;
    }
}
