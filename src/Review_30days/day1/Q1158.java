package Review_30days.day1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q1158 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Queue<Integer> q = new LinkedList<>();
        for(int i = 1; i <= N; ++i) q.add(i);

        StringBuilder sb = new StringBuilder();
        sb.append("<");

        while(N-- > 0)
        {
            for(int i = 0 ; i < K-1; ++i)
            {
                q.add(q.poll());
            }
            sb.append(q.poll()).append(", ");
        }
        int tmp = sb.length();
        sb.replace(tmp-2,tmp,"");
        sb.append(">");
        System.out.print(sb);
    }
}
