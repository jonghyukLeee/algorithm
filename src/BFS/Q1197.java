package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Node implements Comparable<Node>
{
    int start, end, weight;

    public Node(int start, int end, int weight)
    {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }

    @Override
    public int compareTo(Node o) {
        return this.weight - o.weight;
    }
}
public class Q1197 {
    static ArrayList<Node> al;
    static int [] parents;
    static int v;
    static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        al = new ArrayList<>();
        parents = new int[v+1];
        for(int i = 1; i <= v; ++i) parents[i] = i;

        for(int i = 0; i < e; ++i)
        {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            al.add(new Node(a,b,c));
        }

        for(Node cur : al)
        {
            if(!(getParent(cur.start) == getParent(cur.end)))
            {
                union(cur.start,cur.end);
                answer += cur.weight;
            }
        }
        System.out.print(answer);
    }
    static int getParent(int child)
    {
        return parents[child] == child ? child : getParent(parents[child]);
    }
    static void union(int p, int c)
    {
        parents[c] = getParent(parents[p]);
    }
}
