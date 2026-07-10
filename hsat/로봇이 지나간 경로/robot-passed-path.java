import java.util.*;
import java.io.*;

public class Main {
    static int H, W;
    static char[][] map;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        map = new char[H][W];
        visited = new boolean[H][W];

        for (int i = 0; i < H; i++) {
            String input = br.readLine();
            for (int j = 0; j < W; j++) {
                map[i][j] = input.charAt(j);
            }
        }

        int sx = 0;
        int sy = 0;
        int dir = 0;
        loop: for (int i = H - 1; i >= 0; i--) {
            for (int j = W - 1; j >= 0; j--) {
                if (map[i][j] == '#') {
                    int count = 0;
                    int tmpDir = 0;
                    for (int d = 0; d < 4; d++) {
                        int mx = i + dx[d];
                        int my = j + dy[d];

                        if (isValid(mx, my) && map[mx][my] == '#') {
                            count++;
                            tmpDir = d;
                            if (count > 1) break;
                        }
                    }

                    if (count == 1) {
                        sx = i;
                        sy = j;
                        dir = tmpDir;
                        break loop;
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(sx + 1).append(" ").append(sy + 1).append("\n");
        sb.append("^>v<".charAt(dir)).append("\n");

        while (true) {
            // 직진 가능
            if (canA(sx, sy, dir)) {
                mark(sx, sy, dir);
                sx += (dx[dir] * 2);
                sy += (dy[dir] * 2);
                sb.append("A");
            } else {
                int nextDir = rotate(sx, sy, dir);
                if (nextDir >= 0) {
                    int tmpDir = (dir + 1) % 4;
                    sb.append(tmpDir == nextDir ? "R" : "L");
                    dir = nextDir;
                } else break;
            }
        }

        System.out.print(sb.toString());
    }

    static boolean isValid(int x, int y) {
        return x >= 0 && y >= 0 && x < H && y < W;
    }

    static boolean canA(int x, int y, int dir) {
        int mx = x;
        int my = y;
        int moveCount = 0;
        for (int i = 0; i < 2; i++) {
            mx += dx[dir];
            my += dy[dir];
            if (isValid(mx, my) && map[mx][my] == '#' && !visited[mx][my]) {
                moveCount++;
            }
        }
        return moveCount == 2;
    }

    static int rotate(int x, int y, int dir) {
        int newDir = -1;
        for (int d = 0; d < 4; d++) {
            if (d != dir) {
                int mx = x + dx[d];
                int my = y + dy[d];

                if (isValid(mx, my) && map[mx][my] == '#' && !visited[mx][my]) {
                    newDir = d;
                }
            }
        }
        return newDir;
    }
    
    static void mark(int x, int y, int dir) {
        int mx = x;
        int my = y;
        for (int i = 0; i < 2; i++) {
            mx += dx[dir];
            my += dy[dir];
            visited[mx][my] = true;
        }
    }
}