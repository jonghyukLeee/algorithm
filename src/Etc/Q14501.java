package Etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Counsel
{
    int time,cost;

    public Counsel(int time, int cost)
    {
        this.time = time;
        this.cost = cost;
    }
}
public class Q14501 {
    static Counsel [] counsel;
    static int [] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        counsel = new Counsel[N];
        dp = new int[N];
        StringTokenizer st;
        for(int i = 0; i < N; ++i)
        {
            st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            counsel[i] = new Counsel(time,cost);
        }

        for(int i = 0; i < N; ++i)
        {
            Counsel cur = counsel[i];
            for(int j = i; j < N; ++j)
            {
                int next = cur.time + j;
                if(next < N)
                {
                }
            }
        }
    }
}
