package Etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q15684 {
    static int N,M,H;
    static int answer = -1;
    static int [][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());

        map = new int[H+1][N+1];

        for(int i = 0; i < M; ++i)
        {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            map[x][y] = 1;
            map[x][y+1] = -1;
        }

        int [][] copy = new int[H+1][N+1];
        for(int i = 0; i < 4; ++i)
        {
            for(int j = 0; j <= H; ++j)
            {
                System.arraycopy(map[j],0,copy[j],0,N+1);
            }
            if(dfs(1,1,0,i,copy))
            {
                answer = i;
                break;
            }
        }
        System.out.print(answer);
    }
    static boolean dfs(int x, int y,int cnt, int dest,int [][] copy)
    {
        if(cnt == dest)
        {
            return play(copy);
        }

        for(int i = x; i <= H; ++i)
        {
            for(int j = y; j < N; ++j)
            {
                if(copy[i][j] != 0 || copy[i][j+1] > 0) continue;
                copy[i][j] = 1;
                copy[i][j+1] = -1;
                if(j+1 == N) dfs()
            }
        }
    }
    static boolean play(int [][] copy)
    {
        boolean res = true;
        for(int i = 1; i <= N; ++i)
        {
            int cur_x = 1;
            int cur_y = i;

            while(cur_x < H+1)
            {
                if(copy[cur_x][cur_y] > 0)
                {
                    cur_y++;
                    copy[cur_x][cur_y] = 0;
                }
                else if(copy[cur_x][cur_y] < 0)
                {
                    cur_y--;
                    copy[cur_x][cur_y] = 0;
                }
                else
                {
                    cur_x++;
                }
            }
            if(cur_y != i)
            {
                res = false;
                break;
            }
        }
        return res;
    }
}
