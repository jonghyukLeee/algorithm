import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Party implements Comparable<Party> {
    int target;
    int weight;

    Party(int target, int weight) {
        this.target = target;
        this.weight = weight;
    }

    @Override
    public int compareTo(Party o) {
        return this.weight - o.weight;
    }
}
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        List<List<Party>> origin =  new ArrayList<>();
        List<List<Party>> reverse =  new ArrayList<>();

        for(int i = 0; i <= n; i++) {
            origin.add(new ArrayList<>());
            reverse.add(new ArrayList<>());
        }

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s =  Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            origin.get(s).add(new Party(e, w));
            reverse.get(e).add(new Party(s, w));
        }

        int[] come = new int[n + 1];
        int[] go = new int[n + 1];
        Arrays.fill(come, Integer.MAX_VALUE);
        Arrays.fill(go, Integer.MAX_VALUE);

        dijkstra(x, come, origin);
        dijkstra(x, go, reverse);

        int max = Integer.MIN_VALUE;
        for(int i = 1; i <= n; i++) {
            max = Math.max(max, come[i] + go[i]);
        }

        System.out.print(max);
    }

    static void dijkstra(int x, int[] result, List<List<Party>> targetArr) {
        PriorityQueue<Party> pq = new PriorityQueue<>();
        result[x] = 0;
        pq.add(new Party(x, 0));
        while(!pq.isEmpty()) {
            Party cur = pq.poll();

            if(result[cur.target] < cur.weight) continue;

            for(Party next: targetArr.get(cur.target)) {
                if(result[next.target] > result[cur.target] + next.weight) {
                    result[next.target] = result[cur.target] + next.weight;
                    pq.add(new Party(next.target, result[next.target]));
                }
            }
        }
    }
}
