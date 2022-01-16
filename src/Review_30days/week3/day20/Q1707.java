package Review_30days.week3.day20;

import java.io.*;
import java.util.*;

public class Q1707 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int k = Integer.parseInt(br.readLine());

        while(k-- > 0)
        {
            String answer = "YES";
            StringTokenizer st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            List<List<Integer>> map = new ArrayList<>();
            for(int i = 0; i <= v; ++i) map.add(new ArrayList<>());

            for(int i = 0; i < e; ++i)
            {
                st = new StringTokenizer(br.readLine());

                int fst = Integer.parseInt(st.nextToken());
                int sec = Integer.parseInt(st.nextToken());

                map.get(fst).add(sec);
                map.get(sec).add(fst);
            }
            int [] group = new int[v+1];
            Queue<Integer> q = new LinkedList<>();

            loop : for(int i = 1; i <= v; ++i)
            {
                if(group[i] == 0) // NONE == 0
                {
                    group[i] = 1;
                    q.add(i);
                    while(!q.isEmpty())
                    {
                        int cur = q.poll();

                        for(int next : map.get(cur))
                        {
                            if(group[next] != 0)
                            {
                                if(group[cur] == group[next])
                                {
                                    answer = "NO";
                                    break loop;
                                }
                            }
                            else
                            {
                                group[next] = group[cur] * -1;
                                q.add(next);
                            }
                        }
                    }
                }
            }
            bw.write(answer+"\n");
        }
        bw.flush();
        bw.close();
    }
}
