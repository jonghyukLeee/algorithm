package Etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Print
{
    int idx,imp;

    public Print(int idx, int imp)
    {
        this.idx = idx;
        this.imp = imp;
    }
}
public class Q1966 {
    static Queue<Print> q;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        loop : while(t-- > 0)
        {
            q = new PriorityQueue<>();
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int cnt = 0;

            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < n; ++i)
            {
                q.add(new Print(i,Integer.parseInt(st.nextToken())));
            }

            while(!q.isEmpty())
            {
                Print tmp = q.poll();
                cnt++;
                if(tmp.idx == m)
                {
                    sb.append(cnt).append("\n");
                    continue loop;
                }
            }
        }
        System.out.print(sb.toString());
    }
}
