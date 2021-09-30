package Etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q14888 {
    static int [] map,op;
    static int N;
    static int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; ++i) map[i] = Integer.parseInt(st.nextToken());

        op = new int[4];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < 4; ++i) op[i] = Integer.parseInt(st.nextToken());

        calc(1,map[0]);
        System.out.printf("%d\n%d",max,min);
    }
    static void calc(int idx, int num)
    {
        if(idx == N)
        {
           min = Math.min(num,min);
           max = Math.max(num,max);
           return;
        }

        for(int i = 0; i < 4; ++i) // + - x /
        {
            if(op[i] > 0)
            {
                op[i]--;
                if(i == 0) calc(idx+1,num + map[idx]);
                else if(i == 1) calc(idx+1,num - map[idx]);
                else if(i == 2) calc(idx+1,num * map[idx]);
                else calc(idx+1, num / map[idx]);
                op[i]++;
            }
        }
    }
}
