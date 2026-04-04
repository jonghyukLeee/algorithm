import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

class Shark implements Comparable<Shark>{
    int x, y;
    int dist;
    int size;

    Shark(int x, int y, int size, int dist) {
        this.x = x;
        this.y = y;
        this.size = size;
        this.dist = dist;
    }

    public void move(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void feed() {
        this.size += 1;
    }

    @Override
    public int compareTo(Shark s) {
        if(this.dist == s.dist) {
            if(this.x == s.x) return this.y - s.y;
            return this.x - s.x;
        }
        return this.dist - s.dist;
    }
}

public class Main {
    static int N;
    static int[][] map;
    static Shark shark;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int ateCount;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int n = Integer.parseInt(st.nextToken());
                map[i][j] = n;
                if (map[i][j] == 9) {
                    shark = new Shark(i, j, 2, 0);
                    map[i][j] = 0;
                }
            }
        }

        int answer = 0;
        while(true) {
            PriorityQueue<Shark> result = find();

            if(result.isEmpty()) break;
            Shark food = result.poll();
            shark.move(food.x, food.y);
            answer += food.dist;
            map[food.x][food.y] = 0;
            ateCount++;
            if(ateCount == shark.size) {
                shark.feed();
                ateCount = 0;
            }
        }

        System.out.print(answer);
    }

    static PriorityQueue<Shark> find() {
        Queue<Shark> q = new LinkedList<>();
        q.add(shark);
        PriorityQueue<Shark> pq = new PriorityQueue<>();
        boolean[][] isVisited = new boolean[N][N];
        isVisited[shark.x][shark.y] = true;

        while (!q.isEmpty()) {
            Shark cur = q.poll();

            if(map[cur.x][cur.y] > 0 && shark.size > map[cur.x][cur.y]) {
                pq.add(cur);
                continue;
            }

            for(int idx = 0; idx < 4; idx++) {
                int mx = cur.x + dx[idx];
                int my = cur.y + dy[idx];

                if(isValid(mx, my) && !isVisited[mx][my] && map[mx][my] <= shark.size) {
                    isVisited[mx][my] = true;
                    q.add(new Shark(mx, my, cur.size, cur.dist + 1));
                }
            }
        }

        return pq;
    }

    static boolean isValid(int x, int y) {
        return x >= 0 && y >= 0 && x < N && y < N;
    }
}
