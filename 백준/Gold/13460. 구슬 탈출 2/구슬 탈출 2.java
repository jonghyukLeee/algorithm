import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Ball {
    int bx, by;
    int rx, ry;
    int count;

    public Ball(int bx, int by, int rx, int ry, int count) {
        this.bx = bx;
        this.by = by;
        this.rx = rx;
        this.ry = ry;
        this.count = count;
    }
}

public class Main {
    static int N, M;
    static char[][] map;
    static boolean[][][][] isVisited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        isVisited = new boolean[N][M][N][M];

        int[] bxy = new int[2];
        int[] rxy = new int[2];
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < M; j++) {
                char c = input.charAt(j);
                map[i][j] = c;
                if (c == 'B') {
                    bxy[0] = i;
                    bxy[1] = j;
                } else if (c == 'R') {
                    rxy[0] = i;
                    rxy[1] = j;
                }
            }
        }

        Queue<Ball> q = new LinkedList<>();
        q.add(new Ball(bxy[0], bxy[1], rxy[0], rxy[1], 0));
        int answer = Integer.MAX_VALUE;

        while (!q.isEmpty()) {
            Ball cur = q.poll();
            if(cur.count >= answer || map[cur.bx][cur.by] == 'O' || cur.count > 9) continue;

            for (int dir = 0; dir < 4; dir++) {
                int[] r = move(cur.rx, cur.ry, dir);
                int[] b = move(cur.bx, cur.by, dir);

                if(map[b[0]][b[1]] == 'O') continue;
                else if(map[r[0]][r[1]] == 'O') {
                    answer = Math.min(answer, cur.count + 1);
                    continue;
                }
                if (r[0] == b[0] && r[1] == b[1]) {
                    if (dir == 0) {
                        if (cur.rx < cur.bx) b[0]++;
                        else r[0]++;
                    } else if (dir == 1) {
                        if (cur.rx < cur.bx) r[0]--;
                        else b[0]--;
                    } else if (dir == 2) {
                        if (cur.ry < cur.by) b[1]++;
                        else r[1]++;
                    } else {
                        if (cur.ry < cur.by) r[1]--;
                        else b[1]--;
                    }
                }

                if(!isVisited[b[0]][b[1]][r[0]][r[1]]) {
                    isVisited[b[0]][b[1]][r[0]][r[1]] = true;
                    q.add(new Ball(b[0], b[1], r[0], r[1], cur.count + 1));
                }
            }
        }

        System.out.print(answer != Integer.MAX_VALUE ? answer : -1);
    }

    static int[] move(int x, int y, int dir) {
        int rx = x;
        int ry = y;

        int mx = x + dx[dir];
        int my = y + dy[dir];
        while (isValid(mx, my) && map[mx][my] != '#') {
            rx = mx;
            ry = my;
            if(map[rx][ry] == 'O') break;
            mx += dx[dir];
            my += dy[dir];
        }

        return new int[]{rx, ry};
    }

    static boolean isValid(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < M;
    }
}
