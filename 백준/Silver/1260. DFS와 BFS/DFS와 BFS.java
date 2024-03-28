import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M, V;
    static List<List<Integer>> map;
    static boolean[] isVisited;
    static StringBuilder answerBuilder;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        map = new ArrayList<>();
        for (int i = 0; i <= N; i++) map.add(new ArrayList<>());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());

            map.get(v1).add(v2);
            map.get(v2).add(v1);
        }

        for (List<Integer> list: map) {
            if (list.size() > 1) {
                Collections.sort(list);
            }
        }

        answerBuilder = new StringBuilder();
        isVisited = new boolean[N + 1];
        isVisited[V] = true;
        answerBuilder.append(V);
        dfs(V);
        answerBuilder.append("\n");

        isVisited = new boolean[N + 1];
        answerBuilder.append(V);
        bfs(V);

        System.out.print(answerBuilder);
    }

    static void dfs(int v) {
        for (int next: map.get(v)) {
            if (!isVisited[next]) {
                isVisited[next] = true;
                answerBuilder.append(" ").append(next);
                dfs(next);
            }
        }
    }

    static void bfs(int v) {
        Queue<Integer> q = new LinkedList<>();

        q.add(v);
        isVisited[v] = true;

        while (!q.isEmpty()) {
            int current = q.poll();

            for (int next: map.get(current)) {
                if (!isVisited[next]) {
                    isVisited[next] = true;
                    answerBuilder.append(" ").append(next);
                    q.add(next);
                }
            }
        }
    }
}
