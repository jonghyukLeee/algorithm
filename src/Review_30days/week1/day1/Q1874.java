package Review_30days.week1.day1;

import java.io.*;
import java.util.Stack;

public class Q1874 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Stack<Integer> s = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int start = 1;
        while(n-- > 0)
        {
            int next = Integer.parseInt(br.readLine());

            if(start <= next)
            {
                for(int i = start; i <= next; ++i)
                {
                    s.push(i);
                    sb.append("+").append("\n");
                }
                start = next+1;
            }
            else if(s.peek() != next)
            {
                System.out.print("NO");
                return;
            }
            s.pop();
            sb.append("-").append("\n");
        }
        System.out.print(sb);
    }
}
