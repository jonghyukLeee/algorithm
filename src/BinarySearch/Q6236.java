package BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q6236 {
    static int N,M;
    static int [] input;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int start = 0;
        input = new int[N];
        for (int i = 0; i < N; i++) {
            input[i] = Integer.parseInt(br.readLine());
            start = Math.max(start, input[i]);
        }

        int end = 1_000_000_000; // 10,000 * 100,000
        int mid;
        int answer = Integer.MAX_VALUE;

        while(start <= end) {
            mid = (start + end) / 2;

            int res = search(mid);

            if (res <= M) {
                answer = Math.min(answer, mid);
                end = mid - 1;
            }
            else {
                start = mid + 1;
            }
        }

        System.out.print(answer);
    }
    static int search(int k) {
        int count = 1;
        int money = k;
        for (int val : input) {
            money -= val;
            if (money < 0) {
                count++;
                money = k - val;
            }
        }
        return count;
    }
}
