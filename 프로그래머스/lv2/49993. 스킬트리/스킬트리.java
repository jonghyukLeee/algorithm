import java.util.HashMap;
import java.util.Map;
class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        Map<Character, Integer> map = new HashMap<>();

        int skillSize = skill.length();
        for (int i = 0; i < skillSize; i++) map.put(skill.charAt(i), i + 1);

        for (String skillTree: skill_trees) {
            int tmpCount = 1;
            boolean flag = true;
            for (char c: skillTree.toCharArray()) {
                Integer skillIndexInfo = map.get(c);
                if (skillIndexInfo != null) {
                    if (skillIndexInfo > tmpCount) {
                        flag = false;
                        break;
                    }
                    else tmpCount++;
                }
            }
            if (flag) answer++;
        }
        return answer;
    }
}