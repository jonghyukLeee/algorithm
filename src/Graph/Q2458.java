package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2458 {
    static boolean [][] students;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        students = new boolean[n+1][n+1];

        for(int i = 0; i < m; ++i)
        {
            st = new StringTokenizer(br.readLine());
            int fst = Integer.parseInt(st.nextToken());
            int sec = Integer.parseInt(st.nextToken());

            students[fst][sec] = true;
        }

        for(int i = 1; i <= n; ++i) // 거쳐가는 경로
        {
            for(int j = 1; j <= n; ++j) // 출발지점
            {
                for(int k = 1; k <= n; ++k) //도착지점
                {
                    if(i == j || j == k || i == k) continue;
                    if(!students[j][k])
                    {
                        // j -> k로 이동하는경로와  j -> i -> k로 i를 경유해 가는 경로를 비교하여 값을 업데이트.
                        if(students[j][i] && students[i][k]) students[j][k] = true;
                    }
                }
            }
        }
        int answer = 0;
        loop : for(int i = 1; i <= n; ++i)
        {
            for(int j = 1; j <=n; ++j)
            {
                if(i == j) continue;
                if(!(students[i][j] || students[j][i])) continue loop;
            }
            answer++;
        }
        System.out.print(answer);
    }
}
