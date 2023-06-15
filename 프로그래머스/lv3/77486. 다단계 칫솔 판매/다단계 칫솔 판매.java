import java.util.*;

class Solution {
    static Map<String, String> parents;
    static Map<String, Integer> total;
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        parents = new HashMap<>();
        total = new HashMap<>();
        total.put("center", 0);

        int enrollSize = enroll.length;
        for (int i = 0; i < enrollSize; i++) {
            String child = enroll[i];
            String parent = referral[i];
            total.put(child, 0);

            if (parent.equals("-")) parents.put(child, "center");
            else parents.put(child, parent);
        }

        int sellerSize = seller.length;

        for (int i = 0; i < sellerSize; i++) {
            String member = seller[i];

            dfs(member, amount[i] * 100);
        }
        int[] answer = new int[enrollSize];
        for (int i = 0; i < enrollSize; i++) answer[i] = total.get(enroll[i]);
        return answer;
    }
    static void dfs(String child, int amount) {
        if (child.equals("center")) return;

        String parent = parents.get(child);
        int toParent = amount / 10;
        int tmpSum = amount - toParent;

        if (toParent > 0) dfs(parent, toParent);
        else tmpSum += toParent;

        total.put(child, total.getOrDefault(child, 0) + tmpSum);
    }
}