import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Cctv {
    int n;
    int x, y;

    public Cctv(int n, int x, int y) {
        this.n = n;
        this.x = x;
        this.y = y;
    }
}

public class Main {
    static int N, M;
    static List<Cctv> cctv;
    static int size;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][][] directionList = {
            {},
            {{0}, {1}, {2}, {3}},
            {{0, 1}, {2, 3}},
            {{0, 2}, {0, 3}, {1, 2}, {1, 3}},
            {{0, 1, 2}, {0, 1, 3}, {0, 2, 3}, {1, 2, 3}},
            {{0, 1, 2, 3}},
    };
    static int MIN;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][M];
        cctv = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 0) MIN++;
                if (map[i][j] > 0 && map[i][j] < 6) {
                    cctv.add(new Cctv(map[i][j], i, j));
                    size++;
                }
            }
        }
        dfs(0, map);

        System.out.print(MIN);
    }

    static void dfs(int cIdx, int[][] curMap) {
        if (cIdx == size) {
            MIN = Math.min(MIN, count(curMap));
            return;
        }

        Cctv cur = cctv.get(cIdx);

        for (int[] dir : directionList[cur.n]) {
            int[][] copiedMap = copy(curMap);
            watch(copiedMap, cur, dir);
            dfs(cIdx + 1, copiedMap);
        }

    }

    static int[][] copy(int[][] map) {
        int[][] copied = new int[N][M];

        for (int i = 0; i < N; i++) {
            System.arraycopy(map[i], 0, copied[i], 0, M);
        }

        return copied;
    }

    static void watch(int[][] curMap, Cctv cctv, int[] dir) {
        for (int d : dir) {
            int mx = cctv.x + dx[d];
            int my = cctv.y + dy[d];

            while (isValid(mx, my) && curMap[mx][my] < 6) {
                if (curMap[mx][my] == 0) curMap[mx][my] = -1;
                mx += dx[d];
                my += dy[d];
            }
        }
    }

    static boolean isValid(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < M;
    }

    static int count(int[][] map) {
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) count++;
            }
        }

        return count;
    }
}
