import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] map;
    static boolean[][] isVisited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        Queue<int[]> nextQ = new LinkedList<>();
        map = new int[N][M];
        isVisited = new boolean[N][M];

        int tCount = 0;
        int total = N * M;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] > 0) {
                    isVisited[i][j] = true;
                    tCount++;
                    nextQ.add(new int[]{i, j});
                } else if(map[i][j] < 0){
                    total--;
                }
            }
        }
        int count = 0;
        while(!nextQ.isEmpty()){
            count++;
            Queue<int[]> q = new LinkedList<>(nextQ);
            nextQ.clear();
            boolean flag = false;
            while (!q.isEmpty()) {
                int[] cur = q.poll();

                for (int idx = 0; idx < 4; idx++) {
                    int mx = cur[0] + dx[idx];
                    int my = cur[1] + dy[idx];

                    if(isValid(mx, my) && !isVisited[mx][my] && map[mx][my] == 0) {
                        flag = true;
                        isVisited[mx][my] = true;
                        map[mx][my] = 1;
                        tCount++;
                        nextQ.add(new int[]{mx, my});
                    }
                }
            }
            if(!flag) count--;
        }
        if(tCount < total) count = -1;
        System.out.print(count);
    }

    static boolean isValid(int x, int y) {
        return x >= 0 && y >= 0 && x < N && y < M;
    }
}
