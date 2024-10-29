import java.util.Stack;
class Solution {
    public int solution(int[] order) {
        Stack<Integer> sub = new Stack<>();
        int len = order.length;
        int seq = 0;
        for (int i = 1; i <= len; i++) {
            if (order[seq] == i) {
                seq++;
                while (!sub.isEmpty() && order[seq] == sub.peek()) {
                    sub.pop();
                    seq++;
                }
                
                if (!sub.isEmpty() && sub.peek() > order[seq]) break;
            } else {
                sub.push(i);
            }
        }
        return seq;
    }
}