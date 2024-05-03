import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine().toUpperCase();

        int[] count = new int[26];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < input.length(); i++) {
            int idx = input.charAt(i) - 65;
            count[idx]++;

            max = Math.max(max, count[idx]);
        }

        char answer = 'A';
        int maxCount = 0;
        for (int i = 0; i < 26; i++) {
            if (count[i] == max) {
                maxCount++;
                answer = (char)(i + 65);
            }
        }

        if (maxCount > 1) answer = '?';

        System.out.print(answer);
    }
}
