package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Wood
{
    int x,y;

    public Wood(int x, int y) {
        this.x = x;
        this.y = y;
    }

}
public class Q1388 {
    static int N,M;
    static char [][] map;
    static boolean [][] isVisited;
    static int [] dx = {0,1}; // 우 , 하
    static int [] dy = {1,0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        isVisited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            map[i] = st.nextToken().toCharArray();
        }

        int answer = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(!isVisited[i][j]) {
                    answer++;
                    // 가로 판자일 때,
                    if (map[i][j] == '-') {
                        bfs(i, j, 0);
                    }
                    else bfs(i, j, 1);
                }
            }
        }
        System.out.print(answer);
    }

    static void bfs(int i, int j, int dir) {
        Queue<Wood> q = new LinkedList<>();
        q.add(new Wood(i,j));
        char curShape = map[i][j];

        while(!q.isEmpty()) {
            Wood cur = q.poll();

            //한칸 이동
            int mx = cur.x + dx[dir];
            int my = cur.y + dy[dir];

            if (!isValid(mx, my) || isVisited[mx][my] || map[mx][my] != curShape) continue;
            isVisited[mx][my] = true;
            q.add(new Wood(mx, my));
        }
    }

    static boolean isValid(int x, int y) {
        return x >= 0 && y >= 0 && x < N && y < M;
    }
}
