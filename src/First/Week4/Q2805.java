package First.Week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2805 {
    static int [] trees;
    static int m;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();
        long max = Integer.MIN_VALUE;
        long min = Integer.MAX_VALUE;
        st = new StringTokenizer(br.readLine());
        trees = new int[Integer.parseInt(st.nextToken())];
        m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int tmp;
        for(int i =0; i < trees.length; ++i)
        {
            tmp = Integer.parseInt(st.nextToken());
            trees[i] = tmp;
            max = Math.max(max,tmp);
            min = Math.min(min,tmp);
        }
        cut(min,max);
        System.out.print(sb.toString());
        br.close();
    }
    static void cut(long min, long max)
    {
        int res;
        long mid = 0;
        while(true)
        {
            res = 0;
            mid = (min+max) / 2;
            for(int i : trees)
            {
                if(i > mid)
                {
                    res += i - mid;
                }
            }
            if(res == m) break;
            if(res > m) min = mid+1;
            else max = mid-1;
        } //end loop
        sb.append(mid);
    }
}
