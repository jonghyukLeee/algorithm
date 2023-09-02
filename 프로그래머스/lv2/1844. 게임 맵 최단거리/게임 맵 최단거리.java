import java.util.LinkedList;
import java.util.Queue;

class ROR {
    int x, y;
    int moveCount;

    public ROR(int x, int y, int moveCount) {
        this.x = x;
        this.y = y;
        this.moveCount = moveCount;
    }
}
class Solution {
    static int N, M;
    static int answer = Integer.MAX_VALUE;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] isVisited;
    static Queue<ROR> q = new LinkedList<>();
    
    public int solution(int[][] maps) {
        N = maps.length;
        M = maps[0].length;
        isVisited = new int[N][M];

        q.add(new ROR(0, 0, 1));
        isVisited[0][0] = 1;

        while (!q.isEmpty()) {
            ROR cur = q.poll();

            if (cur.x == N - 1 && cur.y == M - 1) {
                answer = Math.min(answer, cur.moveCount);
                continue;
            }

            for (int idx = 0; idx < 4; idx++) {
                int mx = cur.x + dx[idx];
                int my = cur.y + dy[idx];

                if (isValid(mx, my) && maps[mx][my] > 0 && isBestWay(mx, my, cur.moveCount)) {
                    isVisited[mx][my] = cur.moveCount;
                    q.add(new ROR(mx, my, cur.moveCount + 1));
                }
            }
        }

        return answer == Integer.MAX_VALUE ? -1 : answer;
    }
    static boolean isValid(int x, int y) {
        return x >= 0 && y >= 0 && x < N && y < M;
    }

    static boolean isBestWay(int x, int y, int currentCount) {
        return isVisited[x][y] < 1 || isVisited[x][y] > currentCount;
    }
}