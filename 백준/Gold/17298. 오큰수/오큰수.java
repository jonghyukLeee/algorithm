import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] inputArray = new int[n];
        int[] answerArray = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) inputArray[i] = Integer.parseInt(st.nextToken());

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            int currentNumber = inputArray[i];

            while (!stack.isEmpty() && inputArray[stack.peek()] < currentNumber) {
                answerArray[stack.pop()] = currentNumber;
            }

            stack.push(i);
        }

        while (!stack.isEmpty()) {
            answerArray[stack.pop()] = -1;
        }

        StringBuilder sb = new StringBuilder();

        for (int nge : answerArray) {
            sb.append(nge).append(" ");
        }

        sb.deleteCharAt(sb.length() - 1);
        System.out.print(sb);
    }
}
