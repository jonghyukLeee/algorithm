import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int[] parent;
    static boolean[] isVisited;
    static List<Integer>[] list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        list = new ArrayList[n + 1];
        parent = new int[n + 1];
        isVisited = new boolean[n + 1];
        for (int i = 1; i <= n; i++) list[i] = new ArrayList<>();

        StringTokenizer st;
        for (int i = 1; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());

            list[first].add(second);
            list[second].add(first);
        }

        dfs(1);
        StringBuilder sb = new StringBuilder();
        for (int i = 2; i <= n; i++) {
            sb.append(parent[i]).append("\n");
        }

        sb.deleteCharAt(sb.length() - 1);
        System.out.print(sb);
    }
    static void dfs(int node) {
        isVisited[node] = true;

        for (int next: list[node]) {
            if (!isVisited[next]) {
                parent[next] = node;
                dfs(next);
            }
        }
    }
}
