import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] map;
    static int maxLength = Integer.MIN_VALUE;
    static int totalLength = 0;
    static int answer = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int length = Integer.parseInt(st.nextToken());
            totalLength += length;
            maxLength = Math.max(maxLength, length);
            map[i] = length;
        }

        search();
        System.out.print(answer);
    }
    static void search() {
        int start = maxLength;
        int end = totalLength;

        while (start <= end) {
            int mid = (start + end) / 2;

            int sum = 0;
            int count = 1;

            for (int length: map) {
                if (sum + length > mid) {
                    count++;
                    sum = length;
                } else {
                    sum += length;
                }
            }

            if (count > M) {
                start = mid + 1;
            } else {
                end = mid - 1;
                answer = Math.min(answer, mid);
            }
        }
    }
}
