import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] inputArray = br.readLine().toCharArray();

        char prevChar = '(';
        int left = 0, right = 0;
        int answer = 0;
        for (char c: inputArray) {
            if (c == '(') {
                left++;
            } else {
                left--;
                if (prevChar == '(') {
                    answer += left;
                } else {
                    answer++;
                }
            }

            prevChar = c;
        }

        System.out.print(answer);
    }
}
