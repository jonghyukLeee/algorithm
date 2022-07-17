package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Food
{
    int x,y;

    public Food(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
public class Q1743 {
    static int N,M,K;
    static int maxSize = Integer.MIN_VALUE;
    static boolean [][] isFood,isVisited;
    static int [] dx = {-1, 1, 0, 0};
    static int [] dy = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        isFood = new boolean[N + 1][M + 1];
        isVisited = new boolean[N + 1][M + 1];

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            isFood[x][y] = true;
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if(isFood[i][j] && !isVisited[i][j]) {
                    isVisited[i][j] = true;
                    getSize(i,j);
                }
            }
        }

        System.out.print(maxSize);
    }
    static void getSize(int i, int j) {
        Queue<Food> q = new LinkedList<>();
        q.add(new Food(i,j));
        int tmpValue = 0;

        while(!q.isEmpty()) {
            Food cur = q.poll();

            tmpValue++;

            for (int idx = 0; idx < 4; idx++) {
                int mx = cur.x + dx[idx];
                int my = cur.y + dy[idx];

                if(isValid(mx, my) && !isVisited[mx][my] && isFood[mx][my]) {
                    isVisited[mx][my] = true;
                    q.add(new Food(mx,my));
                }
            }
        }
        maxSize = Math.max(maxSize, tmpValue);
    }
    static boolean isValid(int x, int y) {
        return x > 0 && y > 0 && x <= N && y <= M;
    }
}
