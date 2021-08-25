package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Bus
{
    int n, cost;

    public Bus(int n, int cost)
    {
        this.n = n;
        this.cost = cost;
    }
}
public class Q1916 {
    static int sPoint,ePoint;
    static ArrayList<ArrayList<Bus>> cities;
    static int [] dist;
    static boolean [] isVis;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        cities = new ArrayList<>();
        dist = new int[n+1];
        Arrays.fill(dist,Integer.MAX_VALUE);

        for(int i = 0; i <= n; ++i) cities.add(new ArrayList<>());

        int m = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int i = 0; i < m; ++i)
        {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            cities.get(start).add(new Bus(end,cost));
        }

        st = new StringTokenizer(br.readLine());
        sPoint = Integer.parseInt(st.nextToken());
        ePoint = Integer.parseInt(st.nextToken());

        PriorityQueue<Bus> pq = new PriorityQueue<>(new Comparator<Bus>() {
            @Override
            public int compare(Bus o1, Bus o2) {
                return o1.cost - o2.cost;
            }
        });

        pq.add(new Bus(sPoint,0));
        dist[sPoint] = 0;
        isVis = new boolean[n+1];

        while(!pq.isEmpty())
        {
            Bus cur = pq.poll();
            if(isVis[cur.n]) continue;
            isVis[cur.n] = true;

            for(Bus next : cities.get(cur.n))
            {
                if(isVis[next.n]) continue;
                if(dist[next.n] > dist[cur.n] + next.cost)
                {
                    dist[next.n] = dist[cur.n] + next.cost;
                    pq.add(new Bus(next.n,dist[next.n]));
                }
            }
        }

        for(int i : dist) System.out.println(i);
        //System.out.print(dist[ePoint]);
    }
}
