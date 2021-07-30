package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Point
{
    int end, weight;

    public Point(int end, int weight)
    {
        this.end = end;
        this.weight = weight;
    }
}
public class Q1197 {
    static ArrayList<ArrayList<Point>> al;
    static boolean [] isVis;
    static int v;
    static int answer = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        al = new ArrayList<>();

        for(int i = 0; i <= v; ++i)
        {
            al.add(new ArrayList<>());
        }

        for(int i = 0; i < e; ++i)
        {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            al.get(a).add(new Point(b,c));
            al.get(b).add(new Point(a,c));
        }

        for(int i = 1; i <= v; ++i)
        {
            isVis = new boolean[v+1];
            dfs(i);
        }
        System.out.print(answer);
    }
    static void dfs(int start)
    {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        int tmpAnswer = 0;
        while(!q.isEmpty())
        {
            int cur = q.poll();
            isVis[cur] = true;
            Point tmpPoint = new Point(0,Integer.MAX_VALUE);
            for(Point curPoint : al.get(cur))
            {
                if(isVis[curPoint.end]) continue;
                if(tmpPoint.weight > curPoint.weight)
                {
                    tmpPoint = new Point(curPoint.end,curPoint.weight);
                }
            }
            if(tmpPoint.weight == Integer.MAX_VALUE) break;
            tmpAnswer += tmpPoint.weight;
            q.add(tmpPoint.end);
        }
        answer = Math.min(answer,tmpAnswer);
    }
}
