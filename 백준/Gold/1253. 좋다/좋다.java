import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        long[] numberArray = new long[n];

        StringTokenizer st = new StringTokenizer(br.readLine());


        for (int i = 0; i < n; i++) {
            numberArray[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(numberArray);

        int answer = 0;
        for (int i = 0; i < n; i++) {
            long currentNumber = numberArray[i];

            int start = 0, end = n - 1;

            while (start < end) {
                long sum = numberArray[start] + numberArray[end];

                if (sum == currentNumber) {
                    if (start != i && end != i) {
                        answer++;
                        break;
                    } else if (start == i) {
                        start++;
                    } else {
                        end--;
                    }
                }
                else if (sum < currentNumber) {
                    start++;
                } else {
                    end--;
                }
            }
        }

        System.out.print(answer);
    }
}
