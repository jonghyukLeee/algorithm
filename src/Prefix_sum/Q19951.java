package Prefix_sum;

import java.io.*;
import java.util.StringTokenizer;

public class Q19951 {
    static int [] map;
    static int [] prefix_arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        map = new int[N+2];
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; ++i) map[i] = Integer.parseInt(st.nextToken());

        prefix_arr = new int[N+2];
        for(int i = 0; i < M; ++i)
        {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            prefix_arr[start] += v;
            prefix_arr[end+1] -= v;
        }

        for(int i = 1; i <= N; ++i)
        {
            prefix_arr[i] += prefix_arr[i-1];
            map[i] += prefix_arr[i];
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for(int i = 1; i <= N; ++i) bw.write(map[i]+" ");
        bw.flush();
        bw.close();
    }
}
