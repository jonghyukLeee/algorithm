package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q2644 {
    static boolean [][] map;
    static boolean [] isVis;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        map = new boolean[n+1][n+1];
        isVis = new boolean[n+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(br.readLine());

        for(int i = 0; i < t; ++i)
        {
            st = new StringTokenizer(br.readLine());
            int fst = Integer.parseInt(st.nextToken());
            int sec = Integer.parseInt(st.nextToken());
            map[fst][sec] = map[sec][fst] = true;
        }
        System.out.print(bfs(start,end));
    }

    static int bfs(int start,int end)
    {
        Queue<Person> q = new LinkedList<>();
        q.add(new Person(start,0));
        int answer = -1;
        while(!q.isEmpty())
        {
            Person tmp = q.poll();
            int cur = tmp.x;
            isVis[cur] = true;
            if(cur == end)
            {
                answer = tmp.cnt;
            }
            for(int i = 0; i < map.length; ++i)
            {
                if(map[i][cur] && !isVis[i])
                {
                    q.add(new Person(i,tmp.cnt+1));
                }
            }
        }
        return answer;
    }
    static class Person
    {
        int x, cnt;

        public Person(int x, int cnt)
        {
            this.x = x;
            this.cnt = cnt;
        }
    }
}
