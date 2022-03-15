package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Q1010 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        List<Double> answer = new ArrayList<>();

        while(t-- > 0)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            if(m < n)
            {
                answer.add(0.0);
                continue;
            }

            double top = 1;
            for(int i = m; i > m-n; --i)
            {
                top *= i;
            }
            double bottom = 1;
            for(int i = n; i > 1; --i)
            {
                bottom *= i;
            }

            answer.add(top/bottom);
        }
        for(double d : answer)
        {
            System.out.printf("%.0f\n",d);
        }
    }

}
