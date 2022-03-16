package twopointers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1806 {
    static int N,S;
    static int [] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        map = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; ++i) map[i] = Integer.parseInt(st.nextToken());

        int minLen = Integer.MAX_VALUE;
        int sum = map[0];
        int e = 0;
        for(int s = 0; s < N; ++s)
        {
            while(e < N && sum < S)
            {
                e++;
                if(e != N) sum += map[e];
            }
            if(e == N) break;
            minLen = Math.min(minLen,e-s+1);
            sum -= map[s];
        }
        System.out.print(minLen == Integer.MAX_VALUE ? 0 : minLen);
    }
}
