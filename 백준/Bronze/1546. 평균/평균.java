import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        int max = Integer.MIN_VALUE;

        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Integer> scoreList = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            int currentScore = Integer.parseInt(st.nextToken());
            max = Math.max(max, currentScore);

            scoreList.add(currentScore);
        }

        double total = 0.0;

        for (int score: scoreList) {
            total += calc(max, score);
        }

        System.out.print(total / N);

    }

    static double calc(int max, int score) {
        double result = ((double) score / max) * 100;
        return ((double) Math.round(result * 100)) / 100;
    }
}
