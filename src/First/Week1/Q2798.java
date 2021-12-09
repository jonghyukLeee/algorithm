package First.Week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2798 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int max = 0,res = 0,tmp = 0;
        st = new StringTokenizer(br.readLine());
        int [] card = new int[Integer.parseInt(st.nextToken())];
        max = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < card.length; ++i)
        {
            card[i] = Integer.parseInt(st.nextToken());
        }
        Loop1:
        for(int i = 0; i< card.length; ++i)
        {
            for(int j = i+1; j < card.length; ++j)
            {
                for(int k = j+1; k < card.length; ++k)
                {
                    tmp = card[i]+card[j]+card[k];
                    if(tmp <= max)
                    {
                        if(tmp > res) res = tmp;
                        if(res == max) break Loop1;
                    }
                }
            }
        } // Loop1
        System.out.println(res);
    }
}
