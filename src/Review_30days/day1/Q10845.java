package Review_30days.day1;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q10845 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st;
        Queue<Integer> q = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        int last = 0;
        for(int i = 0; i < N; ++i)
        {
            st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();

            if(cmd.equals("push"))
            {
                int n = Integer.parseInt(st.nextToken());
                q.add(n);
                last = n;
            }
            else if(cmd.equals("pop")) sb.append(q.isEmpty() ? -1 : q.poll()).append("\n");
            else if(cmd.equals("size")) sb.append(q.size()).append("\n");
            else if(cmd.equals("empty")) sb.append(q.isEmpty() ? 1 : 0).append("\n");
            else if(cmd.equals("front")) sb.append(q.isEmpty() ? -1 : q.peek()).append("\n");
            else sb.append(q.isEmpty() ? -1 : last).append("\n");

        }
        System.out.print(sb);
    }
}
