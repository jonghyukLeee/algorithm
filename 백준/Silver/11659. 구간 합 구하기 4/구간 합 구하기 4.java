import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int[] numbers = new int[N];

        st = new StringTokenizer(br.readLine());
        numbers[0] = Integer.parseInt(st.nextToken());

        for (int i = 1; i < N; i++) {
            numbers[i] = numbers[i - 1] + Integer.parseInt(st.nextToken());
        }

        StringBuilder sb = new StringBuilder();

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken()) - 1;
            int end = Integer.parseInt(st.nextToken()) - 1;

            int result = numbers[end];
            if (start > 0) {
                result -= numbers[start - 1];
            }

            sb.append(result).append("\n");
        }

        sb.deleteCharAt(sb.length() - 1);

        System.out.print(sb);
    }
}
