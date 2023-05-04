package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Dslr
{
    int n;
    String cmd;

    public Dslr(int n, String cmd)
    {
        this.n = n;
        this.cmd = cmd;
    }

}
public class Q9019 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        while(t-- > 0)
        {
            st = new StringTokenizer(br.readLine());

            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            Queue<Dslr> q = new LinkedList<>();
            q.add(new Dslr(A,""));
            boolean [] visited = new boolean[10000];
            visited[A] = true;
            while(!q.isEmpty())
            {
                Dslr cur = q.poll();
                if(cur.n == B)
                {
                    sb.append(cur.cmd).append("\n");
                    break;
                }

                for(int i = 0; i < 4; ++i)
                {
                    Dslr next = calc(cur.n,i);
                    if(visited[next.n]) continue;
                    visited[next.n] = true;
                    q.add(new Dslr(next.n,cur.cmd+next.cmd));
                }
            }
        }
        System.out.print(sb);
    }
    static Dslr calc(int n, int cmd)
    {
        int res = n;
        //D
        if(cmd == 0)
        {
            res = (res * 2) % 10000;
            return new Dslr(res,"D");
        }
        //S
        else if(cmd == 1)
        {
            res = res == 0 ? 9999 : res-1;
            return new Dslr(res,"S");
        }
        //L
        else if(cmd == 2)
        {
            int tmp = (res % 1000) * 10;
            tmp += (res / 1000);

            return new Dslr(tmp,"L");
        }
        //R
        else
        {
            int tmp = (res % 10) * 1000;
            tmp += (res / 10);

            return new Dslr(tmp,"R");
        }
    }
}
