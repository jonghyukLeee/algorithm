package Etc.samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Smell
{
    int num,time;

    public Smell(int num, int time)
    {
        this.num = num;
        this.time = time;
    }
}
class Shark2
{
    int x,y,dir,num;

    public Shark2(int num, int x, int y, int dir)
    {
        this.num = num;
        this.x = x;
        this.y = y;
        this.dir = dir;
    }
    public Shark2(int x, int y)
    {
        this.x = x;
        this.y = y;
    }
}
public class Q19237 {
    static boolean [][] map;
    static int [] dx = {-1,1,0,0};
    static int [] dy = {0,0,-1,1};
    static List<Integer> [][] dir_info;
    static int N,M,K;
    static Smell [][] smell;
    static PriorityQueue<Shark2> pq;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new boolean[N][N];
        smell = new Smell[N][N];
        Shark2 [] tmp_arr = new Shark2[M];

        for(int i = 0; i < N; ++i)
        {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; ++j)
            {
                int tmp = Integer.parseInt(st.nextToken());
                if(tmp > 0)
                {
                    map[i][j] = true;
                    tmp_arr[tmp-1] = new Shark2(i,j);
                }
            }
        }

        pq = new PriorityQueue<>(new Comparator<Shark2>() {
            @Override
            public int compare(Shark2 o1, Shark2 o2) {
                return o1.num - o2.num;
            }
        });

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; ++i)
        {
            int tmp_x = tmp_arr[i].x;
            int tmp_y = tmp_arr[i].y;
            int tmp_dir = Integer.parseInt(st.nextToken())-1;
            pq.add(new Shark2(i+1,tmp_x,tmp_y,tmp_dir));
            smell[tmp_x][tmp_y] = new Smell(i+1,K);
        }

        dir_info = new ArrayList[M][4];
        for(int i = 0; i < M; ++i)
        {
            for(int j = 0; j < 4; ++j)
            {
                st = new StringTokenizer(br.readLine());
                dir_info[i][j] = new ArrayList<>();
                while(st.hasMoreTokens()) dir_info[i][j].add(Integer.parseInt(st.nextToken())-1);
            }
        }
        int t = 0;
        while(t++ < 1000)
        {
            Queue<Shark2> tmp_q = new LinkedList<>();
            next : while(!pq.isEmpty())
            {
                Shark2 cur = pq.poll();
                map[cur.x][cur.y] = false;
                // 빈칸탐색
                for(int idx = 0; idx < 4; ++idx)
                {
                    int dir = dir_info[cur.num-1][cur.dir].get(idx);
                    int mx = cur.x + dx[dir];
                    int my = cur.y + dy[dir];

                    if(!isValid(mx,my) || smell[mx][my] != null) continue;
                    if(!map[mx][my])
                    {
                        map[mx][my] = true;
                        tmp_q.add(new Shark2(cur.num,mx,my,dir));
                    }
                    continue next;
                }

                // 자신의 냄새 탐색
                for(int idx = 0; idx < 4; ++idx)
                {
                    int dir = dir_info[cur.num-1][cur.dir].get(idx);
                    int mx = cur.x + dx[dir];
                    int my = cur.y + dy[dir];

                    if(!isValid(mx,my) || smell[mx][my] == null || map[mx][my]) continue;
                    if(smell[mx][my].num == cur.num)
                    {
                        map[mx][my] = true;
                        tmp_q.add(new Shark2(cur.num,mx,my,dir));
                        continue next;
                    }
                }
            }

            for(int i = 0; i < N; ++i) // 냄새 지속시간 감소
            {
                for(int j = 0; j < N; ++j)
                {
                    if(smell[i][j] != null)
                    {
                        if(smell[i][j].time > 1) smell[i][j].time--;
                        else smell[i][j] = null;
                    }
                }
            }

            while(!tmp_q.isEmpty())
            {
                Shark2 cur = tmp_q.poll();
                pq.add(cur);
                smell[cur.x][cur.y] = new Smell(cur.num,K);
            }

            if(pq.size() == 1) break;
        }

        int answer = t == 1001 ? -1 : t;
        System.out.print(answer);
    }
    static boolean isValid(int x, int y)
    {
        return x >= 0 && y >= 0 && x < N && y < N;
    }
}
