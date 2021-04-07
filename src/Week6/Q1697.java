package Week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q1697 {
    static int res;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        res = Integer.MAX_VALUE;

        Queue<Loc> q = new LinkedList<>();
        q.add(new Loc(n,0));
        while(!q.isEmpty())
        {
            Loc tmp = q.poll();
            for(int i = 1; i < 4; ++i)
            {
                int mx = func(tmp.x,i,tmp.time);
                if(mx == k)
                {
                    res = Math.min(res,tmp.time+1);
                    break;
                }
                else
                {
                    q.add(new Loc(mx,tmp.time+1));
                }
            }
        }
        System.out.print(res);

    }
    static int func(int n,int i,int t)
    {
        switch(i)
        {
            case 1 : return n+1;

            case 2 : return n-1;

            case 3 : return n*2;
        }
        return 0;
    }
}
class Loc
{
    int x,time;
    public Loc(int x, int time)
    {
        this.x = x;
        this.time = time;
    }
}
