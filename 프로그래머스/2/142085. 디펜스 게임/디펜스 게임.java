import java.util.Collections;
import java.util.PriorityQueue;
class Solution {
    public int solution(int n, int k, int[] enemy) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int answer = enemy.length;
        int totalRound = enemy.length;
        for (int i = 0; i < totalRound; i++) {
            int wave = enemy[i];
            pq.add(wave);

            n -= wave;

            if (n < 0) {
                if (k > 0 && !pq.isEmpty()) {
                    k--;
                    n += pq.poll();
                } else {
                    answer = i;
                    break;
                }
            }
        }

        return answer;
    }
}