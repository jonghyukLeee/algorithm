package kakao.blind2018;

import java.util.HashMap;
import java.util.Map;

public class Q1 {
    static int solution(String str1, String str2) {
        int answer = 0;

        int str1Length = str1.length();
        int str2Length = str2.length();

        String str1Low = str1.toLowerCase();
        String str2Low = str2.toLowerCase();

        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();

        double intersection = 0.0;
        double union = 0.0;

        for (int i = 0; i < str1Length - 1; i++) {
            char fst = str1Low.charAt(i);
            char sec = str1Low.charAt(i + 1);

            if (bothAlpha(fst, sec)) {
                String key = fst + "" + sec;
                map1.put(key,map1.getOrDefault(key, 0) + 1);
            }
        }

        for (int i = 0; i < str2Length - 1; i++) {
            char fst = str2Low.charAt(i);
            char sec = str2Low.charAt(i + 1);

            if (bothAlpha(fst, sec)) {
                String key = fst + "" + sec;
                map2.put(key,map2.getOrDefault(key, 0) + 1);
            }
        }

        if (map1.size() == 0 && map2.size() == 0) return 65536;

        for (String key : map1.keySet()) {
            if (map2.containsKey(key)) {
                intersection += Math.min(map1.get(key), map2.get(key));
                union += Math.max(map1.get(key), map2.get(key));
                map2.remove(key);
            }
            else {
                union += map1.get(key);
            }
        }

        for (String key : map2.keySet()) {
            union += map2.get(key);
        }

        answer = (int)Math.floor((intersection / union) * 65536);

        return answer;
    }
    static boolean bothAlpha(char fst, char sec) {
        return fst >= 97 && sec >= 97 && fst <= 122 && sec <= 122;
    }
}
