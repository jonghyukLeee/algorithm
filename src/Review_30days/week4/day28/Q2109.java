package Review_30days.week4.day28;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Req
{
    int p,d;

    public Req(int p, int d) {
        this.p = p;
        this.d = d;
    }
}
public class Q2109 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        PriorityQueue<Req> pq = new PriorityQueue<>((o1, o2) -> {
            if(o1.p == o2.p) return o1.d - o2.d;
            return o2.p - o1.p;
        });
        for(int i = 0; i < N; ++i)
        {
            st = new StringTokenizer(br.readLine());
            int tmp_p = Integer.parseInt(st.nextToken());
            int tmp_d = Integer.parseInt(st.nextToken());

            pq.add(new Req(tmp_p,tmp_d));
        }

        int answer = 0;
        boolean [] scheduled = new boolean[10001];
        while(!pq.isEmpty())
        {
            Req cur = pq.poll();
            for(int i = cur.d; i > 0; --i)
            {
                if(!scheduled[i])
                {
                    scheduled[i] = true;
                    answer += cur.p;
                    break;
                }
            }
        }
        System.out.print(answer);
    }
}

