package First.Week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q1697 {
    static int res;
    static boolean [] isVis;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        isVis = new boolean[100001];
        res = Integer.MAX_VALUE;

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        if(n == k)
        {
            System.out.print("0");
            System.exit(0);
        }
        Queue<Loc> q = new LinkedList<>();
        q.add(new Loc(n,0));
        isVis[n] = true;
        while(!q.isEmpty())
        {
            Loc tmp = q.poll();
            for(int i = 1; i < 4; ++i)
            {
                int mx = func(tmp.x,i,tmp.time);
                if(!chkRange(mx)) continue;
                if(isVis[mx]) continue;
                if(mx == k)
                {
                    res = Math.min(res,tmp.time+1);
                    break;
                }
                else
                {
                    q.add(new Loc(mx,tmp.time+1));
                    isVis[mx] = true;
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
    static boolean chkRange(int x)
    {
        if(x < 0 || x > 100000) return false;
        return true;
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
