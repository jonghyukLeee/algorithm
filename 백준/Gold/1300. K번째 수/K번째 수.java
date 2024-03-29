import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N, K;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());
        long answer = 0;

        long start = 1, end = K;

        while (start <= end) {
            long mid = (start + end) / 2;

            long totalCount = 0;
            for (int i = 1; i <= N; i++) {
                long minCount = mid / i;
                minCount = Math.min(minCount, N);

                totalCount += minCount;
            }

            if (totalCount < K) {
                start = mid + 1;
            } else {
                answer = mid;
                end = mid - 1;
            }
        }

        System.out.print(answer);
    }
}
