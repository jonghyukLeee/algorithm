package Review_30days.week4.day24;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Bridge
{
    int n,weight;

    public Bridge(int n, int weight) {
        this.n = n;
        this.weight = weight;
    }
}
public class Q1939 {
    static List<List<Bridge>> map;
    static int from,to;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        map = new ArrayList<>();
        for(int i = 0; i <= n; ++i) map.add(new ArrayList<>());

        int start = Integer.MAX_VALUE;
        int end = Integer.MIN_VALUE;
        for(int i = 0; i < m; ++i)
        {
            st = new StringTokenizer(br.readLine());
            int fst = Integer.parseInt(st.nextToken());
            int sec = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            if(weight < start) start = weight;
            if(weight > end) end = weight;

            map.get(fst).add(new Bridge(sec,weight));
            map.get(sec).add(new Bridge(fst,weight));
        }

        st = new StringTokenizer(br.readLine());
        from = Integer.parseInt(st.nextToken());
        to = Integer.parseInt(st.nextToken());

        int answer = 0;
        boolean [] visited;
        while(start <= end)
        {
            Queue<Integer> q = new LinkedList<>();
            visited = new boolean[n+1];
            visited[from] = true;
            q.add(from);
            int mid = (start + end) / 2;
            boolean canMove = false;
            while(!q.isEmpty())
            {
                int cur = q.poll();
                if(cur == to)
                {
                    canMove = true;
                    answer = Math.max(answer,mid);
                    break;
                }
                for(Bridge next : map.get(cur))
                {
                    if(visited[next.n] || mid > next.weight) continue;
                    visited[next.n] = true;
                    q.add(next.n);
                }
            }
            if(canMove) start = mid+1;
            else end = mid-1;
        }
        System.out.print(answer);
    }
}
