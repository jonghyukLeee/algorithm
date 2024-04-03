import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Edge1854 {
    int destination, weight;

    public Edge1854(int destination, int weight) {
        this.destination = destination;
        this.weight = weight;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        List<Edge1854>[] list = new ArrayList[n + 1];
        PriorityQueue<Integer>[] answerArray = new PriorityQueue[n + 1];

        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
            answerArray[i] = new PriorityQueue<>(Collections.reverseOrder());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            list[from].add(new Edge1854(to, weight));
        }

        PriorityQueue<Edge1854> pq = new PriorityQueue<>(new Comparator<Edge1854>() {
            @Override
            public int compare(Edge1854 o1, Edge1854 o2) {
                return o1.weight - o2.weight;
            }
        });
        pq.add(new Edge1854(1, 0));
        answerArray[1].add(0);

        while (!pq.isEmpty()) {
            Edge1854 current = pq.poll();

            for (Edge1854 next : list[current.destination]) {
                int sum = current.weight + next.weight;
                PriorityQueue<Integer> answerQ = answerArray[next.destination];
                if (answerQ.size() < k) {
                    answerQ.add(sum);
                    pq.add(new Edge1854(next.destination, sum));
                } else if (answerQ.peek() > sum) {
                    answerQ.poll();
                    answerQ.add(sum);
                    pq.add(new Edge1854(next.destination, sum));
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            int result = -1;
            if (answerArray[i].size() >= k) {
                result = answerArray[i].poll();
            }
            sb.append(result).append("\n");
        }

        sb.deleteCharAt(sb.length() - 1);
        System.out.print(sb);
    }
}
