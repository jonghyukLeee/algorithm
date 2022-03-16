package twopointers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q2230 {
    static int N,M;
    static int minVal = Integer.MAX_VALUE;
    static int [] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N];

        for(int i = 0; i < N; ++i) map[i] = Integer.parseInt(br.readLine());

        Arrays.sort(map);
        solution();
        System.out.print(minVal);
    }
    static void solution()
    {
        int e = 0;
        for(int s = 0; s < N; ++s)
        {
            while(e < N && (map[e] - map[s]) < M) e++;
            if(e == N) break;
            minVal = Math.min(minVal,map[e] - map[s]);
        }
    }
}
