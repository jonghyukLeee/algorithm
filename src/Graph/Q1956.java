package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q1956 {
    static int [][] village;
    static final int INF = 4000000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        village = new int[v+1][v+1];

        for(int [] i : village) Arrays.fill(i,INF);

        for(int i = 0; i < e; ++i)
        {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            village[start][end] = weight;
        }


        for(int i = 1; i <= v; ++i)
        {
            for(int j = 1; j <= v; ++j)
            {
                for(int k = 1; k <= v; ++k)
                {
                    if(j == k || i == j || i == k) continue;
                    if(village[j][k] > village[j][i] + village[i][k]) village[j][k] = village[j][i] + village[i][k];

                }
            }
        }

        for(int i = 1; i <=v; ++i)
        {
            for(int j = 1; j <=v; ++j)
            {
                if(i == j) continue;
                if(village[i][i] > village[i][j] + village[j][i]) village[i][i] = village[i][j] + village[j][i];
            }
        }

        int max = Integer.MAX_VALUE;
        for(int i = 1; i <= v; ++i) if(village[i][i] != INF) max = Math.min(max,village[i][i]);

        int answer = -1;
        if(max != Integer.MAX_VALUE) answer = max;
        System.out.print(answer);
    }
}
