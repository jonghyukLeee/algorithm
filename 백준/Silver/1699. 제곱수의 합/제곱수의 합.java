import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            dp[i] = i; // 모든 수는 일단 1의 제곱을 나열하여 표현 가능
            for (int j = 1; j * j <= i; j++) {
                // i - (제곱수 + 1)이 가능한 모든 경우의 수 중 최솟값 탐색
                int tmp = dp[i - (j * j)];
                if (dp[i] > tmp + 1) dp[i] = tmp + 1;
            }
        }
        System.out.print(dp[n]);
    }
}
