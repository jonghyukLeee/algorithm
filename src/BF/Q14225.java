package BF;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q14225 {
    static int [] map;
    static boolean [] sum;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N];

        int size = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++)
        {
            map[i] = Integer.parseInt(st.nextToken());
            size += map[i];
        }

        sum = new boolean[size+2];

        for(int i = 0; i < N; i++)
        {
            comb(i,map[i]);
        }

        for(int i = 1; i < size+2; i++)
        {
            if(!sum[i])
            {
                System.out.print(i);
                break;
            }
        }
    }
    static void comb(int idx, int tmp)
    {
        sum[tmp] = true;
        for(int i = idx+1; i < N; i++)
        {
            comb(i,tmp+map[i]);
        }
    }
}
