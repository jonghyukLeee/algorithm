import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
class Solution {
    public int solution(String s) {
        int answer = 0;
        int length = s.length();

        Queue<Character> q = new LinkedList<>();

        for (int i = 0; i < length; i++) q.add(s.charAt(i));

        while (length-- > 0) {
            Queue<Character> tmp = new LinkedList<>(q);
            Stack<Character> stk = new Stack<>();
            boolean flag = true;
            while (!tmp.isEmpty()) {
                char next = tmp.poll();

                // '(', '[', '{'
                if (next == '(' || next == '[' || next == '{') stk.push(next);
                else if (next == ')') {
                    if (!stk.isEmpty() && stk.peek() == '(') stk.pop();
                    else {
                        flag = false;
                        break;
                    }
                }
                else if (next == ']') {
                    if (!stk.isEmpty() && stk.peek() == '[') stk.pop();
                    else {
                        flag = false;
                        break;
                    }
                }
                else if (next == '}') {
                    if (!stk.isEmpty() && stk.peek() == '{') stk.pop();
                    else {
                        flag = false;
                        break;
                    }
                }
            }
            if (flag && stk.isEmpty()) answer++;

            q.add(q.poll()); // 회전
        }
        return answer;
    }
}