package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Q11725 {
    static ArrayList<Integer> [] al;
    static int [] parents;
    static boolean [] isVis;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        al = new ArrayList[n+1];
        parents = new int[n+1];
        isVis = new boolean[n+1];

        StringBuilder sb = new StringBuilder();

        for(int i = 1; i < n+1; ++i)
        {
            al[i] = new ArrayList<Integer>();
        }

        for(int i = 0; i < n-1; ++i)
        {
            st = new StringTokenizer(br.readLine());
            int fst = Integer.parseInt(st.nextToken());
            int sec = Integer.parseInt(st.nextToken());

            al[fst].add(sec);
            al[sec].add(fst);
        }

        for(int i = 1; i < n+1; ++i)
        {
            if(!isVis[i])
            {
                dfs(i);
            }
        }
        for(int i = 2; i < n+1; ++i)
        {
            sb.append(parents[i]).append("\n");
        }

        System.out.print(sb.toString());

    }
    static void dfs(int node)
    {
        if(isVis[node]) return;
        isVis[node] = true;

        for(Integer i : al[node])
        {
            if(!isVis[i])
            {
                parents[i] = node;
                dfs(i);
            }
        }
    }
}
