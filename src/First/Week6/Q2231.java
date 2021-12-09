package First.Week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q2231 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int res = 0;
        for(int i = 1; i < n; ++i)
        {
            int tmp = i;
            int sum = i;
            while(tmp != 0)
            {
                sum += tmp % 10;
                tmp /= 10;
            }

            if(sum == n)
            {
                res = i;
                break;
            }
        }
        System.out.print(res);
    }
}
