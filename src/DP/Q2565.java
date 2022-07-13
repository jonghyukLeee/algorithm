package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Cable
{
    int start,end;

    public Cable(int start, int end) {
        this.start = start;
        this.end = end;
    }
}
public class Q2565 {
    static int N;
    static Cable [] cables;
    static int [] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        StringTokenizer st;
        cables = new Cable[N];
        dp = new int[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());

            cables[i] = new Cable(l,r);
        }

        //좌측값 기준으로 정렬
        Arrays.sort(cables, (c1, c2) -> c1.start - c2.start);

        int max = 0;
        for (int i = 0; i < N; i++) {
            max = Math.max(max, solution(i));
        }

        System.out.print(N - max);
    }
    static int solution(int n) {
        if (dp[n] < 1) {
            dp[n] = 1;

            for (int i = n + 1; i < N; i++) {
                if (cables[n].end < cables[i].end) {
                    dp[n] = Math.max(dp[n], solution(i) + 1);
                }
            }
        }

        return dp[n];
    }
}
