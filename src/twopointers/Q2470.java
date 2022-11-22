package twopointers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q2470 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int [] solutions = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            solutions[i] = Integer.parseInt(st.nextToken());
        }
        //정렬
        Arrays.sort(solutions);
        int answerLeft = 0, answerRight = 0;
        int start = 0, end = N - 1;
        int diff = Integer.MAX_VALUE;
        while (start < end) {
            int sum = solutions[start] + solutions[end];
            int tmpDiff = Math.abs(sum);

            // 기존보다 차이가 좁혀졌다면 값 저장
            if (tmpDiff < diff) {
                diff = tmpDiff;
                // 오름차순 정렬되어있으므로, 무조건 left가 작은값
                answerLeft = solutions[start];
                answerRight = solutions[end];
            }
            // 양수면 값을 줄임
            if (sum > 0) end--;
            // 음수면 값을 늘림
            else start++;
        }

        System.out.printf("%d %d", answerLeft, answerRight);
    }
}
