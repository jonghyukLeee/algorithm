import java.util.*;

class Number {
    int n;
    int count;
    
    public Number(int n, int count) {
        this.n = n;
        this.count = count;
    }
}
class Solution {
    static int[] count;
    public int solution(int x, int y, int n) {
        count = new int[y + 1];
        Arrays.fill(count, Integer.MAX_VALUE);
        
        Queue<Number> q = new LinkedList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        q.add(new Number(x, 0));
        
        while (!q.isEmpty()) {
            Number cur = q.poll();
            
            if (cur.n == y) {
                pq.add(cur.count);
            } else {
                int fst = cur.n * 3;
                int sec = cur.n * 2;
                int trd = cur.n + n;
                
                if (fst <= y && cur.count + 1 < count[fst]) {
                    count[fst] = cur.count + 1;
                    q.add(new Number(fst, cur.count + 1));
                }
                
                if (sec <= y && cur.count + 1 < count[sec]) {
                    count[sec] = cur.count + 1;
                    q.add(new Number(sec, cur.count + 1));
                }

                if (trd <= y && cur.count + 1 < count[trd]) {
                    count[trd] = cur.count + 1;
                    q.add(new Number(trd, cur.count + 1));
                }
            }
        }
        
        return pq.isEmpty() ? -1 : pq.poll();
    }
}