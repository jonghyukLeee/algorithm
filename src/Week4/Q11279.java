package Week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Q11279 {
    static PriorityQueue<Integer> q;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        q = new PriorityQueue<>(Collections.reverseOrder());
        sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        int tmp;
        while(t-- > 0)
        {
            tmp = Integer.parseInt(br.readLine());
            if(tmp == 0)
            {
                if(q.isEmpty()) sb.append("0\n");
                else
                {
                    sb.append(q.poll());
                    sb.append("\n");
                }
            }
            else q.add(tmp);
        }
        System.out.print(sb.toString());
        br.close();
    }
}
