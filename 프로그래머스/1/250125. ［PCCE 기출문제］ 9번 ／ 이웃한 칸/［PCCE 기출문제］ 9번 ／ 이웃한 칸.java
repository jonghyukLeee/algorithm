class Solution {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int N, M;
    public int solution(String[][] board, int h, int w) {
        int answer = 0;

        N = board.length;
        M = board[0].length;

        String target = board[h][w];
        for (int i = 0; i < 4; i++) {
            int mx = h + dx[i];
            int my = w + dy[i];

            if (isValid(mx, my) && target.equals(board[mx][my])) answer++;
        }

        return answer;
    }
    
    static boolean isValid(int x, int y) {
        return x >= 0 && y >= 0 && x < N && y < M;
    }
}