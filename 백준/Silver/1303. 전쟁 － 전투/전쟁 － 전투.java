import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] map;
    static boolean[][] isVisited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        isVisited = new boolean[N][M];
        int[] answer = new int[2];

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < M; j++) {
                char c = input.charAt(j);
                map[i][j] = c == 'W' ? 0 : 1;
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!isVisited[i][j]) {
                    isVisited[i][j] = true;
                    int team = map[i][j];
                    answer[team] += bfs(team, i, j);
                }
            }
        }

        System.out.printf("%d %d", answer[0], answer[1]);
    }

    static int bfs(int team, int i, int j) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{i, j});
        int count = 0;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            count++;

            int x = cur[0];
            int y = cur[1];

            for (int dir = 0; dir < 4; dir++) {
                int mx = x + dx[dir];
                int my = y + dy[dir];

                if (isValid(mx, my) && !isVisited[mx][my] && map[mx][my] == team) {
                    isVisited[mx][my] = true;
                    q.add(new int[]{mx ,my});
                }
            }
        }

        return (int)Math.pow(count, 2);
    }

    static boolean isValid(int x, int y) {
        return x >= 0 && y >= 0 && x < N && y < M;
    }
}
