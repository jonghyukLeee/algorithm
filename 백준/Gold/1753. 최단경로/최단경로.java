import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Edge {
    int v, weight;

    public Edge(int v, int weight) {
        this.v = v;
        this.weight = weight;
    }
}
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        List<Edge>[] list = new ArrayList[v + 1];
        boolean[] isVisited = new boolean[v + 1];
        int[] answer = new int[v + 1];
        for (int i = 1; i <= v; i++) {
            list[i] = new ArrayList<>();
            answer[i] = Integer.MAX_VALUE;
        }

        int start = Integer.parseInt(br.readLine());

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            list[from].add(new Edge(to, weight));
        }

        PriorityQueue<Edge> q = new PriorityQueue<>(new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return o1.weight - o2.weight;
            }
        });
        answer[start] = 0;
        q.add(new Edge(start, 0));

        while (!q.isEmpty()) {
            Edge current = q.poll();

            if (!isVisited[current.v]) {
                isVisited[current.v] = true;

                for (Edge next: list[current.v]) {
                    int sum = current.weight + next.weight;
                    if (answer[next.v] > sum) {
                        answer[next.v] = sum;
                        q.add(new Edge(next.v, sum));
                    }
                }
            }

        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= v; i++) sb.append(answer[i] < Integer.MAX_VALUE ? answer[i] : "INF").append("\n");

        sb.deleteCharAt(sb.length() - 1);
        System.out.print(sb);
    }
}
