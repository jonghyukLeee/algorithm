import java.util.*;

class Solution {
    public int solution(int storey) {
        int answer = 0;
        while (storey > 0) {
            int n = storey % 10;
            
            if (n == 5 && storey >= 10) {
                int next = (storey / 10) % 10;
                
                if (next < 5) {
                    answer += n;
                } else {
                    int count = 10 - n;
                    answer += count;
                    storey += count;
                }
            } else if (n > 5) {
                int count = 10 - n;
                answer += count;
                storey += count;
            } else {
                answer += n;
            }
            
            storey /= 10;
        }
        
        return answer;
    }
}