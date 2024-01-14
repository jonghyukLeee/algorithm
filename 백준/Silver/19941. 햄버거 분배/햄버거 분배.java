import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, K;
    static char[] map;
    static boolean[] isVisited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = br.readLine().toCharArray();
        isVisited = new boolean[N];

        int eatCount = 0;
        int mapLength = map.length;
        for (int i = 0; i < mapLength; i++) {
            if (map[i] == 'P') {
                if (eat(i, K)) eatCount++;
            }
        }

        System.out.print(eatCount);
    }
    static boolean eat(int location, int distance) {
        boolean isDone = false;
        // left
        for (int i = location - distance; i < location; i++) {
            if (isValid(i)) {
                isVisited[i] = true;
                isDone = true;
                break;
            }
        }
        if (!isDone) {
            // right
            for (int i = location + 1; i <= location + distance; i++) {
                if (isValid(i)) {
                    isVisited[i] = true;
                    isDone = true;
                    break;
                }
            }
        }
        return isDone;
    }

    static boolean isValid(int idx) {
        return idx >= 0 && idx < N && map[idx] == 'H' && !isVisited[idx];
    }
}
