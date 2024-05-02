import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int step = 1;
        int startValue = 2;
        while (n >= startValue) {
            startValue += (step++ * 6);
        }

        System.out.print(step);
    }
}
