package Etc.samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Cam
{
    int num,x,y;

    public Cam(int num, int x, int y)
    {
        this.num = num;
        this.x = x;
        this.y = y;
    }
}
public class Q15683 {
    static int N,M;
    static int MIN = Integer.MAX_VALUE;
    static int [][] map;
    static List<Cam> tv_loc;
    static List<String> [] input_list;
    static List<String> scanList;
    static int [] dx = {-1,0,1,0};
    static int [] dy = {0,1,0,-1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        tv_loc = new ArrayList<>();

        int zero_cnt = 0;
        for(int i = 0; i < N; ++i)
        {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; ++j)
            {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] > 0 && map[i][j] < 6)
                {
                    tv_loc.add(new Cam(map[i][j],i, j));
                }
                else if(map[i][j] == 0) zero_cnt++;
            }
        }

        if(tv_loc.isEmpty())
        {
            int MIN = N * M;
            for(int [] i : map)
            {
                for(int j : i)
                {
                    if(j > 0) MIN--;
                }
            }
            System.out.print(MIN);
            return;
        }

        String [] mv_list  = {"","0 1 2 3","13 02","01 12 23 30","013 012 123 023","0123"};
        int input_size = tv_loc.size();

        input_list = new List[input_size];
        for(int i = 0; i < input_size; ++i) input_list[i] = new ArrayList<>();

        for(int i = 0; i < input_size; ++i)
        {
            st = new StringTokenizer(mv_list[tv_loc.get(i).num]);
            while(st.hasMoreTokens())
            {
                input_list[i].add(st.nextToken());
            }
        }

        scanList = new ArrayList<>();
        comb("",0);

        int [][] copy_map = new int[N][M];
        for(String comb : scanList)
        {
            String [] mv = comb.split(" ");
            for(int i = 0; i < N; ++i)
            {
                System.arraycopy(map[i],0,copy_map[i],0,M);
            }
            int scan_cnt = 0;
            for(int i = 0; i < mv.length; ++i)
            {
                Cam cur = tv_loc.get(i);
                char [] mv_arr = mv[i].toCharArray();

                for(int dir : mv_arr)
                {
                    scan_cnt += move(cur,dir-'0',copy_map,0);
                }
            }
            MIN = Math.min(MIN,zero_cnt-scan_cnt);
        }

        System.out.print(MIN);
    }
    static void comb(String comb,int depth) {
        if(depth == input_list.length)
        {
            scanList.add(comb);
            return;
        }

        int size = input_list[depth].size();
        for(int i = 0; i < size; ++i)
        {
            comb(comb+input_list[depth].get(i)+" ",depth+1);
        }
    }
    static int move(Cam cam,int dir, int [][] copy_map,int scan_cnt)
    {
        int x = cam.x;
        int y = cam.y;
        int cnt = scan_cnt;
        while(true)
        {
            x += dx[dir];
            y += dy[dir];
            if(!isValid(x,y) || copy_map[x][y] == 6) break;
            if(copy_map[x][y] == -1) continue;
            if(copy_map[x][y] == 0)
            {
                copy_map[x][y] = -1;
                cnt++;
            }

        }
        return cnt;
    }
    static boolean isValid(int x, int y)
    {
        return x >= 0 && y >= 0 && x < N && y < M;
    }
}
