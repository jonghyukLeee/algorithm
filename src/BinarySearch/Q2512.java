package BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2512 {
    static long [] requests;
    static long budget;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        requests = new long[N];
        long end = Long.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            requests[i] = Integer.parseInt(st.nextToken());
            end = Math.max(end, requests[i]);
        }
        budget = Integer.parseInt(br.readLine());

        long start = 0L;
        long answer = 0L;
        while (start <= end) {
            long mid = (start + end) / 2;
            long result = calc(mid);

            if (result > budget) end = mid - 1;
            else {
                answer = Math.max(answer, mid);
                start = mid + 1;
            }
        }
        System.out.print(answer);
    }
    static long calc(long max) {
        long total = 0L;
        for (long req: requests) total += Math.min(req, max);
        return total;
    }
}
