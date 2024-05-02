import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] lightIndex = new int[m];
        for (int i = 0; i < m; i++) {
            lightIndex[i] = Integer.parseInt(st.nextToken());
        }

        int max = lightIndex[0];

        for (int i = 1; i < m; i++) {
            int diff = lightIndex[i] - lightIndex[i - 1];

            int height = (diff % 2 == 0) ? diff / 2 : (diff / 2) + 1;

            max = Math.max(max, height);
        }

        max = Math.max(max, n - lightIndex[m - 1]);
        System.out.print(max);
    }
}
