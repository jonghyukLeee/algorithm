import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] money = new int[n];

        for (int i = 0; i < n; i++) {
            money[i] = Integer.parseInt(br.readLine());
        }

        int answer = 0;
        while (k > 0) {
            int value = 0;
            for (int i = n - 1; i >= 0; i--) {
                if (k >= money[i]) {
                    value = money[i];
                    break;
                }
            }
            int count = (k / value);

            answer += count;
            k -= (count * value);
        }

        System.out.print(answer);
    }
}
