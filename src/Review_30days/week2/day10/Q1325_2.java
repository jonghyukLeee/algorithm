package Review_30days.week2.day10;

import java.io.*;
import java.util.*;

public class Q1325_2 {
    static int N,M;
    static List<Integer> [] map;
    static boolean [] visited;
    static int [] total;
    static Queue<Integer> q;
    static int max_cnt = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new List[N+1];
        for(int i = 1; i <= N; ++i) map[i] = new ArrayList<>();
        for(int i = 0; i < M; ++i)
        {
            st = new StringTokenizer(br.readLine());
            int fst = Integer.parseInt(st.nextToken());
            int sec = Integer.parseInt(st.nextToken());

            map[sec].add(fst);
        }

        total = new int[N+1];
        q = new LinkedList<>();
        for(int i = 1; i <= N; ++i)
        {
            if(!map[i].isEmpty())
            {
                visited = new boolean[N+1];
                visited[i] = true;
                q.add(i);
                while(!q.isEmpty())
                {
                    int cur = q.poll();
                    for(int n : map[cur])
                    {
                        if(!visited[n])
                        {
                            visited[n] = true;
                            total[i]++;
                            q.add(n);
                        }
                    }
                }
                max_cnt = Math.max(max_cnt,total[i]);
            }
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int i = 1; i <= N; ++i)
        {
            if(total[i] == max_cnt) bw.write(i+" ");
        }

        bw.flush();
        bw.close();
    }

}
