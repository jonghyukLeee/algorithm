package Etc.samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Belt
{
    boolean hasRobot;
    int durability;

    public Belt(int durability)
    {
        this.durability = durability;
    }
    public void setBox()
    {
        this.hasRobot = true;
        this.durability--;
    }
    public void getBox()
    {
        this.hasRobot = false;
    }

}
public class Q20055 {
    static int N,K;
    static int zero_cnt;
    static List<Belt> belt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        belt = new LinkedList<>();

        for(int i  = 0; i < N*2; ++i) belt.add(new Belt(Integer.parseInt(st.nextToken())));
        int remove_point = N-1;
        int last_idx = (N*2)-1;

        int t = 0;
        while(zero_cnt < K)
        {
            t++;
            //벨트 회전
            belt.add(0,belt.remove(last_idx));
            if(belt.get(remove_point).hasRobot) belt.get(remove_point).getBox();

            for(int i = last_idx-1; i > 0; --i)
            {
                Belt cur = belt.get(i);
                if(cur.hasRobot)
                {
                    Belt next = belt.get(i+1);
                    if(!next.hasRobot && next.durability > 0)
                    {
                        if(i+1 == remove_point)
                        {
                            next.durability--;
                        }
                        else
                        {
                            next.setBox();
                        }
                        cur.getBox();
                        if(next.durability == 0) zero_cnt++;
                    }
                }
            }
            Belt fst = belt.get(0);
            if(fst.durability > 0)
            {
                fst.setBox();
                if(fst.durability == 0) zero_cnt++;
            }

        }
        System.out.print(t);
    }

}
