import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Point {
    int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
public class Main {
    static char[][] map;
    static int x, y;
    static int n, m;
    static boolean[][] isVisited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new char[n][m];
        isVisited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            String input = br.readLine();

            for (int j = 0; j < m; j++) {
                char current = input.charAt(j);
                if (current == 'I') {
                    x = i;
                    y = j;
                }
                map[i][j] = current;

            }
        }

        Queue<Point> q = new LinkedList<>();

        q.add(new Point(x, y));
        isVisited[x][y] = true;
        int answerCount = 0;

        while (!q.isEmpty()) {
            Point cur = q.poll();

            for (int i = 0; i < 4; i++) {
                int mx = cur.x + dx[i];
                int my = cur.y + dy[i];

                if (isValid(mx, my) && !isVisited[mx][my] && map[mx][my] != 'X') {
                    if (map[mx][my] == 'P') {
                        answerCount++;
                    }

                    q.add(new Point(mx, my));
                    isVisited[mx][my] = true;
                }
            }
        }

        System.out.print(answerCount > 0 ? answerCount : "TT");
    }

    static boolean isValid(int x, int y) {
        return x >= 0 && y >= 0 && x < n && y < m;
    }
}
