import java.util.*;
import java.io.*;

class Score {
    int score;
    int index;

    public Score(int score, int index) {
        this.score = score;
        this.index = index;
    }
}
public class Main {
    static int n;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        int[] total = new int[n];

        PriorityQueue<Score> pq = new PriorityQueue<>((o1, o2) -> o1.score - o2.score);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                int score = Integer.parseInt(input[j]);
                pq.add(new Score(score, j));
                total[j] += score;
            }
            calc(pq, sb);
        }

        for (int i = 0; i < n; i++) {
            pq.add(new Score(total[i], i));
        }

        calc(pq, sb);
        sb.deleteCharAt(sb.length() - 1);
        System.out.print(sb.toString());
    }

    static void calc(PriorityQueue<Score> pq, StringBuilder sb) {
        int[] rankArray = new int[n];

        while (!pq.isEmpty()) {
            Score cur = pq.poll();
            int rank = 1;
            Queue<Integer> q = new LinkedList<>();
            q.add(cur.index);

            while (!pq.isEmpty() && cur.score == pq.peek().score) {
                Score next = pq.poll();
                q.add(next.index);
            }

            rank += pq.size();

            while (!q.isEmpty()) {
                rankArray[q.poll()] = rank;
            }
        }

        for (int idx = 0; idx < n; idx++) {
            sb.append(rankArray[idx]);
            if (idx < n - 1) sb.append(" ");
        }
        sb.append("\n");
    }
}