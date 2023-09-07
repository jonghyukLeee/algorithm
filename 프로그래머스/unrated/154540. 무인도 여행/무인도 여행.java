import java.util.*;
class Island {
    int x, y;
    
    public Island(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
class Solution {
    static Queue<Island> q;
    static char[][] map;
    static int N, M;
    static boolean[][] isVisited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static Queue<Integer> pq;
    public int[] solution(String[] maps) {
        int[] answer;
        N = maps.length;
        M = maps[0].length();
        q = new LinkedList<>();
        pq = new PriorityQueue<>();
        
        map = new char[N][M];
        for (int i = 0; i < N; i++) {
            map[i] = maps[i].toCharArray();
        }
        
        isVisited = new boolean[N][M];
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!isVisited[i][j] && map[i][j] != 'X') {
                    isVisited[i][j] = true;
                    search(i, j);
                }
            }
        }
        
        if (pq.isEmpty()) {
            pq.add(-1);
        }
        int answerIdx = 0;
        int answerSize = pq.size();
        answer = new int[answerSize];
        
        while (!pq.isEmpty()) {
            answer[answerIdx++] = pq.poll();
        }
        return answer;
    }
    static void search(int i, int j) {
        int sum = 0;
        q.add(new Island(i, j));
        
        while (!q.isEmpty()) {
            Island cur = q.poll();
            
            sum += map[cur.x][cur.y] -'0';
            
            for (int idx = 0; idx < 4; idx++) {
                int mx = cur.x + dx[idx];
                int my = cur.y + dy[idx];
                
                if (isValid(mx, my) && !isVisited[mx][my] && map[mx][my] != 'X') {
                    isVisited[mx][my] = true;
                    q.add(new Island(mx, my));
                }
            }
        }
        pq.add(sum);
    }
    static boolean isValid(int x, int y) {
        return x >= 0 && y >= 0 && x < N && y < M;
    }
}