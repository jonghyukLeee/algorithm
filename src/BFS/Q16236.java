package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

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
class Prey
{
    int x,y,dist;
    public Prey(int x,int y, int dist)
    {
        this.x = x;
        this.y = y;
        this.dist = dist;
    }
}
public class Q16236 {
    static int [][] map;
    static ArrayList<Prey> prey;
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
        prey = new ArrayList<>();

        for(int i = 0; i < n; ++i)
        {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; ++j)
            {
                int tmp = Integer.parseInt(st.nextToken());
                if(tmp == 9)
                {
                    cur_loc = new Shark(i,j,0);
                    isVis[i][j] = true;
                    tmp = 0;
                }
                map[i][j] = tmp;
            }
        }

       while(true)
       {
            bfs(cur_loc);
            if(!prey.isEmpty())
            {
                prey.sort(new Comparator<Prey>() {
                    @Override
                    public int compare(Prey o1, Prey o2) {
                        if (o1.dist == o2.dist) {
                            if (o1.x == o2.x) {
                                return o1.y - o2.y;
                            }
                            return o1.x - o2.x;
                        }
                        return o1.dist - o2.dist;
                    }
                });
                Prey tmp = prey.get(0);
                prey.clear();
                map[tmp.x][tmp.y] = 0;
                eat_cnt++;
                if(eat_cnt == shark_size)
                {
                    shark_size++;
                    eat_cnt = 0;
                }
                answer += tmp.dist;
                cur_loc = new Shark(tmp.x,tmp.y,answer);
                isVis = new boolean[n][n];
            }
            else break;
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

            if(map[cur_x][cur_y] > 0 && map[cur_x][cur_y] < shark_size)
            {
                prey.add(new Prey(cur_x,cur_y,tmp.time));
                continue;
            }

            for(int idx = 0; idx < 4; ++idx)
            {
                int x = cur_x + dx[idx];
                int y = cur_y + dy[idx];
                if(!isValid(x,y) || isVis[x][y] || map[x][y] > shark_size) continue;
                isVis[x][y] = true;
                q.add(new Shark(x,y,tmp.time+1));
            }
        }
    }
    static boolean isValid(int x, int y)
    {
        return x >= 0 && y >= 0 && x < map.length && y < map[0].length;
    }
}
