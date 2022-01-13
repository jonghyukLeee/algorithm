package Review_30days.week2.day9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1790 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        long tmp_k = K;
        long len = 1;
        long num_cnt = 9;
        long res = 0;

        while(tmp_k > num_cnt * len)
        {
            tmp_k -= num_cnt * len;
            res += num_cnt;
            num_cnt *= 10;
            len++;
        }

        res = (res+1) + ((tmp_k-1) / len);

        if(res > N) System.out.print(-1);
        else
        {
            int idx = (int)((tmp_k-1) % len);
            System.out.print(String.valueOf(res).charAt(idx));
        }
    }
}
