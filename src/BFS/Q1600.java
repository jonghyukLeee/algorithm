package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Monkey
{
    int x,y,k,cnt;

    public Monkey(int x, int y, int k, int cnt) {
        this.x = x;
        this.y = y;
        this.k = k;
        this.cnt = cnt;
    }
}
public class Q1600 {
    static int W,H;
    static int [][] map;
    static boolean [][][] isVisited;
    static int [] dx = {-1, 1, 0, 0, -1, -2, -2, -1, 1, 2, 2, 1};
    static int [] dy = {0, 0, -1, 1, -2, -1, 1, 2, 2, 1, -1, -2};
    static Queue<Monkey> q;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        map = new int[H][W];
        isVisited = new boolean[H][W][K+1];

        for (int i = 0; i < H; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < W; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        q = new LinkedList<>();
        q.add(new Monkey(0,0,K,0));
        isVisited[0][0][K] = true;

        int answer = -1;
        while (!q.isEmpty()) {
            Monkey cur = q.poll();

            if(cur.x == H - 1 && cur.y == W - 1) {
                answer = cur.cnt;
                break;
            }
            //기본 움직임
            for (int idx = 0; idx < 4; idx++) {
                int mx = cur.x + dx[idx];
                int my = cur.y + dy[idx];

                if (isValid(mx,my,cur.k)) {
                    isVisited[mx][my][cur.k] = true;
                    q.add(new Monkey(mx, my, cur.k, cur.cnt + 1));
                }
            }
            // k가 양수면 말무빙
            if (cur.k > 0) {
                for(int idx = 4; idx < 12; idx++) {
                    int mx = cur.x + dx[idx];
                    int my = cur.y + dy[idx];

                    if (isValid(mx,my,cur.k - 1)) {
                        isVisited[mx][my][cur.k - 1] = true;
                        q.add(new Monkey(mx, my, cur.k - 1, cur.cnt + 1));
                    }
                }
            }
        }
        System.out.print(answer);
    }

    static boolean isValid(int x, int y,int k) {
        return x >= 0 && y >= 0 && x < H && y < W && !isVisited[x][y][k] && map[x][y] < 1;
    }
}
