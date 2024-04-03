import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<Integer>[] list = new ArrayList[n + 1];
        int[] count = new int[n + 1];
        for (int i = 1; i <= n; i++) list[i] = new ArrayList<>();

        StringBuilder sb = new StringBuilder();
        int sequenceCount = 0;
        for (int t = 0; t < m; t++) {
            st = new StringTokenizer(br.readLine());
            st.nextToken();
            int prev = Integer.parseInt(st.nextToken());

            while (st.hasMoreTokens()) {
                int next = Integer.parseInt(st.nextToken());

                list[prev].add(next);
                count[next]++;
                prev = next;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if (count[i] == 0) q.add(i);
        }

        while (!q.isEmpty()) {
            int current = q.poll();

            sb.append(current).append("\n");
            sequenceCount++;

            for (int next : list[current]) {
                count[next]--;

                if (count[next] == 0) q.add(next);
            }
        }

        if (sb.length() > 0) {
            sb.deleteCharAt(sb.length() - 1);
        }

        System.out.print(sequenceCount == n ? sb : "0");
    }
}
