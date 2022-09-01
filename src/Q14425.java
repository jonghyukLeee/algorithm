import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q14425 {
    static int N, M;
    static Set<String> set;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        set = new HashSet<>();

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            set.add(input);
        }

        int answer = 0;
        for (int i = 0; i < M; i++) {
            String input = br.readLine();
            if (set.contains(input)) answer++;
        }
        System.out.print(answer);
    }
}
