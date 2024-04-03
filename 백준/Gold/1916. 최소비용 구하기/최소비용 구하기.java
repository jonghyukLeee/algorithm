import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.*;

class Bus {
    int destination, cost;

    public Bus(int destination, int cost) {
        this.destination = destination;
        this.cost = cost;
    }
}
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        List<Bus>[] list = new ArrayList[n + 1];
        int[] answer = new int[n + 1];
        boolean[] isVisited = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
            answer[i] = Integer.MAX_VALUE;
        }

        StringTokenizer st;
        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            list[from].add(new Bus(to, cost));
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        answer[start] = 0;

        PriorityQueue<Bus> pq = new PriorityQueue<>(new Comparator<Bus>() {
            @Override
            public int compare(Bus o1, Bus o2) {
                return o1.cost - o2.cost;
            }
        });

        pq.add(new Bus(start, 0));

        while (!pq.isEmpty()) {
            Bus current = pq.poll();

            if (!isVisited[current.destination]) {
                isVisited[current.destination] = true;
                for (Bus next: list[current.destination]) {
                    int sum = current.cost + next.cost;

                    if (answer[next.destination] > sum) {
                        answer[next.destination] = sum;
                        pq.add(new Bus(next.destination, sum));
                    }
                }
            }
        }

        System.out.print(answer[end]);
    }
}
