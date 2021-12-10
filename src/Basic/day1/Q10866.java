package Basic.day1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Q10866 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        Deque<Integer> dq = new ArrayDeque<>();

        for(int i = 0; i < N; ++i)
        {
            st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();

            if(cmd.equals("push_front")) dq.addFirst(Integer.parseInt(st.nextToken()));
            else if(cmd.equals("push_back")) dq.addLast(Integer.parseInt(st.nextToken()));
            else if(cmd.equals("pop_front")) sb.append(dq.isEmpty() ? -1 : dq.pollFirst()).append("\n");
            else if(cmd.equals("pop_back")) sb.append(dq.isEmpty() ? -1 : dq.pollLast()).append("\n");
            else if(cmd.equals("size")) sb.append(dq.size()).append("\n");
            else if(cmd.equals("empty")) sb.append(dq.isEmpty() ? 1 : 0).append("\n");
            else if(cmd.equals("front")) sb.append(dq.isEmpty() ? -1 : dq.peekFirst()).append("\n");
            else sb.append(dq.isEmpty() ? -1 : dq.peekLast()).append("\n");
        }
        System.out.print(sb);
    }
}
