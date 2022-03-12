package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q12865_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int [] dp = new int[K+1];

        for(int i = 0; i < N; ++i)
        {
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            for(int j = K; j > 0; --j)
            {
                //배낭에 담을 수 있는 무게일경우
                if(j >= w)
                {
                    dp[j] = Math.max(dp[j],dp[j-w]+v);
                }
            }
        }
        System.out.print(dp[K]);
    }
}
