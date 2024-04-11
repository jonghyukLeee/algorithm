import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Node11438 {
    int n, depth;

    public Node11438(int n, int depth) {
        this.n = n;
        this.depth = depth;
    }
}
public class Main {
    static int N, M;
    static List<Integer>[] map;
    static boolean[] isVisited;
    static int[] depth;
    static int[][] parent;
    static int maxK;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new ArrayList[N + 1];
        isVisited = new boolean[N + 1];
        depth = new int[N + 1];

        for (int i = 1; i <= N; i++) map[i] = new ArrayList<>();

        int tmpN = 1;
        while (tmpN <= N) {
            tmpN *= 2;
            maxK++;
        }

        parent = new int[maxK + 1][N + 1];

        StringTokenizer st;
        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            map[a].add(b);
            map[b].add(a);
        }

        bfs(1);

        for (int k = 1; k <= maxK; k++) {
            for (int n = 1; n <= N; n++) {
                parent[k][n] = parent[k - 1][parent[k - 1][n]];
            }
        }

        StringBuilder sb = new StringBuilder();
        M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            sb.append(lca(a, b)).append("\n");
        }

        sb.deleteCharAt(sb.length() - 1);
        System.out.print(sb);
    }

    static void bfs(int root) {
        Queue<Node11438> q = new LinkedList<>();
        q.add(new Node11438(root, 1));
        depth[root] = 1;

        while (!q.isEmpty()) {
            Node11438 current = q.poll();

            if (!isVisited[current.n]) {
                isVisited[current.n] = true;

                for (int next: map[current.n]) {
                    if (!isVisited[next]) {
                        q.add(new Node11438(next, current.depth + 1));
                        depth[next] = current.depth + 1;
                        parent[0][next] = current.n;
                    }
                }
            }
        }
    }

    static int lca(int a, int b) {
        if (depth[a] > depth[b]) {
            int tmp = a;
            a = b;
            b = tmp;
        }

        for (int k = maxK; k >= 0; k--) {
            if (Math.pow(2, k) <= depth[b] - depth[a]) {
                if (depth[parent[k][b]] >= depth[a]) {
                    b = parent[k][b];
                }
            }
        }

        for (int k = maxK; k >= 0; k--) {
            if (parent[k][a] != parent[k][b]) {
                a = parent[k][a];
                b = parent[k][b];
            }
        }

        return a == b ? a : parent[0][a];
    }
}
