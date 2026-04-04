import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Snake {
    int x, y;
    int dir;

    Snake(int x, int y, int dir) {
        this.x = x;
        this.y = y;
        this.dir = dir;
    }

    public void changeDir(int d) {
        this.dir = d == 0 ? ((dir + 3) % 4) : ((dir + 1) % 4);
    }
}

// 1: 사과 2: 뱀
public class Main {
    static int N;
    static int[][] map;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static ArrayDeque<Snake> snake;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N + 1][N + 1];
        int k = Integer.parseInt(br.readLine());
        snake = new ArrayDeque<>();
        snake.addFirst(new Snake(1, 1, 0));
        map[1][1] = 2;

        StringTokenizer st;
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            map[x][y] = 1;
        }

        int l = Integer.parseInt(br.readLine());
        Queue<int[]> cmd = new LinkedList<>();
        for (int i = 0; i < l; i++) {
            // L = 0, D = 1

            st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());
            int dir = st.nextToken().equals("L") ? 0 : 1;
            cmd.add(new int[]{time, dir});
        }

        int time = 0;
        while (true) {
            time++;

            Snake head = snake.peekFirst();
            int dir = head.dir;
            int mx = head.x + dx[dir];
            int my = head.y + dy[dir];

            if (!isValid(mx, my) || map[mx][my] == 2) break;
            else if (map[mx][my] < 1) {
                Snake tail = snake.pollLast();
                map[tail.x][tail.y] = 0;
            }

            snake.addFirst(new Snake(mx, my, dir));
            map[mx][my] = 2;

            if (!cmd.isEmpty() && cmd.peek()[0] == time) {
                int[] command = cmd.poll();
                Snake newHead = snake.pollFirst();
                newHead.changeDir(command[1]);
                snake.addFirst(newHead);
            }
        }

        System.out.print(time);
    }


    static boolean isValid(int x, int y) {
        return x > 0 && x <= N && y > 0 && y <= N;
    }
}
