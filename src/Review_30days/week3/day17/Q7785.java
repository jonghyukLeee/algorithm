package Review_30days.week3.day17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q7785 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st;
        Map<String,Boolean> hm = new HashMap<>();
        for(int i = 0; i < n; ++i)
        {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String cmd = st.nextToken();

            if(cmd.equals("enter")) hm.put(name,true);
            else hm.put(name,false);
        }
        PriorityQueue<String> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(String key : hm.keySet())
        {
            if(hm.get(key)) pq.add(key);
        }

        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()) sb.append(pq.poll()).append("\n");

        System.out.print(sb);
    }
}
