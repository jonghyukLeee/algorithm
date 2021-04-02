package Week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q1260 {
    static boolean [][] map;
    static boolean [] isVis;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());

        map = new boolean[n+1][n+1];
        isVis = new boolean[n+1];
        int x,y;
        while(m-- >0)
        {
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            map[x][y] = true;
            map[y][x] = true;
        }

        //dfs
        sb.append(v).append(" ");
        isVis[v] = true;
        dfs(v);
        System.out.println(sb.toString());
        Arrays.fill(isVis,false);
        sb.delete(0,sb.length());
        //bfs
        sb.append(v).append(" ");
        isVis[v] = true;
        bfs(v);
        System.out.print(sb.toString());
    }
    static void dfs(int v)
    {
        for(int i = 1; i < map.length; ++i)
        {
            if(i == v) continue;
            if(map[v][i] && !isVis[i])
            {
                isVis[i] = true;
                sb.append(i).append(" ");
                dfs(i);
            }
        }
    }
    static void bfs(int v)
    {
        Queue<Integer> q = new LinkedList<>();
        q.add(v);
        while(!q.isEmpty())
        {
            int tmp = q.poll();
            for(int i = 1; i < map.length; ++i)
            {
                if(i == v) continue;
                if(map[tmp][i] && !isVis[i])
                {
                    q.add(i);
                    sb.append(i).append(" ");
                    isVis[i] = true;
                }
            }
        }
    }
}
