package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Node
{
    int start, end, weight;

    public Node(int start, int end, int weight)
    {
        this.start = start;
        this.end = end;
        this.weight = weight;
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
        al.sort(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.weight - o2.weight;
            }
        });
        int cnt = 0;
        for(Node cur : al)
        {
            if(cnt == v-1) break;
            if(!(getParent(cur.start) == getParent(cur.end)))
            {
                union(cur.start,cur.end);
                cnt++;
                answer += cur.weight;
            }
        }
        System.out.print(answer);
    }
    static int getParent(int child)
    {
        if(parents[child] == child) return child;
        else
        {
            return parents[child] = getParent(parents[child]);
        }
    }
    static void union(int p, int c)
    {
        parents[getParent(c)] = getParent(p);
    }
}
