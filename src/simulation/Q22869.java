package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q22869 {
    static int N, K;
    static int [] stones;
    static boolean [] isVisited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        stones = new int[N];
        isVisited = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            stones[i] = Integer.parseInt(st.nextToken());
        }

        isVisited[0] = true;
        find(0);
        System.out.print("NO");
    }
    static void find(int idx) {
        if (isVisited[N - 1]) {
            System.out.print("YES");
            System.exit(0);
        }

        for (int i = N - 1; i > idx; i--) {
            if (!isVisited[i]) {
                int tmp = (i - idx) * (1 + Math.abs(stones[i] - stones[idx]));

                if (tmp <= K) {
                    isVisited[i] = true;
                    find(i);
                }
            }
        }
    }
}
