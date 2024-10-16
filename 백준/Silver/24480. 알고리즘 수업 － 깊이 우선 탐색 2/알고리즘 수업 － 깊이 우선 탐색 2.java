import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M, R;
    static List<PriorityQueue<Integer>> map;
    static boolean[] isVisited;
    static int[] answer;
    static int count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        map = new ArrayList<>();
        isVisited = new boolean[N + 1];
        answer = new int[N + 1];

        for (int i = 0; i <= N; i++) map.add(new PriorityQueue<>(Collections.reverseOrder()));

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int fst = Integer.parseInt(st.nextToken());
            int sec = Integer.parseInt(st.nextToken());

            map.get(fst).add(sec);
            map.get(sec).add(fst);
        }

        isVisited[R] = true;
        count = 1;
        dfs(R);

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            sb.append(answer[i]).append("\n");
        }

        sb.deleteCharAt(sb.length() - 1);

        System.out.print(sb);
    }

    static void dfs(int n) {
        PriorityQueue<Integer> q = map.get(n);
        answer[n] = count++;

        while (!q.isEmpty()) {
            int cur = q.poll();
            if (!isVisited[cur]) {
                isVisited[cur] = true;
                dfs(cur);
            }
        }
    }
}
