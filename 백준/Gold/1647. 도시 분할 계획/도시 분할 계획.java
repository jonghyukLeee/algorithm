import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

class Home implements Comparable<Home>{
    int s, e;
    int cost;

    public Home(int s, int e, int cost) {
        this.s = s;
        this.e = e;
        this.cost = cost;
    }
    @Override
    public int compareTo(Home h) {
        return this.cost - h.cost;
    }
}
public class Main {
    static int N, M;
    static List<Home> map;
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new ArrayList<>();

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            map.add(new Home(s, e, w));
        }
        Collections.sort(map);

        int sum = 0;
        int count = 0;
        int max = Integer.MIN_VALUE;
        parent = new int[N + 1];
        for(int i = 1; i <= N; i++) parent[i] = i;

        for(Home next: map) {
            if(union(next.s, next.e)) {
                sum += next.cost;
                max = Math.max(max, next.cost);
                count++;
                if(count == N - 1) break;
            }
        }

        System.out.print(sum - max);
    }

    static boolean union(int a, int b) {
        int pa = find(a);
        int pb = find(b);

        if(pa != pb) {
            parent[pb] = pa;
            return true;
        }
        return false;
    }

    static int find(int n) {
        if(parent[n] == n) return n;
        return parent[n] = find(parent[n]);
    }
}
