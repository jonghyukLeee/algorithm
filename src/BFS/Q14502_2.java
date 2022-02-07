package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Virus
{
    int x,y;

    public Virus(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
public class Q14502_2 {
    static int [][] origin;
    static List<Virus> virus;
    static int N,M;
    static int wall_cnt = 3;
    static int total_area;
    static int answer = Integer.MIN_VALUE;
    static int [] dx = {-1,1,0,0};
    static int [] dy = {0,0,-1,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        total_area = N * M;

        origin = new int[N][M];
        virus = new ArrayList<>();

        for(int i = 0; i < N; ++i)
        {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; ++j)
            {
                int next = Integer.parseInt(st.nextToken());
                origin[i][j] = next;
                if(next == 2) virus.add(new Virus(i,j));
                else if(next == 1) wall_cnt++;
            }
        }
        int [][] copy_map = new int[N][M];

        for(int i = 0; i < N; ++i)
        {
            System.arraycopy(origin[i],0,copy_map[i],0,M);
        }

        makeWall(0);
        System.out.println(answer);
    }
    static void makeWall(int cnt)
    {
        if(cnt == 3)
        {
            spread();
            return;
        }

        for(int i = 0; i < N; ++i)
        {
            for(int j = 0; j < M; ++j)
            {
                if(origin[i][j] == 0)
                {
                    origin[i][j] = 1;
                    makeWall(cnt+1);
                    origin[i][j] = 0;
                }
            }
        }
    }
    static void spread()
    {
        int [][] copy_map = new int[N][M];

        for(int i = 0; i < N; ++i)
        {
            System.arraycopy(origin[i],0,copy_map[i],0,M);
        }

        Queue<Virus> q = new LinkedList<>(virus);
        int virus_area = 0;
        while(!q.isEmpty())
        {
            Virus cur = q.poll();
            virus_area++;
            for(int idx = 0; idx < 4; ++idx)
            {
                int mx = cur.x + dx[idx];
                int my = cur.y + dy[idx];

                if(!isValid(mx,my)) continue;
                if(copy_map[mx][my] == 0)
                {
                    copy_map[mx][my] = 2;
                    q.add(new Virus(mx,my));
                }
            }
        }
        answer = Math.max(answer,total_area - (wall_cnt + virus_area));
    }
    static boolean isValid(int x, int y)
    {
        return x >= 0 && y >= 0 && x < N && y < M;
    }
}
