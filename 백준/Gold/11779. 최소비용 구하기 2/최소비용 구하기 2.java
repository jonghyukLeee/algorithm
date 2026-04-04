import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Bus implements Comparable<Bus> {
    int target;
    int weight;

    Bus(int target, int weight) {
        this.target = target;
        this.weight = weight;
    }

    @Override
    public int compareTo(Bus b) {
        return this.weight - b.weight;
    }
}

public class Main {
    static int INF = 1_000_000_001;
    static List<List<Bus>> map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        map = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            map.add(new ArrayList<>());
        }

        int[] dist = new int[n + 1];
        Arrays.fill(dist, INF);

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            map.get(s).add(new Bus(e, w));
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        PriorityQueue<Bus> pq = new PriorityQueue<>();
        dist[s] = 0;
        pq.add(new Bus(s, 0));
        int[] path = new int[n + 1];

        while(!pq.isEmpty()) {
            Bus cur = pq.poll();

            if(dist[cur.target] < cur.weight) continue;

            for(Bus next: map.get(cur.target)) {
                if(dist[next.target] > dist[cur.target] + next.weight) {
                    dist[next.target] = dist[cur.target] + next.weight;
                    path[next.target] = cur.target;
                    pq.add(new Bus(next.target, dist[next.target]));
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        int num = e;
        Stack<Integer> stk = new Stack<>();
        while(true) {
            stk.push(num);
            if(num == s) break;
            num = path[num];
        }
        sb.append(dist[e]).append("\n");
        sb.append(stk.size()).append("\n");
        while(!stk.isEmpty()) {
            sb.append(stk.pop()).append(" ");
        }

        System.out.print(sb.deleteCharAt(sb.length() - 1));
    }
}
