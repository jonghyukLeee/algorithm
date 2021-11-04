package Etc.samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Virus
{
    int x,y,cnt;

    public Virus(int x, int y)
    {
        this.x = x;
        this.y = y;
    }
    public Virus(int x, int y,int cnt)
    {
        this.x = x;
        this.y = y;
        this.cnt = cnt;
    }
}
public class Q17142 {
    static int zero_cnt;
    static int answer = Integer.MAX_VALUE;
    static int N,M;
    static int v_size;
    static int [][] map;
    static boolean [][] visited;
    static List<Virus> virus;
    static int [] dx = {-1,1,0,0};
    static int [] dy = {0,0,-1,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        virus = new ArrayList<>();

        for(int i = 0; i < N; ++i)
        {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; ++j)
            {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] > 1)
                {
                    virus.add(new Virus(i,j));
                }
                else if(map[i][j] == 0) zero_cnt++;
            }
        }
        v_size = virus.size();
        comb("",M,0,0);
        if(answer == Integer.MAX_VALUE) answer = -1;
        System.out.print(answer);
    }
    static void comb(String str,int dest,int cnt, int idx)
    {
        if(cnt == dest)
        {
            visited = new boolean[N][N];
            String [] str_arr = str.split(" ");
            Virus [] v_arr = new Virus[dest];
            for(int i = 0; i < dest; ++i)
            {
                v_arr[i] = virus.get(Integer.parseInt(str_arr[i]));
            }
            spread(v_arr);
            return;
        }

        for(int i = idx; i < v_size; ++i)
        {
            comb(str+i+" ",dest,cnt+1,i+1);
        }
    }
    static void spread(Virus [] arr)
    {
        Queue<Virus> q = new LinkedList<>();
        for(Virus v : arr)
        {
            q.add(new Virus(v.x,v.y,0));
            visited[v.x][v.y] = true;
        }

        int tmp_cnt = zero_cnt;
        int time = Integer.MIN_VALUE;
        while(!q.isEmpty())
        {
            Virus cur = q.poll();
            if(tmp_cnt == 0)
            {
                time = Math.max(time,cur.cnt);
                continue;
            }
            for(int idx = 0; idx < 4; ++idx)
            {
                int mx = cur.x + dx[idx];
                int my = cur.y + dy[idx];

                if(!isValid(mx,my) || visited[mx][my] || map[mx][my] == 1) continue;
                visited[mx][my] = true;
                if(map[mx][my] == 0) tmp_cnt--;
                q.add(new Virus(mx,my,cur.cnt+1));
            }
        }
        if(time == Integer.MIN_VALUE) return;
        answer = Math.min(time,answer);

    }
    static boolean isValid(int x, int y)
    {
        return x >= 0 && y >= 0 && x < N && y < N;
    }
}
