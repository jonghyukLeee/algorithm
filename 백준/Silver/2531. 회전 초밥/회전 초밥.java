import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 접시 수
        int d = Integer.parseInt(st.nextToken()); // 초밥 종류
        int k = Integer.parseInt(st.nextToken()); // 연속 접시 수
        int c = Integer.parseInt(st.nextToken()); // 쿠폰 번호

        int[] belt = new int[N];
        for (int i = 0; i < N; i++) {
            belt[i] = Integer.parseInt(br.readLine());
        }

        int[] count = new int[d + 1];
        int unique = 0;
        int max = 0;

        // 초기 윈도우 세팅
        for (int i = 0; i < k; i++) {
            if (count[belt[i]]++ == 0) unique++;
        }

        max = (count[c] == 0) ? unique + 1 : unique;

        // 슬라이딩 윈도우 순회
        for (int i = 1; i < N; i++) {
            int out = belt[i - 1];
            int in = belt[(i + k - 1) % N];

            if (--count[out] == 0) unique--;
            if (++count[in] == 1) unique++;

            int current = (count[c] == 0) ? unique + 1 : unique;
            max = Math.max(max, current);
        }

        System.out.println(max);
    }
}
