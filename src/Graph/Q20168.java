package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Cost
{
    int n;
    long cost,max;

    public Cost(int n, long cost) {
        this.n = n;
        this.cost = cost;
    }

    public Cost(int n, long cost, long max) {
        this.n = n;
        this.cost = cost;
        this.max = max;
    }
}
public class Q20168 {
    static int N,M,A,B,C;
    static List<List<Cost>> map;
    static long [] min;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new ArrayList<>();
        min = new long[N+1];
        Arrays.fill(min,Long.MAX_VALUE);

        for(int i = 0; i <= N; ++i) map.add(new ArrayList<>());
        for(int i = 0; i < M; ++i)
        {
            st = new StringTokenizer(br.readLine());
            int fst = Integer.parseInt(st.nextToken());
            int sec = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            map.get(fst).add(new Cost(sec,cost));
            map.get(sec).add(new Cost(fst,cost));
        }

        PriorityQueue<Cost> pq = new PriorityQueue<>(new Comparator<Cost>()
        {
            @Override
            public int compare(Cost o1, Cost o2)
            {
                if(o1.cost > o2.cost) return 1;
                if(o1.cost == o2.cost) return 0;
                return -1;
            }
        });

        boolean [] visited = new boolean[N+1];
        pq.add(new Cost(A,0,Long.MIN_VALUE));
        min[A] = 0;

        while(!pq.isEmpty())
        {
            Cost cur = pq.poll();
            if(visited[cur.n]) continue;
            visited[cur.n] = true;

            for(Cost next : map.get(cur.n))
            {
                long totalCost = cur.cost + next.cost;
                if(visited[next.n] || totalCost > C) continue;
                long curMax = cur.max;
                if(curMax < next.cost)
                {
                    curMax = next.cost;
                }
                if(min[next.n] > curMax) min[next.n] = curMax;
                pq.add(new Cost(next.n,totalCost,curMax));
            }
        }
        long answer = min[B] != Long.MAX_VALUE ? min[B] : -1;
        System.out.print(answer);
    }
}
