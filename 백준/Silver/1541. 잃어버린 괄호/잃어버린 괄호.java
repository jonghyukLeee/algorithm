import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), "-");

        int total = getSum(st.nextToken());
        while (st.hasMoreTokens()) {
            String next = st.nextToken();
            total -= getSum(next);
        }

        System.out.print(total);
    }

    static int getSum(String str) {
        String[] splitByPlus = str.split("\\+");

        int total = 0;
        for (String numberString: splitByPlus) {
            total += Integer.parseInt(numberString);
        }

        return total;
    }
}
