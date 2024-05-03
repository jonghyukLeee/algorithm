import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        int[] visitCount = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            visitCount[i] = Integer.parseInt(st.nextToken());
        }

        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int maxCount = Integer.MIN_VALUE;
        for (int i = 0; i < x; i++) {
            sum += visitCount[i];
            maxCount = sum;
            map.put(sum, 1);
        }

        for (int i = x; i < n; i++) {
            sum += visitCount[i];
            sum -= visitCount[i - x];

            maxCount = Math.max(maxCount, sum);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        System.out.printf(maxCount == 0 ? "SAD" : "%d\n%d", maxCount, map.get(maxCount));
    }
}
