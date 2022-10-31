package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Location2 {
    int x, y;
    int time;

    public Location2(int x, int y, int time) {
        this.x = x;
        this.y = y;
        this.time = time;
    }
}
public class Q4179 {
    static int R,C;
    static char [][] map;
    static int [][] burnedTime;
    static boolean [][] isVisited;
    static int [] dx = {-1, 1, 0, 0};
    static int [] dy = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        isVisited = new boolean[R][C];
        burnedTime = new int[R][C];
        Queue<Location2> q = new LinkedList<>();
        //초기화
        Location2 jh = new Location2(0,0,0);
        Location2 fire = new Location2(0,0,0);

        for (int i = 0; i < R; i++) {
            String tmpInput = br.readLine();
            for (int j = 0; j < C; j++) {
                char c = tmpInput.charAt(j);
                if (c == 'J') {
                    jh = new Location2(i, j, 0);
                    isVisited[i][j] = true;
                }
                else if (c == 'F') {
                    q.add(new Location2(i, j, 0));
                    burnedTime[i][j] = 1; //어차피 못가므로 1로 처리
                }
                map[i][j] = c;
            }
        }
        // fire 먼저 이동
        q.add(fire);
        while(!q.isEmpty()) {
            Location2 cur = q.poll();
            int nextTime = cur.time + 1;

            for (int idx = 0; idx < 4; idx++) {
                int mx = cur.x + dx[idx];
                int my = cur.y + dy[idx];

                if (isValid(mx, my) && map[mx][my] == '.' && burnedTime[mx][my] < 1) {
                    burnedTime[mx][my] = nextTime;
                    q.add(new Location2(mx, my, nextTime));
                }
            }
        }

        // 지훈이 이동
        int answer = Integer.MAX_VALUE;
        q.add(jh);
        while(!q.isEmpty()) {
            Location2 cur = q.poll();
            int nextTime = cur.time + 1;
            // 탈출 성공
            if (isEdge(cur.x, cur.y)) {
                answer = Math.min(answer, nextTime);
                continue;
            }

            for (int idx = 0; idx < 4; idx++) {
                int mx = cur.x + dx[idx];
                int my = cur.y + dy[idx];

                if (isValid(mx, my) && !isVisited[mx][my] && map[mx][my] == '.') {
                    // 불이 없거나, 나중에 타거나
                    if (burnedTime[mx][my] < 1 || burnedTime[mx][my] > nextTime) {
                        isVisited[mx][my] = true;
                        q.add(new Location2(mx, my, nextTime));
                    }
                }
            }
        }
        System.out.print(answer != Integer.MAX_VALUE ? answer : "IMPOSSIBLE");
    }
    static boolean isValid(int x, int y) {
        return x >= 0 && y >= 0 && x < R && y < C;
    }
    static boolean isEdge(int x, int y) {
        return x == 0 || y == 0 || x == R - 1 || y == C - 1;
    }
}
