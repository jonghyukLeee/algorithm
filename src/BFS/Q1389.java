package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Relation
{
    int num,cnt;
    public Relation(int num, int cnt)
    {
        this.num = num;
        this.cnt = cnt;
    }
}
public class Q1389 {
    static ArrayList<ArrayList<Integer>> member;
    static ArrayList<Relation> answerAl;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        member = new ArrayList<>();

        for(int i = 0; i <= n; ++i)
        {
            member.add(new ArrayList<Integer>());
        }
        for(int i = 0; i < m; ++i)
        {
            st = new StringTokenizer(br.readLine());
            int fst = Integer.parseInt(st.nextToken());
            int sec = Integer.parseInt(st.nextToken());

            member.get(fst).add(sec);
            member.get(sec).add(fst);
        }
        answerAl = new ArrayList<>();
        for(int i = 1; i <= n; ++i)
        {
            bfs(i);
        }

        answerAl.sort(new Comparator<Relation>() {
            @Override
            public int compare(Relation o1, Relation o2) {
                if(o1.cnt == o2.cnt)
                {
                    return o1.num - o2.num;
                }
                return o1.cnt - o2.cnt;
            }
        });
        System.out.print(answerAl.get(0).num);
    }
    static void bfs(int start)
    {
        Queue<Relation> q;
        int totalCnt = 0;
        nextLoop : for(int end = 1; end <= n; ++end)
        {
            if(start == end) continue;
            q = new LinkedList<>();
            q.add(new Relation(start,1));

            while(!q.isEmpty())
            {
                Relation tmp = q.poll();
                int cur = tmp.num;
                for(int idx = 0; idx < member.get(cur).size(); ++idx)
                {
                    if(member.get(cur).get(idx) == end)
                    {
                        totalCnt += tmp.cnt;
                        continue nextLoop;
                    }
                    q.add(new Relation(member.get(cur).get(idx),tmp.cnt+1));
                }
            }
        }
        answerAl.add(new Relation(start,totalCnt));
    }
}
