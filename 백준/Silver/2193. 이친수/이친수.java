import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
    static long [] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        if(n < 3)
        {
            System.out.print("1");
            return;
        }
        dp = new long[n+1];
        dp[1] = 1;
        dp[2] = 1;
        for(int i = 3; i <= n; ++i)
        {
            dp[i] = dp[i-2] + dp[i-1];
        }
        System.out.print(dp[n]);
    }
}
