package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Shark
{
    int x,y,size;
    public Shark(int x, int y, int size)
    {
        this.x = x;
        this.y = y;
        this.size = size;
    }
}
public class Q16236 {
    static int [][] map;
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

        q = new LinkedList<>();
        for(int i = 0; i < n; ++i)
        {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; ++j)
            {
                int tmp = Integer.parseInt(st.nextToken());
                if(tmp == 9)
                {
                    q.add(new Shark(i,j,2));
                }
                map[i][j] = tmp;
            }
        }

        while(!q.isEmpty())
        {
            Shark tmp = q.poll();

            for(int idx = 0; idx < 4; ++idx)
            {
                int x = tmp.x + dx[idx];
                int y = tmp.y + dy[idx];
                if(!isValid(x,y)) continue;
                if(map[x][y] > 0 && map[x][y] < tmp.size)
                {
                    eat_cnt++;
                    if(eat_cnt == tmp.size)
                    {
                        tmp.size++;
                        eat_cnt = 0;
                    }
                    q.add(new Shark(x,y,tmp.size));
                    continue;
                }
            }
        }
    }
    static boolean isValid(int x, int y)
    {
        return x >= 0 && y >= 0 && x < map.length && y < map[0].length;
    }
}
