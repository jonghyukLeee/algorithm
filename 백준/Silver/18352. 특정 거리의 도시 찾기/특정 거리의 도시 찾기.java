import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class City {
    int node, dist;

    public City(int node, int dist) {
        this.node = node;
        this.dist = dist;
    }
}
public class Main {
    static int N, M, K, X;
    static List<List<Integer>> map;
    static int[] minDistance;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        map = new ArrayList<>();
        for (int i = 0; i <= N; i++) map.add(new ArrayList<>());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            map.get(start).add(end);
        }

        minDistance = new int[N + 1];
        Arrays.fill(minDistance, Integer.MAX_VALUE);

        Queue<City> q = new LinkedList<>();
        q.add(new City(X, 0));

        while (!q.isEmpty()) {
            City current = q.poll();
            int moveCount = current.dist + 1;

            for (int next: map.get(current.node)) {
                if (moveCount < minDistance[next]) {
                    minDistance[next] = moveCount;
                    q.add(new City(next, moveCount));
                }
            }
        }

        minDistance[X] = 0;

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            if (minDistance[i] == K) sb.append(i).append("\n");
        }

        if (sb.length() == 0) {
            sb.append("-1");
        } else {
            sb.deleteCharAt(sb.length() - 1);
        }

        System.out.print(sb);
    }
}
