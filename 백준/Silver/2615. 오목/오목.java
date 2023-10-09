import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int [][] map;
    static boolean[][] isVisited;
    static int[] dx = {0, -1, -1, -1, 0, 1, 1, 1};
    static int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int answerX, answerY, answerColor;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        map = new int[19][19];
        isVisited = new boolean[19][19];
        for (int i = 0; i < 19; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < 19; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        loop: for (int i = 0; i < 19; i++) {
            for (int j = 0; j < 19; j++) {
                if (map[j][i] > 0 && !isVisited[j][i]) {
                    isVisited[j][i] = true;
                    findDirection(j, i);
                    if (answerColor > 0) break loop;
                }
            }
        }

        if (answerColor == 0) System.out.print(0);
        else {
            System.out.printf("%d\n%d %d", answerColor, answerX + 1, answerY + 1);
        }
    }
    static void findDirection(int i, int j) {
        int color = map[i][j];
        for (int idx = 0; idx < 8; idx++) {
            int mx = i + dx[idx];
            int my = j + dy[idx];

            if (isValid(mx, my) && map[mx][my] > 0 && !isVisited[mx][my] && map[mx][my] == color) {
                search(mx, my, idx, 2);
                if (answerColor > 0) {
                    if (!isSix(i, j, idx, color)) {
                        answerX = i;
                        answerY = j;
                        break;
                    }
                    answerColor = 0;
                }
            }
        }
    }
    static boolean isSix(int i, int j, int dir, int color) {
        int opposite = (dir + 4) % 8;
        int x = i + dx[opposite];
        int y = j + dy[opposite];

        return (isValid(x, y) && map[x][y] == color);
    }
    static void search(int i, int j, int dir, int count) {
        int color = map[i][j];
        int x = i + dx[dir];
        int y = j + dy[dir];
        while (isValid(x, y) && map[x][y] > 0 && !isVisited[x][y] && map[x][y] == color) {
            x += dx[dir];
            y += dy[dir];
            count++;
        }
        if (count == 5) {
            answerColor = color;
        }
    }

    static boolean isValid(int x, int y) {
        return x >= 0 && y >= 0 && x < 19 && y < 19;
    }
}
