import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

class Node1414 {
    int to, weight;

    public Node1414(int to, int weight) {
        this.to = to;
        this.weight = weight;
    }
}
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Node1414>[] list = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) list[i] = new ArrayList<>();

        int total = 0;
        for (int i = 1; i <= n; i++) {
            String input = br.readLine();

            for (int j = 1; j <= n; j++) {
                char nextChar = input.charAt(j - 1);
                int length = toNumber(nextChar);
                total += length;
                if (i != j && length > 0) {
                    list[i].add(new Node1414(j, length));
                    list[j].add(new Node1414(i, length));
                }
            }
        }


        int connectedLength = 0;
        int connectedCount = 0;
        boolean[] isVisited = new boolean[n + 1];
        PriorityQueue<Node1414> pq = new PriorityQueue<>((o1, o2) -> {
            return o1.weight - o2.weight;
        });
        pq.add(new Node1414(1, 0));

        while (!pq.isEmpty()) {
            Node1414 current = pq.poll();

            if (!isVisited[current.to]) {
                isVisited[current.to] = true;
                connectedLength += current.weight;
                connectedCount++;

                for (Node1414 next: list[current.to]) {
                    if (!isVisited[next.to]) {
                        pq.add(next);
                    }
                }
            }
        }

        System.out.print(connectedCount == n ? total - connectedLength : -1);
    }
    static int toNumber(char c) {
        if (c == '0') {
            return 0;
        } else if (c >= 97) {
            return c - 'a' + 1;
        } else {
            return c - 'A' + 27;
        }
    }
}
