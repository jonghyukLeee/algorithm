package twopointers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q15961 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int [] belt = new int[N + k];
        for (int i = 0; i < N; i++) {
            belt[i] = Integer.parseInt(br.readLine());
        }

        int [] count = new int[d + 1];
        int tmpCount = 0;
        for (int i = 0; i < k; i++) {
            // k개 만큼 뒤에 붙여줌 (배열 범위를 벗어난 윈도우를 계산하기 위해)
            belt[i + N] = belt[i];

            // 첫 번째 윈도우 세팅
            if (count[belt[i]] < 1) tmpCount++;
            count[belt[i]]++;
        }
        int answer = tmpCount;

        // 슬라이딩
        for (int i = 1; i < N; i++) {
            // start
            count[belt[i - 1]]--;
            if (count[belt[i - 1]] < 1) tmpCount--;

            // end
            int end = i + k - 1;
            // 아직 안먹었으면 카운트++
            if (count[belt[end]] < 1) tmpCount++;
            count[belt[end]]++;
            // 쿠폰 초밥 안먹었으면 + 1
            answer = count[c] < 1 ? Math.max(answer, tmpCount + 1) : Math.max(answer, tmpCount);
        }

        System.out.print(answer);
    }
}
