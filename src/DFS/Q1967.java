package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Node
{
    int num,weight;

    public Node(int num, int weight)
    {
        this.num = num;
        this.weight = weight;
    }
}
public class Q1967 {
    static boolean [] isVis;
    static int maxValue = Integer.MIN_VALUE;
    static int maxNode;
    static ArrayList<ArrayList<Node>> map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        map = new ArrayList<>();
        isVis = new boolean[n+1];
        StringTokenizer st;

        for(int i = 0; i <= n; ++i)
        {
            map.add(new ArrayList<>());
        }

        for(int i = 0; i < n-1; ++i)
        {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            map.get(p).add(new Node(c,w));
            map.get(c).add(new Node(p,w));
        }
        isVis[1] = true;
        dfs(1,0);

        isVis = new boolean[n+1];
        isVis[maxNode] = true;
        maxValue = Integer.MIN_VALUE;
        dfs(maxNode,0);
        System.out.print(maxValue);
    }
    static void dfs(int node,int tot)
    {
        for(Node cur : map.get(node))
        {
            if(isVis[cur.num]) continue;
            isVis[cur.num] = true;
            dfs(cur.num,tot+cur.weight);
            isVis[cur.num] = false;
        }
        if(maxValue < tot)
        {
            maxValue = tot;
            maxNode = node;
        }
    }
}
