package Prefix_sum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q11659 {
    static int [] map;
    static int [] prefix_sum;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        map = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; ++i)
        {
            map[i] = Integer.parseInt(st.nextToken());
        }
        prefix_sum = new int[n+1];
        prefix_sum[0] = 0;
        prefix_sum[1] = map[0];
        for(int i = 2; i < prefix_sum.length; ++i) prefix_sum[i] = map[i-1] + prefix_sum[i-1];

        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < m; ++i)
        {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            sb.append(prefix_sum[end] - prefix_sum[start-1]).append("\n");
        }
        System.out.print(sb.toString());
    }
}
