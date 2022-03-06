package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q9205 {
    static int N;
    static List<List<Integer>> map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        while(t-- > 0)
        {
            // 편의점 개수
            N = Integer.parseInt(br.readLine());

            Point[] nodes = new Point[N+2];
            //정점들의 좌표 입력
            for(int i = 0; i < N+2; ++i)
            {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                nodes[i] = new Point(x,y);
            }

            map = new ArrayList<>();
            for(int i = 0; i < N+2; ++i) map.add(new ArrayList<>());

            // 거리가 1000 이하인 정점끼리 연결
            for(int i = 0; i < N+1; ++i)
            {
                for(int j = i+1; j < N+2; ++j)
                {
                    int diff = Math.abs(nodes[i].x - nodes[j].x) + Math.abs(nodes[i].y - nodes[j].y);
                    if(diff <= 1000)
                    {
                        map.get(i).add(j);
                        map.get(j).add(i);
                    }
                }
            }
            sb.append(bfs()).append("\n");
        }
        System.out.print(sb);
    }
    static String bfs()
    {
        Queue<Integer> q = new LinkedList<>();
        q.add(0);

        boolean [] visited = new boolean[N+2];
        visited[0] = true;

        while(!q.isEmpty())
        {
            int cur = q.poll();

            if(cur == N+1) return "happy";
            for(int i : map.get(cur))
            {
                if(visited[i]) continue;
                visited[i] = true;
                q.add(i);
            }
        }
        return "sad";
    }
}
