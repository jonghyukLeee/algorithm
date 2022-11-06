package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1149 {
    static int [][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        map = new int[n][3];

        for(int i = 0; i < n; ++i)
        {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 3; ++j)
            {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
            if(i > 0)
            {
                map[i][0] += Math.min(map[i-1][1],map[i-1][2]);
                map[i][1] += Math.min(map[i-1][0],map[i-1][2]);
                map[i][2] += Math.min(map[i-1][0],map[i-1][1]);
            }
        }
        System.out.print(Math.min(Math.min(map[n-1][0],map[n-1][1]),map[n-1][2]));
    }
}
