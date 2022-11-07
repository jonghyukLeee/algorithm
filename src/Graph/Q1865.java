package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

class Edge2 {
    int end;
    int weight;

    public Edge2(int end, int weight) {
        this.end = end;
        this.weight = weight;
    }
}
public class Q1865 {
    static int INF = 987654321;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (TC-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());

            // 도로
            List<List<Edge2>> map = new ArrayList<>();
            for (int i = 0; i <= N; i++) map.add(new ArrayList<>());

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                int weight = Integer.parseInt(st.nextToken());

                // 도로는 양방향
                map.get(start).add(new Edge2(end, weight));
                map.get(end).add(new Edge2(start, weight));
            }

            // 웜홀
            for (int i = 0; i < W; i++) {
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                int weight = Integer.parseInt(st.nextToken());

                map.get(start).add(new Edge2(end, -weight));
            }

            int [] dist = new int[N + 1];
            Arrays.fill(dist, INF);
            dist[1] = 0;
            sb.append(bellmanFord(N, map, dist)).append("\n");
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.print(sb);
    }
    static String bellmanFord(int n, List<List<Edge2>> map, int [] dist) {
        for (int i = 0; i <= n; i++) {
            boolean isUpdated = false;
            for (int j = 1; j <= n; j++) {
                for (Edge2 e : map.get(j)) {
                    int tmp = dist[j] + e.weight;
                    if (dist[e.end] > tmp) {
                        if (i == n) {
                            return "YES";
                        }
                        dist[e.end] = tmp;
                        isUpdated = true;
                    }
                }
            }
            if (!isUpdated) break;
        }

        return "NO";
    }
}
