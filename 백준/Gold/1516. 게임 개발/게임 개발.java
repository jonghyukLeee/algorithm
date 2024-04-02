import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] timeArray = new int[n];
        int[] countArray = new int[n];
        int[] answerArray = new int[n];
        List<Integer>[] map = new ArrayList[n];
        for (int i = 0; i < n; i++) map[i] = new ArrayList<>();

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());

            timeArray[i] = time;
            answerArray[i] = time;

            while (st.hasMoreTokens()) {
                int next = Integer.parseInt(st.nextToken());
                if (next < 0) break;
                next--;

                map[next].add(i);
                countArray[i]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (countArray[i] == 0) q.add(i);
        }

        while (!q.isEmpty()) {
            int current = q.poll();

            for (int next: map[current]) {
                answerArray[next] = Math.max(answerArray[next], answerArray[current] + timeArray[next]);
                countArray[next]--;

                if (countArray[next] == 0) {
                    q.add(next);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int time: answerArray) sb.append(time).append("\n");

        sb.deleteCharAt(sb.length() - 1);
        System.out.print(sb);
    }
}
