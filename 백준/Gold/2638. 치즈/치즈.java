import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Cheese {
    int x,y;

    public Cheese(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
public class Main {
    static int N, M;
    static int[][] map;
    static boolean[][] isDone;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static Queue<Cheese> cheese;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        isDone = new boolean[N][M];
        cheese = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) cheese.add(new Cheese(i, j));
            }
        }

        map[0][0] = -1;
        int answer = 0;

        while (!cheese.isEmpty()) {
            answer++;
            cheese();
        }

        System.out.print(answer);
    }

    static void cheese() {
        setOutside();
        melt();
    }

    static void setOutside() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == -1 && !isDone[i][j]) {
                    bfs(i, j);
                }
            }
        }
    }

    static void bfs(int x, int y) {
        Queue<Cheese> q = new LinkedList<>();
        q.add(new Cheese(x, y));
        isDone[x][y] = true;

        while (!q.isEmpty()) {
            Cheese cur = q.poll();

            map[cur.x][cur.y] = -1;

            for (int i = 0; i < 4; i++) {
                int mx = cur.x + dx[i];
                int my = cur.y + dy[i];

                if (isValid(mx, my) && !isDone[mx][my] && map[mx][my] < 1) {
                    isDone[mx][my] = true;
                    q.add(new Cheese(mx, my));
                }
            }
        }
    }

    static boolean isValid(int x, int y) {
        return x >= 0 && y >= 0 && x < N && y < M;
    }

    static void melt() {
        Queue<Cheese> newQ = new LinkedList<>();

        while (!cheese.isEmpty()) {
            Cheese cur = cheese.poll();

            int count = 0;

            for (int i = 0; i < 4; i++) {
                int mx = cur.x + dx[i];
                int my = cur.y + dy[i];

                if (isValid(mx, my) && map[mx][my] == -1 && isDone[mx][my]) {
                    count++;
                }
            }

            if (count >= 2) {
                map[cur.x][cur.y] = -1;
            } else {
                newQ.add(new Cheese(cur.x, cur.y));
            }
        }

        cheese = new LinkedList<>(newQ);
    }
}
