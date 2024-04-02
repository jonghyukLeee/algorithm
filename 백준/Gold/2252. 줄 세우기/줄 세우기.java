import java.io.*;
import java.util.*;

public class Main {
    static List<List<Integer>> map;
    static int [] cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        map = new ArrayList<>();
        for(int i = 0; i <= n; ++i) map.add(new ArrayList<>());
        cnt = new int[n+1];

        for(int i = 0; i < m; ++i)
        {
            st = new StringTokenizer(br.readLine());
            int fst = Integer.parseInt(st.nextToken());
            int sec = Integer.parseInt(st.nextToken());

            map.get(fst).add(sec);
            cnt[sec]++;
        }

       Queue<Integer> q = new LinkedList<>();
        for(int i = 1; i <= n; ++i)
        {
            if(cnt[i] == 0) q.add(i);
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        while(!q.isEmpty())
        {
            int cur = q.poll();
            bw.write(cur+" ");

            for(int next : map.get(cur))
            {
                cnt[next]--;
                if(cnt[next] == 0) q.add(next);
            }
        }
        bw.flush();
        bw.close();
    }
}
