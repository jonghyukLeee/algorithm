package Week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q13458 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int cnt = 0;
        int n = Integer.parseInt(br.readLine());
        int [] c = new int[n];
        st= new StringTokenizer(br.readLine());
        for(int i = 0; i < n; ++i)
        {
            c[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());

        for(int i = 0; i < n; ++i)
        {
            int tmp = c[i];
            if(tmp <= m)
            {
                cnt++;
                break;
            }
            else
            {
                tmp -= m;
                cnt++;
                cnt += tmp/s;
                tmp %= s;
                if(tmp > 0) cnt++;
            }
        }
        System.out.println(cnt);
        br.close();
    }
}
