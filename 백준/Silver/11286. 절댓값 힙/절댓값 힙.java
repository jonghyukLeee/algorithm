import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                int absNumber1 = Math.abs(o1);
                int absNumber2 = Math.abs(o2);

                if (absNumber1 == absNumber2) return o1 - o2;
                else return absNumber1 - absNumber2;
            }
        });

        StringBuilder sb = new StringBuilder();
        while (n-- > 0) {
            int inputNumber = Integer.parseInt(br.readLine());

            if (inputNumber == 0) sb.append(pq.isEmpty() ? "0" : pq.poll()).append("\n");
            else pq.add(inputNumber);
        }

        sb.deleteCharAt(sb.length() - 1);
        System.out.print(sb);
    }
}
