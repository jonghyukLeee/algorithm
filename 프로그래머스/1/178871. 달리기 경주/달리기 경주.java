import java.util.HashMap;
import java.util.Map;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        Map<String, Integer> name = new HashMap<>();
        Map<Integer, String> rank = new HashMap<>();

        for (int i = 0; i < players.length; i++) {
            name.put(players[i], i + 1);
            rank.put(i + 1, players[i]);
        }

        for (String call: callings) {
            int currentRank = name.get(call);
            if (currentRank > 1) {
                int nextRank = currentRank - 1;
                String nextPlayer = rank.get(nextRank);

                name.put(call, nextRank);
                rank.put(nextRank, call);

                name.put(nextPlayer, currentRank);
                rank.put(currentRank, nextPlayer);
            }
        }

        String[] answer = new String[rank.size()];
        int idx = 0;

        for (int n: rank.keySet()) {
            answer[idx++] = rank.get(n);
        }
        
        return answer;
    }
}