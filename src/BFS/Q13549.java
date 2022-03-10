package BFS;

import java.util.*;
import java.io.*;

class Play
{
    int x,time;

    public Play(int x, int time)
    {
        this.x = x;
        this.time = time;
    }
}
public class Q13549 {
    static int N,K;
    static int [] min;
    public static void main(String [] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        if(K <= N)
        {
            System.out.print(N-K);
            return;
        }
        min = new int[(K*2)+1];
        Arrays.fill(min,Integer.MAX_VALUE);
        PriorityQueue<Play> pq = new PriorityQueue<>(new Comparator<Play>()
        {
            @Override
            public int compare(Play o1, Play o2)
            {
                return o1.time - o2.time;
            }
        });

        pq.add(new Play(N,0));

        int answer = 0;
        while(!pq.isEmpty())
        {
            Play cur = pq.poll();
            if(cur.x == K)
            {
                answer = cur.time;
                break;
            }
            for(int idx = 0; idx < 3; ++idx)
            {
                int mx = move(cur.x,idx);
                if(!isValid(mx)) continue;
                int tmpTime = 1;
                //순간이동일때는 0초소요
                if(idx == 2) tmpTime--;
                int totalTime = cur.time+tmpTime;
                if(min[mx] > totalTime)
                {
                    min[mx] = totalTime;
                    pq.add(new Play(mx,totalTime));
                }
            }
        }
        System.out.print(answer);
    }
    static int move(int x, int action)
    {
        //action(0=앞으로,1=뒤로,2=순간이동)
        if(action == 0) return x+1;
        else if(action == 1) return x-1;
        else return x*2;
    }
    static boolean isValid(int x)
    {
        return x >= 0 && x <= (K*2);
    }
}
