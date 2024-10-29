import java.util.Collections;
import java.util.PriorityQueue;

class Solution {
    public int solution(int[] cards) {
        int len = cards.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < len; i++) {
            int count = 1;
            if (cards[i] > 0) {
                int nextIdx = cards[i] - 1;
                cards[i] = 0;
                while (cards[nextIdx] > 0) {
                    int curIdx = nextIdx;
                    nextIdx = cards[curIdx] - 1;
                    cards[curIdx] = 0;
                    count++;
                }

                pq.add(count);
            }
        }

        return pq.size() < 2 ? 0 : pq.poll() * pq.poll();
    }
}