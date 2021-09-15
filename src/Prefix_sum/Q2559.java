package Prefix_sum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2559 {
    static int [] map;
    static int [] prefix_sum;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        map = new int[n];
        prefix_sum = new int[n+1];
        prefix_sum[0] = 0;

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; ++i)
        {
            map[i] = Integer.parseInt(st.nextToken());
            prefix_sum[i+1] = prefix_sum[i] + map[i];
        }

        int max = Integer.MIN_VALUE;
        for(int i = k; i <= n; ++i)
        {
            int tmp = prefix_sum[i] - prefix_sum[i-k];
            if(tmp > max)
            {
                max = tmp;
            }
        }
        System.out.print(max);
    }
}
