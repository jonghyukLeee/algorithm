package Week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q11047 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int tmp = k;
        int res = 0;
        int [] arr = new int[n];
        for(int i = 0; i < n; ++i)
        {
            arr[i] = Integer.parseInt(br.readLine());
        }

        for(int i = n-1; i >=0; --i)
        {
            if(arr[i] <= tmp)
            {
                res += tmp / arr[i];
                tmp %= arr[i];
                if(tmp == 0) break;
            }
        }
        System.out.print(res);
    }
}
