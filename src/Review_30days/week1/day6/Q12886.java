package Review_30days.week1.day6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Stone
{
    int a,b,c;

    public Stone(int a, int b, int c)
    {
        this.a = a;
        this.b = b;
        this.c = c;
    }
}
public class Q12886 {
    static boolean [][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int [] stones = new int[3];
        int tmp_tot = 0;
        for(int i = 0; i < 3; ++i)
        {
            int n = Integer.parseInt(st.nextToken());
            stones[i] = n;
            tmp_tot += n;
        }

        if((tmp_tot % 3) != 0)
        {
            System.out.print(0);
            return;
        }
        visited = new boolean[1501][1501];
        Arrays.sort(stones);
        Queue<Stone> q = new LinkedList<>();
        q.add(new Stone(stones[0],stones[1],stones[2]));

        int answer = 0;
        while(!q.isEmpty())
        {
            Stone cur = q.poll();

            if(cur.a == cur.b && cur.b == cur.c)
            {
                answer = 1;
                break;
            }

            if(cur.a != cur.b)
            {
                int min = cur.a;
                int max = cur.b;

                if(cur.a > cur.b)
                {
                    min = cur.b;
                    max = cur.a;
                }

                if(visited[min][max]) continue;
                visited[min][max] = true;
                max -= min;
                min *= 2;
                q.add(new Stone(min,max,cur.c));
            }

            if(cur.a != cur.c)
            {
                int min = cur.a;
                int max = cur.c;

                if(cur.a > cur.c)
                {
                    min = cur.c;
                    max = cur.a;
                }

                if(visited[min][max]) continue;
                visited[min][max] = true;
                max -= min;
                min *= 2;
                q.add(new Stone(min,max,cur.b));
            }

            if(cur.b != cur.c)
            {
                int min = cur.b;
                int max = cur.c;

                if(cur.b > cur.c)
                {
                    min = cur.c;
                    max = cur.b;
                }

                if(visited[min][max]) continue;
                visited[min][max] = true;
                max -= min;
                min *= 2;
                q.add(new Stone(min,max,cur.a));
            }
        }
        System.out.print(answer);
    }
}
