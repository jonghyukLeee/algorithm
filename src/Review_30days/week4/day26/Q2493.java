package Review_30days.week4.day26;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

class Tower
{
    int h,n;

    public Tower(int h, int n) {
        this.h = h;
        this.n = n;
    }
}
public class Q2493 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        Stack<Tower> s = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int t_num = 1;
        for(int i = 0; i < n; ++i)
        {
            Tower next = new Tower(Integer.parseInt(st.nextToken()),t_num++);
            int res;
            while(!s.isEmpty() && s.peek().h < next.h) s.pop();
            if(s.isEmpty()) res = 0;
            else
            {
                res = s.peek().n;
            }
            s.push(next);
            sb.append(res).append(" ");
        }
        System.out.print(sb);
    }
}
