import java.util.*;
class Solution {
    static Map<String, Integer> map;
    static int[][] giftCountList;
    static int[] giftScore;
    static int[] answerList;
    static int maxCount = 0;
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        int memberCount = friends.length;
        giftCountList = new int[memberCount][memberCount];
        giftScore = new int[memberCount];
        answerList = new int[memberCount];
        
        map = new HashMap<>();
        
        for (int i = 0; i < memberCount; i++) {
            map.put(friends[i], i);
        }
        
        for (String gift: gifts) {
            StringTokenizer st = new StringTokenizer(gift);
            String sender = st.nextToken();
            String receiver = st.nextToken();
            
            giftCountList[map.get(sender)][map.get(receiver)]++;
            giftScore[map.get(sender)]++;
            giftScore[map.get(receiver)]--;
        }
        
        for (int i = 0; i < memberCount; i++) {
            for (int j = i + 1; j < memberCount; j++) {
                int sendPoint = giftCountList[i][j];
                int receivePoint = giftCountList[j][i];
                
                if (sendPoint == receivePoint) {
                    if (giftScore[i] > giftScore[j]) {
                        addCount(i);
                    } else if (giftScore[i] < giftScore[j]) {
                        addCount(j);
                    }
                } else if (sendPoint > receivePoint){
                    addCount(i);
                } else {
                    addCount(j);
                }
            }
        }
        
        return maxCount;
    }
    static void addCount(int idx) {
        answerList[idx]++;
        maxCount = Math.max(maxCount, answerList[idx]);
    }
}