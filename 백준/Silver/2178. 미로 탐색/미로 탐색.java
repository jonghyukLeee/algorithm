import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Maze {
    int x, y;
    int moveCount;

    public Maze(int x, int y, int moveCount) {
        this.x = x;
        this.y = y;
        this.moveCount = moveCount;
    }
}
public class Main {
    static int N, M;
    static char[][] map;
    static int[][] minCount;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        minCount = new int[N][M];

        for (int[] countArray: minCount) Arrays.fill(countArray, Integer.MAX_VALUE);

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = input.charAt(j);
            }
        }

        Queue<Maze> q = new LinkedList<>();
        q.add(new Maze(0, 0, 1));

        while (!q.isEmpty()) {
            Maze current = q.poll();

            if (current.x == N - 1 && current.y == M - 1) continue;

            for (int i = 0; i < 4; i++) {
                int mx = current.x + dx[i];
                int my = current.y + dy[i];

                int nextMoveCount = current.moveCount + 1;
                if (isValid(mx, my) && map[mx][my] == '1' && minCount[mx][my] > nextMoveCount) {
                    minCount[mx][my] = nextMoveCount;
                    q.add(new Maze(mx, my, nextMoveCount));
                }
            }
        }

        System.out.print(minCount[N - 1][M - 1]);
    }
    static boolean isValid(int x, int y) {
        return x >= 0 && y >= 0 && x < N && y < M;
    }
}
