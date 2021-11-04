package Etc.samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q14889 {
    static int N;
    static int [][] map;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        StringTokenizer st;

        for(int i = 0; i < N; ++i)
        {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; ++j)
            {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int startPoint = (int)Math.pow(2,N/2)-1;
        StringBuilder sb;
        int tmp_cnt;
        for(int i = startPoint; i < 1 << N; ++i)
        {
            sb = new StringBuilder();
            tmp_cnt = 0;
            for(int j = 0; j < N; ++j)
            {
                if((i & (1 << j)) > 0)
                {
                    tmp_cnt++;
                    sb.append("1");
                }
                else
                {
                    tmp_cnt--;
                    sb.append("0");
                }
            }
            if(tmp_cnt == 0) diff(sb.toString());
        }
        System.out.print(min);
    }
    static void diff(String comb)
    {
        boolean [] team = new boolean[N];

        for(int i = 0; i < comb.length(); ++i)
        {
            if(comb.charAt(i) == '1') team[i] = true;
        }

        int total_s = 0;
        int total_l = 0;
        for(int i = 0; i < N; ++i)
        {
            for(int j = i+1; j < N; ++j)
            {
                if(team[i] && team[j]) total_s += map[i][j] + map[j][i];
                else if(!team[i] && !team[j]) total_l += map[i][j] + map[j][i];
            }
        }
        if(total_s == total_l)
        {
            System.out.print(0);
            System.exit(0);
        }
        min = Math.min(Math.abs(total_s - total_l),min);
    }
}
