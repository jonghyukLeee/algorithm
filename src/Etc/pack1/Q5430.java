package Etc.pack1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Q5430 {
    static Deque<String> dq;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while(T-- > 0)
        {
            String cmd = br.readLine();
            int n = Integer.parseInt(br.readLine());

            String input = br.readLine();
            StringTokenizer st = new StringTokenizer(input,"[,]");
            dq = new ArrayDeque<>();
            for(int i = 0; i < n; i++) dq.add(st.nextToken());
            sb.append(doCmd(cmd)).append("\n");
        }
        System.out.print(sb);
    }
    static String doCmd(String cmd)
    {
        boolean isFirst = true;
        for(char c : cmd.toCharArray())
        {
            // 뒤집기
            if(c == 'R') isFirst = !isFirst;
            // 버리기
            else
            {
                if(dq.isEmpty()) return "error";
                // 방향이 first
                if(isFirst) dq.pollFirst();
                else dq.pollLast();
            }
        }
        StringBuilder sb = new StringBuilder("[");
        if(isFirst) while(!dq.isEmpty()) sb.append(dq.pollFirst()).append(",");
        else while(!dq.isEmpty()) sb.append(dq.pollLast()).append(",");

        if(sb.length() > 1) sb.deleteCharAt(sb.length()-1);
        return sb.toString()+"]";
    }
}
