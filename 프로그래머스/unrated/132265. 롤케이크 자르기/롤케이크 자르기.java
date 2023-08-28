import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        int toppingSize = topping.length;
        Set<Integer> left = new HashSet<>();
        Map<Integer, Integer> right = new HashMap<>();

        left.add(topping[0]);
        for (int i = 1; i < toppingSize; i++) right.put(topping[i], right.getOrDefault(topping[i], 0) + 1);

        // 초기값 확인
        if (left.size() == right.size()) answer++;

        for (int i = 1; i < toppingSize; i++) {
            int next = topping[i];
            
            // 왼쪽 추가
            left.add(next);
            // 오른쪽 감소 or 제거
            decreaseOrRemove(right, next);
            
            if (left.size() == right.size()) answer++;
        }
        return answer;
    }
    static void decreaseOrRemove(Map<Integer, Integer> map, int key) {
        int currentValue = map.get(key);

        if (currentValue == 1) map.remove(key);
        else map.put(key, map.get(key) - 1);
    }
}