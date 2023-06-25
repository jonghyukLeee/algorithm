import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        
        Set<String> set = new HashSet<>();
        int wordLength = words.length;
        int[] turnCount = new int[n + 1];
        char charBefore = words[0].charAt(0);
        for (int i = 0; i < wordLength; i++) {
            int turn = ((i + 1) % n); // 현재 순서 번호
            turn = turn == 0 ? n : turn;
            turnCount[turn]++;
            
            String word = words[i];
            
            if (!set.add(word) || word.charAt(0) != charBefore) {
                answer[0] = turn;
                answer[1] = turnCount[turn];
                break;
            }
            charBefore = word.charAt(word.length() - 1);
        }
    
        return answer;
    }
}