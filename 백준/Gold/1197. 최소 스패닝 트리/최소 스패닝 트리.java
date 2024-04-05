import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node {
    int n, weight;

    public Node(int n, int weight) {
        this.n = n;
        this.weight = weight;
    }
}
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        List<Node>[] map = new ArrayList[v + 1];
        for (int i = 1; i <= v; i++) map[i] = new ArrayList<>();

        for (int i = 0 ; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            map[from].add(new Node(to, weight));
            map[to].add(new Node(from, weight));
        }

        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> {
            return o1.weight - o2.weight;
        });

        pq.add(new Node(1, 0));
        boolean[] isVisited = new boolean[v + 1];
        int answer = 0;

        while (!pq.isEmpty()) {
            Node current = pq.poll();

            if (!isVisited[current.n]) {
                isVisited[current.n] = true;
                answer += current.weight;

                for (Node next: map[current.n]) {
                    if (!isVisited[next.n]) {
                        pq.add(next);
                    }
                }
            }
        }

        System.out.print(answer);
    }
}
