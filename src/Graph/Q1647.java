package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Load {
    int end;
    int weight;

    public Load(int end, int weight) {
        this.end = end;
        this.weight = weight;
    }
}
public class Q1647 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<List<Load>> map = new ArrayList<>();
        for (int i = 0; i <= N; i++) map.add(new ArrayList<>());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            map.get(A).add(new Load(B, C));
            map.get(B).add(new Load(A, C));
        }

        boolean [] isVisited = new boolean[N + 1];
        // 시작은 1
        Queue<Integer> resultQ = new PriorityQueue<>(Collections.reverseOrder());

        Queue<Load> q = new PriorityQueue<>((o1, o2) -> o1.weight - o2.weight);
        q.add(new Load(1, 0));

        //Prim
        while (!q.isEmpty()) {
            Load cur = q.poll();

            if (isVisited[cur.end]) continue;
            isVisited[cur.end] = true;
            resultQ.add(cur.weight);

            for (Load next : map.get(cur.end)) {
                if (!isVisited[next.end]) q.add(next);
            }
        }

        // 가장 큰 간선 제거 (마을 분리)
        resultQ.poll();

        int answer = 0;
        while (!resultQ.isEmpty()) answer += resultQ.poll();

        System.out.print(answer);
    }
}
