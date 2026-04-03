import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Computer implements Comparable<Computer> {
    int target;
    int weight;

    Computer(int target, int weight) {
        this.target = target;
        this.weight = weight;
    }

    @Override
    public int compareTo(Computer o) {
        return this.weight - o.weight;
    }
}
public class Main {
    static int N, M;
    static List<List<Computer>> computers;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        boolean[] isDone = new boolean[N + 1];
        computers = new ArrayList<>();
        for(int i = 0; i <= N; i++) computers.add(new ArrayList<>());

        PriorityQueue<Computer> pq = new PriorityQueue<>();
        pq.add(new Computer(1, 0));
        for(int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            computers.get(s).add(new Computer(e, w));
            computers.get(e).add(new Computer(s, w));
        }

        int answer = 0;
        int count = 0;
        while(!pq.isEmpty()) {
            Computer cur = pq.poll();

            if(isDone[cur.target]) continue;
            isDone[cur.target] = true;
            answer += cur.weight;
            count++;

            if(count == N) break;

            for(Computer next: computers.get(cur.target)) {
                if(!isDone[next.target]) {

                    pq.add(next);
                }
            }
        }

        System.out.print(answer);
    }
}
