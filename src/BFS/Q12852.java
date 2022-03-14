package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class One
{
    int n,cnt;
    String str;

    public One(int n, int cnt, String str) {
        this.n = n;
        this.cnt = cnt;
        this.str = str;
    }

    public String add(int n)
    {
        return this.str+" "+n;
    }
}
public class Q12852 {
    static int N;
    static boolean [] visited;
    static Queue<One> q;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        visited = new boolean[N];

        q = new LinkedList<>();
        q.add(new One(N,0,N+""));

        StringBuilder sb = new StringBuilder();
        while(!q.isEmpty())
        {
            One cur = q.poll();

            if(cur.n == 1)
            {
                sb.append(cur.cnt).append("\n").append(cur.str);
                break;
            }
            //3나누기
            if((cur.n % 3) == 0) calc(cur,0);
            //2나누기
            if((cur.n % 2) == 0) calc(cur,1);
            //빼기
            calc(cur,2);
        }
        System.out.print(sb);
    }
    static void calc(One cur, int idx)
    {
        int next;
        if(idx == 0) next = cur.n / 3;
        else if(idx == 1) next = cur.n / 2;
        else next = cur.n-1;
        if(!visited[next])
        {
            visited[next] = true;
            q.add(new One(next,cur.cnt+1,cur.add(next)));
        }
    }
}
