import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

class Oil {
    int x, y;

    public Oil(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Solution {
    static int N, M;
    static boolean[][] isVisited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static Map<Integer, Integer> groupSizeMap;
    public int solution(int[][] land) {
        N = land.length;
        M = land[0].length;

        isVisited = new boolean[N][M];

        int answer = Integer.MIN_VALUE;
        int groupNumber = 1;
        groupSizeMap = new HashMap<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (land[i][j] > 0 && !isVisited[i][j]) {
                    isVisited[i][j] = true;
                    land[i][j] = groupNumber;
                    grouping(new Oil(i, j), groupNumber, land);
                    groupNumber++;
                }
            }
        }

        boolean[] isVisitedGroup;
        for (int i = 0; i < M; i++) {
            isVisitedGroup = new boolean[groupSizeMap.size() + 1];
            int sum = 0;
            for (int j = 0; j < N; j++) {
               int currentGroupNumber = land[j][i];

               if (currentGroupNumber > 0 && !isVisitedGroup[currentGroupNumber]) {
                   isVisitedGroup[currentGroupNumber] = true;
                   sum += groupSizeMap.get(currentGroupNumber);
               }
            }

            answer = Math.max(answer, sum);
        }

        return answer;
    }
    static void grouping(Oil location, int groupNumber, int[][] land) {
        Queue<Oil> q = new LinkedList<>();
        q.add(location);

        int groupSize = 0;
        while (!q.isEmpty()) {
            Oil current = q.poll();
            groupSize++;

            for (int idx = 0; idx < 4; idx++) {
                int mx = current.x + dx[idx];
                int my = current.y + dy[idx];

                if (isValid(mx, my) && !isVisited[mx][my] && land[mx][my] > 0) {
                    land[mx][my] = groupNumber;
                    isVisited[mx][my] = true;
                    q.add(new Oil(mx, my));
                }
            }
        }

        groupSizeMap.put(groupNumber, groupSize);
    }

    static boolean isValid(int x, int y) {
        return x >= 0 && y >= 0 && x < N && y < M;
    }
}