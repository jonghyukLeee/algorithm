import java.util.*;

class Solution {
    static String[] map;
    public int solution(String[] board) {
        int answer = 0;
        map = new String[8];
        
        // 가로 3개
        for (int i = 0; i < 3; i++) map[i] = board[i];
        // 세로 3개
        for (int i = 0; i < 3; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < 3; j++) {
                sb.append(board[j].charAt(i));
            }
            map[i + 3] = sb.toString();
        }
        
        map[6] = "" + board[0].charAt(0) + board[1].charAt(1) + board[2].charAt(2);
        map[7] = "" + board[0].charAt(2) + board[1].charAt(1) + board[2].charAt(0);
        
        int oCount = 0, xCount = 0, oWin = 0, xWin = 0;
        
        for (int i = 0; i < 8; i++) {
            int o = 0, x = 0;
            for (int j = 0; j < 3; j++) {
                char c = map[i].charAt(j);
                
                if (c == 'O') {
                    o++;
                } else if (c == 'X') {
                    x++;
                }
            }
            
            if (i < 3) {
                oCount += o;
                xCount += x;
            }
            
            if (o == 3) {
                oWin++;
            } else if (x == 3) {
                xWin++;
            }
        }
        
        if (oCount == 0 && xCount == 0) {
            answer = 1;
        } else {
            if (oCount == xCount) {
                answer = (oWin > 0) && (oCount + xCount < 9) ? 0 : 1;
            } else if (oCount == xCount + 1) {
                answer = xWin > 0 ? 0 : 1;
            }
        }
        
        return answer;
    }
}