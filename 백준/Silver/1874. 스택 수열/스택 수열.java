import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int count = 1;
        boolean isDone = false;
        while (N-- > 0) {
            int next = Integer.parseInt(br.readLine());
            if (!isDone) {
                while (count <= next) {
                    stack.push(count++);
                    sb.append("+\n");
                }

                if (stack.peek() != next) {
                    sb = new StringBuilder("NO");
                    isDone = true;
                } else {
                    sb.append("-\n");
                    stack.pop();
                }
            }
        }
        
        if (!sb.toString().equals("NO")) {
            sb.deleteCharAt(sb.length() - 1);
        }

        System.out.print(sb);
    }
}
