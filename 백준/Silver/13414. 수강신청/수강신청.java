import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int K, L;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        K = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        Queue<String> q = new LinkedList<>();
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < L; i++) {
            String studentNumber = br.readLine();
            map.put(studentNumber, map.getOrDefault(studentNumber, 0) + 1);
            q.add(studentNumber);
        }

        StringBuilder sb = new StringBuilder();
        while (!q.isEmpty()) {
            String cur = q.poll();

            int requestCount = map.get(cur);

            if (requestCount > 1) {
                map.put(cur, requestCount - 1);
            } else {
                sb.append(cur).append("\n");
                K--;
                // K만큼 뽑았으면 그만
                if (K == 0) break;
            }
        }

        sb.deleteCharAt(sb.length() - 1);

        System.out.print(sb);
    }
}
