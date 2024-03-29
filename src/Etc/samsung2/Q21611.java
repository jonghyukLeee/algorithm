package Etc.samsung2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Num
{
    int x,y,dir;

    public Num(int x, int y, int dir)
    {
        this.x = x;
        this.y = y;
        this.dir = dir;
    }
    public Num(int x, int y)
    {
        this.x = x;
        this.y = y;
    }
}
public class Q21611 {
    static int N,M;
    static int max_cnt;
    static int [][] getNum;
    static int [] destroyed;
    static Num shark;
    static int [][] map;
    static List<Integer> list;
    static int [] dx = {0,1,0,-1};
    static int [] dy = {-1,0,1,0};
    static int [] shark_x = {-1,1,0,0};
    static int [] shark_y = {0,0,-1,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int center = N / 2;
        max_cnt = N * N;
        list = new LinkedList<>();
        list.add(0); // 상어
        map = new int[N][N];
        getNum = new int[N][N];
        shark = new Num(center,center,0);
        destroyed = new int[4];

        for (int i = 0; i < N; ++i) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; ++j) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        setPoints();
        for(int i = 0 ; i < M; ++i)
        {
            st = new StringTokenizer(br.readLine());
            int dir = Integer.parseInt(st.nextToken())-1;
            int dist = Integer.parseInt(st.nextToken());

            blizzard(dir,dist);
            destroy();
            if(list.isEmpty()) break;
            setList();
        }

        int answer = 0;
        for(int i = 1; i < 4; ++i) answer += destroyed[i] * i;
        System.out.print(answer);
    }
    static void setList()
    {
        Queue<Integer> q = new LinkedList<>();
        q.add(0); // 상어
        int add_cnt = 1;
        int size = list.size();
        int pre = list.get(1);
        int cnt = 1;
        for(int i = 2; i < size; ++i)
        {
            int now = list.get(i);
            if(pre == now) cnt++;
            else
            {
                q.add(cnt);
                q.add(pre);
                cnt = 1;
                add_cnt += 2;
                if(add_cnt >= max_cnt) break;
            }
            pre = now;
        }
        if(cnt > 1)
        {
            q.add(cnt);
            q.add(pre);
        }
        list = new LinkedList<>();
        list.addAll(q);
    }
    static void destroy()
    {
        int size = list.size();
        PriorityQueue<Num> remove_q = new PriorityQueue<>(new Comparator<Num>() {
            @Override
            public int compare(Num o1, Num o2) {
                return o2.x - o1.x;
            }
        });
        int cnt = 1;
        for(int i = 1; i < size-1; ++i)
        {
            if(list.get(i) == list.get(i+1)) cnt++;
            else
            {
                if(cnt > 3) remove_q.add(new Num(i,cnt));
                cnt = 1;
            }
        }
        if(!remove_q.isEmpty())
        {
            ListIterator<Integer> it = list.listIterator();
            while(it.hasNext()) it.next();
            it.previous();
            int it_idx = size-1;
            while(!remove_q.isEmpty())
            {
                Num cur = remove_q.poll();
                int idx = cur.x;
                int tmp = it_idx-idx;
                for(int i = 0; i < tmp; ++i) it.previous();
                it_idx = idx;
                int num = list.get(idx);
                int t = cur.y;
                destroyed[num] += t;
                for(int i = 0; i < t; ++i)
                {
                    it.remove();
                    it.previous();
                    it_idx--;
                }

            }
            destroy();
        }
    }
    static void blizzard(int dir, int dist)
    {
        int nx = shark.x;
        int ny = shark.y;
        int rmv_cnt = 0;
        int list_size = list.size();
        for(int i = 0; i < dist; ++i)
        {
            nx += shark_x[dir];
            ny += shark_y[dir];
            if(isValid(nx,ny))
            {
                int val = getNum[nx][ny];
                int rmv_idx = val - rmv_cnt;
                if(rmv_idx < list_size)
                {
                    list.remove(rmv_idx);
                    rmv_cnt++;
                    list_size--;
                }
            }
        }
    }
    static void setPoints()
    {
        int tmp_dist = 0;
        int tmp_x = shark.x;
        int tmp_y = shark.y;
        int tmp_dir = shark.dir;
        int p_idx = 1;
        for (int i = 1; i < N; ++i) {
            tmp_dist++;
            for (int j = 0; j < 2; ++j) {
                for (int k = 0; k < tmp_dist; ++k) {
                    tmp_x += dx[tmp_dir];
                    tmp_y += dy[tmp_dir];
                    getNum[tmp_x][tmp_y] = p_idx++;
                    if(map[tmp_x][tmp_y] > 0) list.add(map[tmp_x][tmp_y]);
                }
                tmp_dir = (tmp_dir + 1) % 4;
            }
        }
        for (int i = 0; i < tmp_dist; ++i) // 마지막줄
        {
            tmp_x += dx[tmp_dir];
            tmp_y += dy[tmp_dir];
            getNum[tmp_x][tmp_y] = p_idx++;
            if(map[tmp_x][tmp_y] > 0) list.add(map[tmp_x][tmp_y]);
        }
    }
    static boolean isValid(int x, int y)
    {
        return x >= 0 && y >= 0 && x < N && y < N;
    }
}
