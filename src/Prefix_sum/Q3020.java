package Prefix_sum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q3020 {
    static int [] bottom,top;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        bottom = new int[h+1];
        top = new int[h+1];

        for(int i = 0; i < n; ++i)
        {
            int height = Integer.parseInt(br.readLine());

            if(i % 2 == 0) bottom[height]++;
            else top[height]++;
        }

        for(int i = h-1; i > 0; --i)
        {
            bottom[i] += bottom[i+1];
            top[i] += top[i+1];
        }

        Arrays.sort(bottom);
        Arrays.sort(top);

        System.out.print(Math.max(bottom[h],top[h]));
    }
}
