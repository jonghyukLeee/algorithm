import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

class Node {
    int target, dist;

    public Node(int target, int dist) {
        this.target = target;
        this.dist = dist;
    }
}
public class Main {
    static int V;
    static List<List<Node>> map;
    static Node maxNode;
    static boolean[] isVisited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        V = Integer.parseInt(br.readLine());

        map = new ArrayList<>();
        for (int i = 0; i <= V; i++) map.add(new ArrayList<>());

        StringTokenizer st;
        for (int i = 0; i < V; i++) {
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());

            while (st.hasMoreTokens()) {
                int target = Integer.parseInt(st.nextToken());
                if (target < 0) break;

                int dist = Integer.parseInt(st.nextToken());

                map.get(v).add(new Node(target, dist));
            }
        }

        isVisited = new boolean[V + 1];
        maxNode = new Node(1, Integer.MIN_VALUE);
        dfs(1, 0);

        Arrays.fill(isVisited, false);
        dfs(maxNode.target, 0);

        System.out.print(maxNode.dist);
    }
    static void dfs(int v, int dist) {
        isVisited[v] = true;
        if (dist > maxNode.dist) {
            maxNode = new Node(v, dist);
        }
        for (Node next: map.get(v)) {
            if (!isVisited[next.target]) {
                dfs(next.target, dist + next.dist);
            }
        }
    }
}
