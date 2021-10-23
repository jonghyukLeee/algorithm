package Etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Virus
{
    int x,y;
    boolean alive;

    public Virus(int x, int y)
    {
        this.x = x;
        this.y = y;
    }
    public Virus(int x, int y,boolean alive)
    {
        this.x = x;
        this.y = y;
        this.alive = alive;
    }
    public void setStatus()
    {
        this.alive = !this.alive;
    }
}
public class Q17142 {
    static int N,M;
    static int v_size;
    static int [][] map;
    static List<Virus> virus;
    static int [] dx = {-1,1,0,0};
    static int [] dy = {0,0,-1,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][N];

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
            }
        }
        v_size = virus.size();
        comb("",M,0,0);
    }
    static void comb(String str,int dest,int cnt, int idx)
    {
        if(cnt == dest)
        {
            int [][] copy = new int[N][N];
            for(int i = 0; i < N; ++i)
            {
                System.arraycopy(map[i],0,copy[i],0,N);
            }
            List<Integer> tmp_list = new ArrayList<>();
            StringTokenizer st = new StringTokenizer(str);
            while(st.hasMoreTokens()) tmp_list.add(Integer.parseInt(st.nextToken()));
            for(int i : tmp_list) virus.get(i).setStatus();
            spread(copy);
            for(int i : tmp_list) virus.get(i).setStatus();
            return;
        }

        for(int i = idx; i < v_size; ++i)
        {
            comb(str+idx+" ",dest,cnt+1,i+1);
        }
    }
    static void spread(int [][] copy)
    {
        Queue<Virus> q = new LinkedList<>();
        for(Virus v : virus)
        {
            if(v.alive) q.add(new Virus(v.x,v.y,true));
        }

        while(!q.isEmpty())
        {
            Virus cur = q.poll();

            for(int idx = 0; idx < 4; ++idx)
            {
                int mx = cur.x + dx[idx];
                int my = cur.y + dy[idx];

                if(!isValid(mx,my) || map[mx][my] == 1) continue;

            }
        }
    }
    static boolean isValid(int x, int y)
    {
        return x >= 0 && y >= 0 && x < N && y < N;
    }
}
