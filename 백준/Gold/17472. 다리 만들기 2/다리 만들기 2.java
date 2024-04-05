import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Land {
    int x, y, group;
    int direction, bridgeLength;

    public Land(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Land(int x, int y, int group, int direction, int bridgeLength) {
        this.x = x;
        this.y = y;
        this.group = group;
        this.direction = direction;
        this.bridgeLength = bridgeLength;
    }
}
public class Main {
    static int N, M;
    static int[][] map;
    static boolean[][][] isVisited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static Queue<Land> q;
    static List<Land>[] list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        isVisited = new boolean[5][N][M]; // idx 4는 그룹핑용
        q = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 그룹핑
        int groupIndex = 1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 1 && !isVisited[4][i][j]) {
                    mark(i, j, groupIndex);
                    groupIndex++;
                }
            }
        }
        list = new ArrayList[groupIndex];
        for (int i = 1; i < groupIndex; i++) list[i] = new ArrayList<>();

        // 다리 놓기
        while (!q.isEmpty()) {
            Land current = q.poll();

            int mx = current.x + dx[current.direction];
            int my = current.y + dy[current.direction];

            if (isValid(mx, my) && !isVisited[current.direction][mx][my] && map[mx][my] != current.group) {
                // 섬 도착
                if (map[mx][my] > 0) {
                    if (current.bridgeLength > 1) list[current.group].add(new Land(map[mx][my], current.bridgeLength));
                }
                // 바다
                else {
                    isVisited[current.direction][mx][my] = true;
                    q.add(new Land(mx, my, current.group, current.direction, current.bridgeLength + 1));
                }
            }
        }

        // 최소 다리 길이 계산
        boolean[] visited = new boolean[groupIndex];
        PriorityQueue<Land> pq = new PriorityQueue<>((o1, o2) -> {
            return o1.y - o2.y;
        });
        pq.add(new Land(1, 0));

        int answer = 0;
        while (!pq.isEmpty()) {
            Land current = pq.poll();
            int n = current.x;

            if (!visited[n]) {
                visited[n] = true;
                answer += current.y;

                for (Land next: list[n]) {
                    if (!visited[next.x]) {
                        pq.add(next);
                    }
                }
            }
        }

        for (int i = 1; i < groupIndex; i++) {
            if (!visited[i]) {
                answer = -1;
                break;
            }
        }
        System.out.print(answer);
    }
    static void mark(int x, int y, int group) {
        Queue<Land> tmpQ = new LinkedList<>();
        tmpQ.add (new Land(x, y));
        isVisited[4][x][y] = true;

        while (!tmpQ.isEmpty()) {
            Land current = tmpQ.poll();
            map[current.x][current.y] = group;

            for (int i = 0; i < 4; i++) {
                q.add(new Land(current.x, current.y, group, i, 0));
                int mx = current.x + dx[i];
                int my = current.y + dy[i];

                if (isValid(mx, my) && map[mx][my] > 0 && !isVisited[4][mx][my]) {
                    isVisited[4][mx][my] = true;
                    tmpQ.add(new Land(mx, my));
                }
            }
        }

    }

    static boolean isValid(int x, int y) {
        return x >= 0 && y >= 0 && x < N && y < M;
    }
}
