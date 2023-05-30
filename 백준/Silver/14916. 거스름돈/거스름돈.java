import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int [] dp;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        if (N < 5) {
            System.out.print(N % 2 == 0 ? N / 2 : -1);
            return;
        }

        dp = new int[N + 1];
        Arrays.fill(dp, -1);
        dp[2] = 1;
        dp[4] = 2;
        dp[5] = 1;

        for (int i = 6; i <= N; i++) {
            int left = dp[i - 2], right = dp[i - 5];

            if (left < 0 && right < 0) dp[i] = -1;
            else if (left < 0 || right < 0) dp[i] = Math.max(left, right) + 1;
            else dp[i] = Math.min(left, right) + 1;
        }

        System.out.print(dp[N]);
    }
}
