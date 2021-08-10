package Etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q10451 {
    static ArrayList<Integer> al;
    static boolean [] isVis;
    static int n, answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        while(t-- > 0)
        {
            answer = 0;
            n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            al = new ArrayList<>();
            al.add(0);
            isVis = new boolean[n+1];

            for(int i = 1; i <= n; ++i)
            {
                al.add(i,Integer.parseInt(st.nextToken()));
            }

            for(int i = 1; i <=n; ++i)
            {
                if(isVis[i]) continue;
                isVis[i] = true;
                getCycle(i);
            }
            sb.append(answer).append("\n");
        }
        System.out.print(sb.toString());
    }
    static void getCycle(int start)
    {
        answer++;
        Queue<Integer> q = new LinkedList<>();
        q.add(al.get(start));
        while(!q.isEmpty())
        {
            int cur = q.poll();
            isVis[cur] = true;
            if(cur == start)
            {
                return;
            }
            q.add(al.get(cur));
        }
    }
}
