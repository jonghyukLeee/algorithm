import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BigInteger[][] dp = new BigInteger[101][101];

        for (int i = 0; i < 101; i++) {
            dp[i][i] = BigInteger.ONE;
            dp[i][1] = BigInteger.valueOf(i);
            dp[i][0] = BigInteger.ONE;
        }

        for (int i = 2; i < 101; i++) {
            for (int j = 2; j < i; j++) {
                dp[i][j] = dp[i - 1][j - 1].add(dp[i - 1][j]);
            }
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        System.out.print(dp[n][m]);
    }
}
