package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

class Vertex {
    int start, end;
    int weight;

    public Vertex(int start, int end, int weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }
}
public class Q11657 {
    static List<Vertex> vertexes;
    static long INF = Long.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        vertexes = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            vertexes.add(new Vertex(start, end, weight));
        }

        long [] dist = new long[N + 1];
        Arrays.fill(dist, INF);
        dist[1] = 0;
        for (int i = 0; i <= N; i++) {
            for (Vertex v : vertexes) {
                if (dist[v.start] == INF) continue;

                long tmp = dist[v.start] + v.weight;
                if (dist[v.end] > tmp) {
                    if (i == N) {
                        System.out.print("-1");
                        System.exit(0);
                    }
                    dist[v.end] = tmp;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 2; i <= N; i++) {
            sb.append(dist[i] == INF ? "-1" : dist[i]).append("\n");
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.print(sb);
    }
}
