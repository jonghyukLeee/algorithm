import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int[] group;
    static boolean[] isVisited;
    static boolean isDone;
    static List<Integer>[] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            isDone = false;
            group = new int[v + 1];
            isVisited = new boolean[v + 1];
            map = new ArrayList[v + 1];
            for (int i = 1; i <= v; i++) map[i] = new ArrayList<>();

            for (int i = 0; i < e; i++) {
                st = new StringTokenizer(br.readLine());
                int v1 = Integer.parseInt(st.nextToken());
                int v2 = Integer.parseInt(st.nextToken());

                map[v1].add(v2);
                map[v2].add(v1);
            }

            for (int i = 1; i <= v; i++) {
                if (isDone) break;
                else {
                    dfs(i);
                }
            }

            sb.append(isDone ? "NO" : "YES").append("\n");
        }
        sb.deleteCharAt(sb.length() - 1);

        System.out.print(sb);
    }
    static void dfs(int node) {
        if (isDone) return;

        isVisited[node] = true;
        for (int next: map[node]) {
            if (!isVisited[next]) {
                group[next] = group[node] ^ 1;
                dfs(next);
            } else if (group[next] == group[node]) {
                isDone = true;
                break;
            }
        }
    }
}
