import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Moon {
    int x, y;
    int keys;
    int count;

    public Moon(int x, int y, int keys, int count) {
        this.x = x;
        this.y = y;
        this.keys = keys;
        this.count = count;
    }

    public Moon(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public boolean canMove(char door) {
        int toBit = 1 << (door - 65);
        return (keys & toBit) != 0;
    }
}

public class Main {
    static int N, M;
    static char[][] map;
    static Moon start;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static boolean[][][] isVisited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        isVisited = new boolean[1 << 6][N][M];

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < M; j++) {
                char c = input.charAt(j);
                if (c == '0') {
                    start = new Moon(i, j);
                    c = '.';
                }

                map[i][j] = c;
            }
        }

        Queue<Moon> q = new LinkedList<>();
        q.add(start);
        isVisited[0][start.x][start.y] = true;

        int answer = -1;
        while (!q.isEmpty()) {
            Moon cur = q.poll();

            if(map[cur.x][cur.y] == '1') {
                answer = cur.count;
                break;
            }

            for (int idx = 0; idx < 4; idx++) {
                int mx = cur.x + dx[idx];
                int my = cur.y + dy[idx];

                if (isValid(mx, my) && map[mx][my] != '#' && !isVisited[cur.keys][mx][my]) {
                    int keys = cur.keys;
                    isVisited[keys][mx][my] = true;
                    char next = map[mx][my];
                    if (next >= 97 && next <= 102) {
                        int newKey = 1 << (next - 97);
                        keys |= newKey;
                        isVisited[keys][mx][my] = true;
                    } else if (next >= 65 && next <= 70) {
                        if (!cur.canMove(next)) continue;
                    }

                    q.add(new Moon(mx, my, keys, cur.count + 1));
                }
            }
        }

        System.out.print(answer);
    }

    static boolean isValid(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < M;
    }
}
