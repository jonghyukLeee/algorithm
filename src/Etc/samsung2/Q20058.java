package Etc.samsung2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q20058 {
    static int N,Q;
    static int [][] map;
    static int [][] tmp_map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = (int)Math.pow(2,Integer.parseInt(st.nextToken()));
        Q = Integer.parseInt(st.nextToken());

        map = new int[N][N];

        for(int i = 0; i < N; ++i)
        {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; ++j)
            {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < Q; ++i)
        {
            cast(Integer.parseInt(st.nextToken()));

            System.out.println("after");
            for(int [] j : map)
            {
                for(int k : j) System.out.print(k+" ");
                System.out.println();
            }
        }
    }
    static void cast(int n)
    {
        tmp_map = new int[N][N];
        for(int i = 0; i < N; ++i) System.arraycopy(map[i],0,tmp_map[i],0,N);

        int l = (int)Math.pow(2,n);
        System.out.println(l);
        for(int i = 0; i < N; i+=l)
        {
            for(int j = 0; j < N; j+=l)
            {
                rotate(i,j,l);
            }
        }
    }
    static void rotate(int x, int y, int size)
    {
        for(int i = x; i < x+size; ++i)
        {
            for(int j = y; j < y+size; ++j)
            {
                map[i][j] = tmp_map[size-j-1][j];
            }
        }

    }
}
