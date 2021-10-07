package Etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Cam
{
    int x,y;

    public Cam(int x, int y)
    {
        this.x = x;
        this.y = y;
    }
}
public class Q15683 {
    static int N,M,zero_cnt;
    static int [][] map;
    static List<Cam> tv_loc;
    static List<String> [] mv_list;
    static int [] dx = {-1,0,1,0};
    static int [] dy = {0,1,0,-1};
    static boolean [] tv;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        tv_loc = new ArrayList<>();
        tv = new boolean[6];
        mv_list = new List[6];

        for(int i = 0; i < N; ++i)
        {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; ++j)
            {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] > 0 && map[i][j] < 6)
                {
                    tv_loc.add(new Cam(i, j));
                    if (!tv[map[i][j]]) tv[map[i][j]] = true;
                }
                else if (map[i][j] == 0) zero_cnt++;
            }
        }

        String cctv_str [] = {"","0 1 2 3","13 02","01 12 23 30","013 012 123 023","0123"};
        for(int i = 1; i < 6; ++i)
        {
            if(tv[i])
            {
                mv_list[i] = new ArrayList<>();
                st = new StringTokenizer(cctv_str[i]);
                while(st.hasMoreTokens()) mv_list[i].add(st.nextToken());
            }
        }

    }
    static void scan()
    {
        for(int i = 1; i < 6; ++i)
        {
            if(tv[i])
            {

            }
        }
    }
    static boolean isValid(int x, int y)
    {
        return x >= 0 && y >= 0 && x < N && y < M;
    }
}
