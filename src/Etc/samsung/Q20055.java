package Etc.samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Belt
{
    boolean hasBox;
    int durability;

    public Belt(int durability)
    {
        this.durability = durability;
    }
    public void setBox()
    {
        this.hasBox = true;
        this.durability--;
    }
    public void getBox()
    {
        this.hasBox = false;
    }

}
public class Q20055 {
    static int N,K;
    static int zero_cnt;
    static List<Belt> belt;
    static Queue<Integer> q;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        belt = new LinkedList<>();

        for(int i  = 0; i < N*2; ++i) belt.add(new Belt(Integer.parseInt(st.nextToken())));

        q = new LinkedList<>();
        int t = 0;
        while(zero_cnt < K)
        {
            t++;
            if(!q.isEmpty()) // 벨트위에 로보트가 있다면
            {
                int cur = q.poll();
                int mv_idx = cur+1;
                if(mv_idx < N-1)
                {
                    Belt tmp = belt.get(mv_idx);
                    if(!tmp.hasBox && tmp.durability > 0)
                    {
                        q.add(mv_idx);
                        tmp.setBox();
                        if(tmp.durability == 0) zero_cnt++;
                        belt.get(cur).getBox();
                    }
                    else if(tmp.durability > 0) q.add(cur);
                }
            }
            Belt fst = belt.get(0);
            if(!fst.hasBox && fst.durability > 0)
            {
                q.add(0);
                fst.setBox();
                if(fst.durability == 0) zero_cnt++;
            }
            for(Belt b : belt) System.out.print(b.durability+" ");
            System.out.print("zero = "+zero_cnt);
            System.out.println();
        }
        System.out.print(t);
    }

}
