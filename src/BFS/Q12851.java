package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Subin
{
    int x,cnt;

    public Subin(int x, int cnt)
    {
        this.x = x;
        this.cnt = cnt;
    }
}
public class Q12851 {
    static int [] map;
    static int [] move = {-1,1,2};
    static int [] isVis;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        if(n > k)
        {
            System.out.printf("%d\n%d",n-k,1);
            return;
        }
        map = new int[100001];
        isVis = new int[100001];
        Arrays.fill(isVis,Integer.MAX_VALUE);

        Queue<Subin> q = new LinkedList<>();
        q.add(new Subin(n,0));

        int minCnt = Integer.MAX_VALUE;
        int cnt = 0;
        while(!q.isEmpty())
        {
            Subin cur = q.poll();
            if(isVis[cur.x] > cur.cnt) isVis[cur.x] = cur.cnt;
            if(cur.cnt > minCnt) break;

            if(cur.x == k)
            {
                minCnt = cur.cnt;
                cnt++;
            }

            for(int i = 0; i < 3; ++i)
            {
                int m;
                if(i == 2) m = cur.x * move[i];
                else m = cur.x + move[i];

                if(!isValid(m) || cur.cnt >= isVis[m]) continue;
                q.add(new Subin(m,cur.cnt+1));
            }
        }

        System.out.printf("%d\n%d",minCnt,cnt);
    }
    static boolean isValid(int x)
    {
        return x >= 0 && x < 100001;
    }
}
