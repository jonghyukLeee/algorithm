package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q10164 {
    static int [][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        map = new int[N + 1][M + 1];

        map[0][1] = 1;

        int cnt = 0;
        boolean isCircle = false;
        int x = 0, y = 0;
        loop : for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                cnt++;
                map[i][j] = map[i - 1][j] + map[i][j - 1];
                if (cnt == K) {
                    isCircle = true;
                    x = i;
                    y = j;
                    break loop;
                }
            }
        }

        // 원이 존재한다면
        if (isCircle) {
            for (int i = x; i <= N; i++) {
                for (int j = y; j <= M; j++) {
                    if ((i - 1) >= x) map[i][j] += map[i - 1][j];
                    if ((j - 1) >= y) map[i][j] += map[i][j - 1];
                }
            }
        }
        System.out.print(map[N][M]);
    }
}
