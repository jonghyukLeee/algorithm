package Review_30days.week3.day17;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Q1764 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Map<String,Boolean> hm = new HashMap<>();
        for(int i = 0; i < n; ++i)
        {
            String tmp = br.readLine();
            hm.put(tmp,false);
        }

        for(int i = 0; i < m; ++i)
        {
            String tmp = br.readLine();
            hm.put(tmp,!hm.getOrDefault(tmp,true));
        }

        PriorityQueue<String> pq = new PriorityQueue<>();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(String key : hm.keySet())
        {
            if(hm.get(key)) pq.add(key);
        }
        bw.write(pq.size()+"\n");
        while(!pq.isEmpty()) bw.write(pq.poll()+"\n");

        bw.flush();
        bw.close();
    }
}
