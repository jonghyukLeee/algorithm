package Review_30days.week3.day21;

public class Kakao_Q6 {
    public static void main(String[] args) {
        int [][] board = {{5,5,5,5,5},{5,5,5,5,5},{5,5,5,5,5},{5,5,5,5,5}};
        int [][] skill = {{1,0,0,3,4,4},{1,2,0,2,3,2},{2,1,0,3,1,2},{1,0,1,3,3,1}};
        System.out.print(solution(board,skill));
    }
    static int solution(int[][] board, int[][] skill) {
        int answer = 0;
        int n = board.length;
        int m = board[0].length;
        int [][] prefix_arr = new int[n+1][m+1];

        for(int [] row : skill)
        {
            int type = row[0];
            int degree = type == 1 ? -row[5] : row[5];
            int r1 = row[1];
            int c1 = row[2];
            int r2 = row[3];
            int c2 = row[4];

            for(int i = r1; i <= r2; ++i)
            {
                prefix_arr[i][c1] += degree;
                prefix_arr[i][c2 + 1] -= degree;
            }
        }
        for(int i = 0; i < n; ++i)
        {
            for(int j = 0; j < m; ++j)
            {
                if(j != 0) prefix_arr[i][j] += prefix_arr[i][j-1];
                board[i][j] += prefix_arr[i][j];
                if(board[i][j] > 0) answer++;
            }
        }

        return answer;
    }
}
