import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        int[] inputArray = new int[n];
        int[] d = new int[n];
        st = new StringTokenizer(br.readLine());
        Deque<Integer> dq = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            inputArray[i] = Integer.parseInt(st.nextToken());
            int minIdx = i - l + 1;

            while (!dq.isEmpty() && dq.peekFirst() < minIdx) dq.pollFirst();

            while (!dq.isEmpty() && inputArray[dq.peekLast()] > inputArray[i]) dq.pollLast();

            dq.addLast(i);
            d[i] = inputArray[dq.peekFirst()];
        }

        StringBuilder sb = new StringBuilder();
        for (int number: d) {
            sb.append(number).append(" ");
        }

        sb.deleteCharAt(sb.length() - 1);
        System.out.print(sb);
    }
}
