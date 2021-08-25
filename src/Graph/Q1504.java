package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Edge implements Comparable<Edge>
{
    int n, weight;

    public Edge(int n , int weight)
    {
        this.n = n;
        this.weight = weight;
    }
    @Override
    public int compareTo(Edge o)
    {
        return this.weight - o.weight;
    }
}
public class Q1504 {
    static final int INF = 200000000;
    static ArrayList<ArrayList<Edge>> map;
    static PriorityQueue<Edge> pq;
    static int n,e;
    static int [] dist;
    static boolean [] isVis;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        map = new ArrayList<>();

        for(int i = 0; i <= n; ++i) map.add(new ArrayList<>());

        for(int i = 0; i < e; ++i)
        {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            map.get(start).add(new Edge(end,weight));
            map.get(end).add(new Edge(start,weight));
        }

        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        pq = new PriorityQueue<>();
        int tmp = 0;

        tmp += dijkstra(1,v1);
        tmp += dijkstra(v1,v2);
        tmp += dijkstra(v2,n);
        int answer = tmp;

        tmp = 0;
        tmp += dijkstra(1,v2);
        tmp += dijkstra(v2,v1);
        tmp += dijkstra(v1,n);

        answer = Math.min(answer,tmp);

        if(answer >= INF) System.out.print("-1");
        else System.out.print(answer);
    }
    static int dijkstra(int start,int end)
    {
        dist = new int[n+1];
        Arrays.fill(dist,INF);
        dist[start] = 0;
        isVis = new boolean[n+1];
        pq.add(new Edge(start,0));

        while(!pq.isEmpty())
        {
            Edge cur = pq.poll();
            if(isVis[cur.n]) continue;
            isVis[cur.n] = true;

            for(Edge tmp : map.get(cur.n))
            {
                if(isVis[tmp.n]) continue;
                if(dist[tmp.n] > dist[cur.n] + tmp.weight)
                {
                    dist[tmp.n] = dist[cur.n] + tmp.weight;
                    pq.add(new Edge(tmp.n,dist[tmp.n]));
                }
            }
        }
        return dist[end];
    }
}
