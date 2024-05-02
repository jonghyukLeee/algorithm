import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int myScore = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        if (n > 0) st = new StringTokenizer(br.readLine());

        int minScore = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int nextScore = Integer.parseInt(st.nextToken());
            pq.add(nextScore);
            minScore = Math.min(minScore, nextScore);
        }

        int rank = 1;
        if (n == p && minScore >= myScore) {
            rank = -1;
        } else {
            while (!pq.isEmpty()) {
                if (pq.poll() > myScore) rank++;
                else break;
            }
        }

        System.out.print(rank);
    }
}
