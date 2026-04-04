import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Edge implements Comparable<Edge>{
    int target;
    int weight;

    Edge(int target, int weight) {
        this.target = target;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge e) {
        return this.weight - e.weight;
    }
}
public class Main {
    static int N;
    static List<List<Edge>> map;
    static int INF = 200_000_000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        map = new ArrayList<>();
        for (int i = 0; i <= N; i++) map.add(new ArrayList<>());

        for(int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            map.get(a).add(new Edge(b, c));
            map.get(b).add(new Edge(a, c));
        }

        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        int[] fromStart = dijkstra(1);
        int[] fromV1 = dijkstra(v1);
        int[] fromV2 = dijkstra(v2);
        int answer = Math.min(fromStart[v1] + fromV1[v2] + fromV2[N], fromStart[v2] + fromV2[v1] + fromV1[N]);
        System.out.print(answer >= INF ? -1 : answer);
    }
    static int[] dijkstra(int n) {
        int[] dist = new int[N + 1];
        Arrays.fill(dist, INF);
        dist[n] = 0;

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(n, 0));

        while(!pq.isEmpty()) {
            Edge cur = pq.poll();

            if(dist[cur.target] < cur.weight) continue;

            for(Edge next: map.get(cur.target)) {
                if(dist[next.target] > dist[cur.target] + next.weight) {
                    dist[next.target] = dist[cur.target] + next.weight;
                    pq.add(new Edge(next.target, dist[next.target]));
                }
            }
        }

        return dist;
    }
}
