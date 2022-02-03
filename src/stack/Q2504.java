package stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Q2504 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        char[] map = input.toCharArray();
        Stack<Character> stk = new Stack<>();

        int size = map.length;
        int answer = 0;
        int tmp = 1;
        if(map[0] == ')' || map[0] == ']') exit();
        for (int i = 0; i < size; ++i)
        {
            char c = map[i];
            if(c == '(' || c == '[')
            {
                int n = c == '(' ? 2 : 3;
                stk.push(c);
                tmp *= n;
            }
            else if (c == ')')
            {
                if(stk.isEmpty() || stk.peek() != '(') exit();
                if(map[i-1] == '(') answer += tmp;
                stk.pop();
                tmp /= 2;
            }
            else if(c == ']')
            {
                if(stk.isEmpty() || stk.peek() != '[') exit();
                if(map[i-1] == '[') answer += tmp;
                stk.pop();
                tmp /= 3;
            }
            System.out.println(stk.size());
        }
        if(!stk.isEmpty()) answer = 0;
        System.out.println(answer);
    }
    static void exit()
    {
        System.out.println("0");
        System.exit(0);
    }
}

