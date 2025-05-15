import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] input = br.readLine().toCharArray();

        int oneCount = 0, zeroCount = 0;
        for (char c: input) {
            if (c == '1') oneCount++;
            else zeroCount++;
        }

        int removeOneCount = oneCount / 2, removeZeroCount = zeroCount / 2;

        StringBuilder removeOneBuilder = new StringBuilder();
        for (char c: input) {
            if (removeOneCount > 0 && c == '1') {
                removeOneCount--;
            } else {
                removeOneBuilder.append(c);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = removeOneBuilder.length() - 1; i >= 0; i--) {
            char c = removeOneBuilder.charAt(i);

            if (removeZeroCount > 0 && c == '0') {
                removeZeroCount--;
            } else {
                sb.append(c);
            }
        }

        System.out.print(sb.reverse());
    }
}
