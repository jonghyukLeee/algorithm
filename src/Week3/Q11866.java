package Week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q11866 {
    static Queue<Integer> q;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        q = new LinkedList<>();
        int cnt = 1;
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        while(cnt <= n)
        {
            q.add(cnt++);
        }
        int tmp = 0;
        sb.append("<");
        while(!q.isEmpty())
        {
            tmp++;
            if(tmp == k)
            {
                sb.append(q.poll());
                sb.append(", ");
                tmp = 0;
                continue;
            }
            q.add(q.poll());
        }
        sb.delete(sb.length()-2,sb.length());
        sb.append(">");
        System.out.print(sb.toString());
        br.close();
    }
}
