import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

class Edge11657 {
    int from, to, weight;

    public Edge11657(int from, int to, int weight) {
        this.from = from;
        this.to = to;
        this.weight = weight;
    }
}
public class Main {
    static long INF = Long.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<Edge11657> list = new ArrayList<>();
        long[] distance = new long[n + 1];
        Arrays.fill(distance, INF);
        distance[1] = 0;

        for (int i = 0; i < m ; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            list.add(new Edge11657(from, to, weight));
        }

        for (int i = 0; i < n - 1; i++) {
            for (Edge11657 edge: list) {
                long sum = distance[edge.from] + edge.weight;
                if ((distance[edge.from] < INF) && distance[edge.to] > sum) {
                    distance[edge.to] = sum;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        boolean isCycle = false;
        for (Edge11657 edge: list) {
            if ((distance[edge.from] < INF) && distance[edge.to] > distance[edge.from] + edge.weight) {
                isCycle = true;
                sb.append("-1").append("\n");
                break;
            }
        }

        if (!isCycle) {
            for (int i = 2; i <= n; i++) {
                sb.append(distance[i] != INF ? distance[i] : "-1").append("\n");
            }
        }

        sb.deleteCharAt(sb.length() - 1);
        System.out.print(sb);
    }
}
