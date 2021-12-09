package First.Week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Q11286 {
    static PriorityQueue<Integer> q;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    sb = new StringBuilder();
    q = new PriorityQueue<Integer>(((o1, o2) -> {
        int abs1 = Math.abs(o1);
        int abs2 = Math.abs(o2);

        if(abs1 == abs2) return o1 > o2 ? 1 : -1;
        return abs1-abs2;
    }));
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
    } // end of while
        System.out.print(sb.toString());
    }
}
