import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        Map<String, Integer> memoryPointMap = new HashMap<>();
        int len = name.length;

        for (int i = 0; i < len; i++) {
            memoryPointMap.put(name[i], yearning[i]);
        }

        int photoLen = photo.length;

        int[] answer = new int[photoLen];

        for (int i = 0; i < photoLen; i++) {
            int sum = 0;
            for (String member: photo[i]) {
                if (memoryPointMap.containsKey(member)) {
                    sum += memoryPointMap.get(member);
                }
            }
            answer[i] = sum;
        }
        return answer;
    }
}