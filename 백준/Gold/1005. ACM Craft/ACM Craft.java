import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            int[] delay = new int[n + 1];
            int[] answer = new int[n + 1];
            int[] count = new int[n + 1];
            List<Integer>[] list = new ArrayList[n + 1];
            for (int i = 1; i <= n; i++) list[i] = new ArrayList<>();

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                int next = Integer.parseInt(st.nextToken());
                delay[i + 1] = next;
                answer[i + 1] = next;
            }

            for (int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine());
                int first = Integer.parseInt(st.nextToken());
                int second = Integer.parseInt(st.nextToken());

                list[first].add(second);
                count[second]++;
            }

            int lastBuilding = Integer.parseInt(br.readLine());

            Queue<Integer> q = new LinkedList<>();
            for (int i = 1; i <= n; i++) {
                if (count[i] == 0) q.add(i);
            }

            while (!q.isEmpty()) {
                int current = q.poll();

                for (int next: list[current]) {
                    answer[next] = Math.max(answer[next], answer[current] + delay[next]);
                    count[next]--;

                    if (count[next] == 0) q.add(next);
                }
            }

            sb.append(answer[lastBuilding]).append("\n");
        }

        sb.deleteCharAt(sb.length() - 1);
        System.out.print(sb);
    }
}
