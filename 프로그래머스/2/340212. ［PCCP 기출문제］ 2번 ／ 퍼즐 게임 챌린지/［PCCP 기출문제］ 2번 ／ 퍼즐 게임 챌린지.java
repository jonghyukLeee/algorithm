import java.util.*;

class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int start = 1, end = 0;
        for (int diff: diffs) {
            end = Math.max(end, diff);
        }
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        while (start <= end) {
            int mid = (start + end) / 2;
            
            if (isPossible(mid, diffs, times, limit)) {
                end = mid - 1;
                pq.add(mid);
            } else {
                start = mid + 1;
            }
        }
        return pq.poll();
    }
    
    static boolean isPossible(int level, int[] diffs, int[] times, long limit) {
        int size = diffs.length;

        long total = 0;
        for (int i = 0; i < size; i++) {
            int diff = diffs[i];
            int time = times[i];

            if (level >= diff) {
                total += time;
            } else {
                int prev = times[i - 1];
                int count = diff - level;

                total += ((long)(prev + time) * count) + time;
            }
        }

        return total <= limit;
    }
}