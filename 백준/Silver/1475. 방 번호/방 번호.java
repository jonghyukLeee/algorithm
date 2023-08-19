import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char [] input = br.readLine().toCharArray();

        int [] numberCnt = new int[9];
        for (char c: input) {
            int n = c - '0';
            if (n == 9) numberCnt[6]++;
            else numberCnt[n]++;
        }

        int tmpValue = numberCnt[6] / 2;
        tmpValue += numberCnt[6] % 2 > 0 ? 1 : 0;

        numberCnt[6] = tmpValue;

        int maxCount = Integer.MIN_VALUE;
        for (int i = 0; i < 9; i++) {
            maxCount = Math.max(maxCount, numberCnt[i]);
        }

        System.out.print(maxCount);
    }
}
