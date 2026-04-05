import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Prim implements Comparable<Prim>{
    int target;
    int weight;

    public Prim(int target, int weight) {
        this.target = target;
        this.weight = weight;
    }

    @Override
    public int compareTo(Prim p) {
        return this.weight - p.weight;
    }
}
public class Main {
    static int V, E;
    static List<List<Prim>> map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        map = new ArrayList<>();
        for(int i = 0; i <= V; i++) map.add(new ArrayList<>());
        PriorityQueue<Prim> pq = new PriorityQueue<>();
        for(int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            map.get(s).add(new Prim(e, w));
            map.get(e).add(new Prim(s, w));
        }

        boolean[] isDone = new boolean[V + 1];
        pq.add(new Prim(1, 0));
        int count = 0;
        int weight = 0;
        while(!pq.isEmpty()) {
            Prim cur = pq.poll();

            if(isDone[cur.target]) continue;
            count++;
            isDone[cur.target] = true;
            weight += cur.weight;
            if(count == V) break;

            for(Prim next: map.get(cur.target)) {
                if(!isDone[next.target]) pq.add(next);
            }
        }

        System.out.print(weight);
    }
}
