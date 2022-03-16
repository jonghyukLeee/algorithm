package twopointers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2003 {
    static int [] map;
    static int N,M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; ++i) map[i] = Integer.parseInt(st.nextToken());

        int res = 0;
        int e = 0;
        int sum = map[0];
        for(int s = 0; s < N; ++s)
        {
            while(e < N && sum < M)
            {
                e++;
                if(e != N) sum += map[e];
            }
            if(e == N) break;
            if(sum == M) res++;
            sum -= map[s];
        }
        System.out.print(res);
    }

}
