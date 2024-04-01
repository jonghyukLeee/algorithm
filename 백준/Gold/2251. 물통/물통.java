import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

class Bucket {
    int a, b;

    public Bucket(int a, int b) {
        this.a = a;
        this.b = b;
    }
}
public class Main {
    static int[] from = {0, 0, 1, 1, 2, 2};
    static int[] to = {1, 2, 0, 2, 0, 1};
    static boolean[][] isVisited;
    static int[] maxAmount;
    static Queue<Bucket> q;
    static PriorityQueue<Integer> answerQ;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        maxAmount = new int[3];
        maxAmount[0] = Integer.parseInt(st.nextToken());
        maxAmount[1] = Integer.parseInt(st.nextToken());
        maxAmount[2] = Integer.parseInt(st.nextToken());
        isVisited = new boolean[maxAmount[0] + 1][maxAmount[1] + 1];
        answerQ = new PriorityQueue<>();

        q = new LinkedList<>();
        q.add(new Bucket(0, 0));
        isVisited[0][0] = true;
        answerQ.add(maxAmount[2]);

        while (!q.isEmpty()) {
            Bucket current = q.poll();
            int a = current.a;
            int b = current.b;
            int c = maxAmount[2] - a - b;

            for (int i = 0; i < 6; i++) {
                int[] next = {a, b, c};
                int fromIdx = from[i];
                int toIdx = to[i];

                next[toIdx] += next[fromIdx];
                next[fromIdx] = 0;

                if (next[toIdx] > maxAmount[toIdx]) {
                    next[fromIdx] += next[toIdx] - maxAmount[toIdx];
                    next[toIdx] = maxAmount[toIdx];
                }

                if (!isVisited[next[0]][next[1]]) {
                    isVisited[next[0]][next[1]] = true;
                    q.add(new Bucket(next[0], next[1]));
                    if (next[0] == 0) {
                        answerQ.add(next[2]);
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        while (!answerQ.isEmpty()) sb.append(answerQ.poll()).append(" ");
        sb.deleteCharAt(sb.length() - 1);
        System.out.print(sb);
    }

}
