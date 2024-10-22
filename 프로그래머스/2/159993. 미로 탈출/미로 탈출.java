import java.util.*;

class Location {
    int x, y;
    int count;
    boolean hasLever;
    
    public Location(int x, int y, int count, boolean hasLever) {
        this.x = x;
        this.y = y;
        this.count = count;
        this.hasLever = hasLever;
    }
    
    public int getLeverAsInt() {
        return this.hasLever ? 1 : 0;
    }
}
class Solution {
    static char[][] map;
    static int N, M;
    static Queue<Location> q;
    static boolean[][][] isVisited;
    static Location exit;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    
    public int solution(String[] maps) {
        int answer = -1;
        N = maps.length;
        M = maps[0].length();
        map = new char[N][M];
        isVisited = new boolean[2][N][M];
        q = new LinkedList<>();
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                map[i][j] = maps[i].charAt(j);
                if (map[i][j] == 'S') {
                    q.add(new Location(i, j, 0, false));
                    isVisited[0][i][j] = true;
                } else if (map[i][j] == 'E') {
                    exit = new Location(i, j, 0, false);
                }
            }
        }
        
        while (!q.isEmpty()) {
            Location cur = q.poll();
            
            if (cur.hasLever && cur.x == exit.x && cur.y == exit.y) {
                answer = cur.count;
                break;
            }
            
            for (int dir = 0; dir < 4; dir++) {
                int mx = cur.x + dx[dir];
                int my = cur.y + dy[dir];
                
                if (isValid(mx, my) && !isVisited[cur.getLeverAsInt()][mx][my] && map[mx][my] != 'X') {
                    isVisited[cur.getLeverAsInt()][mx][my] = true;
                    
                    if (map[mx][my] == 'L') {
                        isVisited[1][mx][my] = true;
                        q.add(new Location(mx, my, cur.count + 1, true));
                    } else {
                        q.add(new Location(mx, my, cur.count + 1, cur.hasLever));
                    }
                }
            }
        }
        return answer;
    }
    static boolean isValid(int x, int y) {
        return x >= 0 && y >= 0 && x < N && y < M;
    }
}