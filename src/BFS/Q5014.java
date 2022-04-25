package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class KH
{
    int loc,cnt;

    public KH(int loc, int cnt) {
        this.loc = loc;
        this.cnt = cnt;
    }
}
public class Q5014 {
    static int [] move = new int[2];
    static boolean [] visited;
    static int F;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        F = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int G = Integer.parseInt(st.nextToken());
        int U = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        move[0] = U;
        move[1] = -D;
        visited = new boolean[F+1];

        Queue<KH> q = new LinkedList<>();
        q.add(new KH(S,0));
        visited[S] = true;

        int answer = 0;
        boolean isDone = false;
        while(!q.isEmpty())
        {
            KH cur = q.poll();

            if(cur.loc == G)
            {
                isDone = true;
                answer = cur.cnt;
                break;
            }
            for(int idx = 0; idx < 2; idx++)
            {
                int next = cur.loc + move[idx];
                if(!isValid(next) || visited[next]) continue;
                visited[next] = true;
                q.add(new KH(next,cur.cnt+1));
            }
        }
        System.out.print(isDone ? answer : "use the stairs");
    }
    static boolean isValid(int x)
    {
        return x > 0 && x <= F;
    }
}
