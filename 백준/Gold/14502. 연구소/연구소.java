import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] map;
    static List<int[]> virus;
    static int wallCount = 3;
    static int answer = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N =  Integer.parseInt(st.nextToken());
        M =  Integer.parseInt(st.nextToken());
        map = new int[N][M];
        virus = new ArrayList<>();
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 2) virus.add(new int[]{i, j});
                else if(map[i][j] == 1) wallCount++;
            }
        }

        setWall(0);
        System.out.print((N * M) - wallCount - answer);
    }
    static void setWall(int count) {
        if(count == 3) {
            answer = Math.min(answer, spread());
            return;
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(map[i][j] == 0) {
                    map[i][j] = 1;
                    setWall(count + 1);
                    map[i][j] = 0;
                }
            }
        }
    }
    static int spread() {
        Queue<int[]> q = new LinkedList<>();
        boolean[][] isVisited = new boolean[N][M];
        for(int[] v: virus) {
            q.add(v);
            isVisited[v[0]][v[1]] = true;
        }

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        int count = 0;
        while(!q.isEmpty()){
            int[] cur = q.poll();
            count++;
            for(int idx = 0; idx < 4; idx++){
                int mx = cur[0] + dx[idx];
                int my = cur[1] + dy[idx];

                if(isValid(mx, my) && !isVisited[mx][my] && map[mx][my] == 0) {
                    isVisited[mx][my] = true;
                    q.add(new int[] {mx, my});
                }
            }
        }
        return count;
    }

    static boolean isValid(int x, int y) {
        return x >= 0 && y >= 0 && x < N && y < M;
    }
}