package Review_30days.week3.day18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Node
{
    int n,weight;

    public Node(int n, int weight)
    {
        this.n = n;
        this.weight = weight;
    }
}
public class Q1922 {
    static List<List<Node>> map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        map = new ArrayList<>();

        for(int i = 0; i <= N; ++i) map.add(new ArrayList<>());

        int M = Integer.parseInt(br.readLine());
        StringTokenizer st;
        while(M-- > 0)
        {
            st = new StringTokenizer(br.readLine());
            int fst = Integer.parseInt(st.nextToken());
            int sec = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            map.get(fst).add(new Node(sec,w));
            map.get(sec).add(new Node(fst,w));
        }

        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.weight - o2.weight;
            }
        });

        pq.add(new Node(1,0));
        boolean [] visited = new boolean[N+1];
        int answer = 0,cnt = 0;
        while(!pq.isEmpty())
        {
            Node cur = pq.poll();
            if(visited[cur.n]) continue;
            visited[cur.n] = true;
            answer += cur.weight;
            cnt++;
            if(cnt == N) break;
            for(Node next : map.get(cur.n))
            {
                if(!visited[next.n]) pq.add(next);
            }
        }
        System.out.print(answer);
    }
}
