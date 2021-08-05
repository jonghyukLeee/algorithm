package Etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q11403 {
    static boolean [] isVis;
    static ArrayList<ArrayList<Integer>> al;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;

        al = new ArrayList<>();

        for(int i = 0; i < n; ++i)
        {
            al.add(new ArrayList<>());
        }

        for(int i = 0; i < n; ++i)
        {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; ++j)
            {
                if(st.nextToken().equals("1")) al.get(i).add(j);
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; ++i)
        {
            for(int j = 0; j < n; ++j)
            {
                isVis = new boolean[n];
                sb.append(isLinked(i,j)).append(" ");
            }
            sb.append("\n");
        }

        System.out.print(sb.toString());

    }
    static int isLinked(int start, int end)
    {
        Queue<Integer> q = new LinkedList<>();
        if(!al.isEmpty()) q.addAll(al.get(start));
        while(!q.isEmpty())
        {
            int curPoint = q.poll();
            if(curPoint == end) return 1;
            isVis[curPoint] = true;
            for(int i : al.get(curPoint))
            {
                if(isVis[i]) continue;
                q.add(i);
            }
        }
        return 0;
    }
}
