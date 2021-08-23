package DFS;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class TreeNode
{
    int n,weight;

    public TreeNode(int n, int weight)
    {
        this.n = n;
        this.weight = weight;
    }
}
public class Q1167 {
    static boolean [] isVis;
    static int maxVal = Integer.MIN_VALUE;
    static int maxNode;
    static ArrayList<ArrayList<TreeNode>> map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        map = new ArrayList<>();
        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i <= n; ++i)
        {
            map.add(new ArrayList<>());
        }

        for(int i = 0; i < n; ++i)
        {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());

            while(st.hasMoreTokens())
            {
                int fst = Integer.parseInt(st.nextToken());
                if(fst == -1) break;
                int sec = Integer.parseInt(st.nextToken());

                map.get(p).add(new TreeNode(fst,sec));
            }
        }

        isVis = new boolean[n+1];
        isVis[1] = true;
        dfs(1,0);

        isVis = new boolean[n+1];
        isVis[maxNode] = true;
        maxVal = Integer.MIN_VALUE;
        dfs(maxNode,0);

        System.out.print(maxVal);

    }
    static void dfs(int node, int tot)
    {
        for(TreeNode cur : map.get(node))
        {
            if(isVis[cur.n]) continue;
            isVis[cur.n] = true;
            dfs(cur.n,tot+cur.weight);
            isVis[cur.n] = false;
        }

        if(maxVal < tot)
        {
            maxVal = tot;
            maxNode = node;
        }
    }
}
