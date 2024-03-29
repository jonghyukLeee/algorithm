import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Queue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            pq.add(Integer.parseInt(br.readLine()));
        }

        int answer = 0;

        //값이 2개 이상이면 진행
        while (pq.size() > 1) {
            int fst = pq.poll();
            int sec = pq.poll();

            int sum = fst + sec;
            answer += sum;
            pq.add(sum);
        }

        System.out.print(answer);
    }
}
