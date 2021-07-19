package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1753 {
    static int [][] map;
    static boolean [] isVis;
    static int v,min;
    static int startPoint;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        startPoint = Integer.parseInt(br.readLine());

        map = new int[v+1][v+1];

        for(int i = 0; i < e; ++i)
        {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            map[start][end] = w;
        }

        StringBuilder sb = new StringBuilder();

        for(int i = 1; i < v+1; ++i)
        {
            if(i == startPoint)
            {
                sb.append("0\n");
                continue;
            }
            isVis = new boolean[v+1];
            min = Integer.MAX_VALUE;
            isVis[startPoint] = true;
            sb.append(dfs(startPoint,i,0)).append("\n");
        }
        System.out.print(sb.toString());
    }
    static String dfs(int start, int end, int w)
    {
        if(start == end)
        {
            min = Math.min(min,w);
        }
        for(int i = 1; i < map.length; ++i)
        {
            if(isVis[i]) continue;
            if(map[start][i] > 0)
            {
                isVis[i] = true;
                dfs(i,end,w+map[start][i]);
                isVis[i] = false;
            }
        }
        if(min == Integer.MAX_VALUE) return "INF";
        return min+"";
    }
}
