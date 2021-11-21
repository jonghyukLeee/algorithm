package Etc.samsung2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Fireball
{
    int x,y;
    int cnt,mass,speed,dir;
    boolean sameDir = true;

    public Fireball(int x, int y, int cnt, int mass, int speed, int dir)
    {
        this.x = x;
        this.y = y;
        this.cnt = cnt;
        this.mass = mass;
        this.speed = speed;
        this.dir = dir;
    }
}
public class Q20056 {
    static int result;
    static int N,M,K;
    static Fireball [][] map;
    static Queue<Fireball> q;
    static Queue<Fireball> tmp_q;
    static int [] dx = {-1,-1,0,1,1,1,0,-1};
    static int [] dy = {0,1,1,1,0,-1,-1,-1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        q = new LinkedList<>();
        tmp_q = new LinkedList<>();
        for(int i = 0; i < M; ++i)
        {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            q.add(new Fireball(r,c,1,m,s,d));
        }

        while(K-- > 0)
        {
            tmp_q = new LinkedList<>();
            while(!q.isEmpty())
            {
                Fireball cur = q.poll();

                int mx = cur.x + (dx[cur.dir] * cur.speed);
                int my = cur.y + (dy[cur.dir] * cur.speed);

                while(!isValid(mx)) mx = move(mx);
                while(!isValid(my)) my = move(my);

                tmp_q.add(new Fireball(mx,my,1,cur.mass,cur.speed,cur.dir));
            }
            setFire();
            separateFire();
        }
        while(!q.isEmpty()) result += q.poll().mass;
        System.out.print(result);
    }
    static void setFire()
    {
        map = new Fireball[N+1][N+1];
        while(!tmp_q.isEmpty())
        {
            Fireball cur = tmp_q.poll();

            if(map[cur.x][cur.y] != null)
            {
                combFire(map[cur.x][cur.y],cur);
            }
            else map[cur.x][cur.y] = cur;
        }
    }
    static void separateFire()
    {
        for(int i = 1; i <= N; ++i)
        {
            for(int j = 1; j <= N; ++j)
            {
                if(map[i][j] != null)
                {
                    Fireball cur = map[i][j];
                    if(cur.cnt > 1)
                    {
                        int tmp_m = cur.mass / 5;
                        if(tmp_m == 0)
                        {
                            map[i][j] = null;
                            continue;
                        }
                        int tmp_s = cur.speed / cur.cnt;
                        int dir_idx = cur.sameDir ? 0 : 1;

                        for(int idx = dir_idx; idx <= 7; idx+=2)
                        {
                            q.add(new Fireball(i,j,1,tmp_m,tmp_s,idx));
                        }
                    }
                    else q.add(cur);
                }
            }
        }
    }
    static void combFire(Fireball fst, Fireball sec)
    {
        fst.cnt++;
        fst.mass += sec.mass;
        fst.speed += sec.speed;

        if(fst.sameDir)
        {
            int tmp_dir = fst.dir + sec.dir;
            if(tmp_dir % 2 > 0) fst.sameDir = false;
        }
    }
    static boolean isValid(int p)
    {
        return p > 0 && p <= N;
    }
    static int move(int p)
    {
        if(p <= 0) return p + N;
        else if(p > N) return p - N;
        else return p;
    }
}
