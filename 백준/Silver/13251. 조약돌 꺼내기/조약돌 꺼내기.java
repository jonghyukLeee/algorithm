import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(br.readLine());
        int[] color = new int[m];
        int total = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            color[i] = Integer.parseInt(st.nextToken());
            total += color[i];
        }

        int k = Integer.parseInt(br.readLine());
        double answer = 0.0;
        for (int n: color) {
            if (n >= k) {
                double result = 1.0;
                for (int i = 0; i < k; i++) {
                    result *= (double)(n - i) / (total - i);
                }
                answer += result;
            }
        }

        System.out.print(answer);
    }
}
