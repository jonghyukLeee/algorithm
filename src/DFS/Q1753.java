package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Weight
{
    int node, weight;

    public Weight(int node, int weight)
    {
        this.node = node;
        this.weight = weight;
    }
}
public class Q1753 {
    static int v,e,startNode;
    static boolean [] isVis;
    static int [] dist;
    static ArrayList<ArrayList<Weight>> map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        startNode = Integer.parseInt(br.readLine());

        dist = new int[v+1];
        isVis = new boolean[v+1];

        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[startNode] = 0;
        map = new ArrayList<>();
        for(int i = 0; i <=v; ++i) map.add(new ArrayList<>());

        for(int i = 0; i < e; ++i)
        {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            map.get(start).add(new Weight(end,weight));
        }

        PriorityQueue<Weight> pq = new PriorityQueue(new Comparator<Weight>() {
            @Override
            public int compare(Weight o1, Weight o2) {
                return o1.weight - o2.weight;
            }
        });
        pq.add(new Weight(startNode,0));

        while(!pq.isEmpty())
        {
            Weight cur = pq.poll();
            if(isVis[cur.node]) continue;
            isVis[cur.node] = true;
            for(Weight node : map.get(cur.node))
            {
                if(dist[node.node] > dist[cur.node] + node.weight)
                {
                    dist[node.node] = dist[cur.node] + node.weight;
                    pq.add(new Weight(node.node,dist[node.node]));
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i < dist.length; ++i)
        {
            if(dist[i] == Integer.MAX_VALUE) sb.append("INF\n");
            else sb.append(dist[i]).append("\n");
        }
        System.out.print(sb.toString());
    }

}
