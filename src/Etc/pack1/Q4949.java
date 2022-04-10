package Etc.pack1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Q4949 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        while(true)
        {
            String input = br.readLine();
            if(input.equals(".")) break;

            char[] arr = input.toCharArray();
            Stack<Character> st = new Stack<>();
            boolean isBalanced = true;
            for(char next : arr)
            {
                if(next == '(' || next == '[') st.push(next);
                else if(next == ')')
                {
                    if(st.isEmpty() || st.peek() == '[')
                    {
                        isBalanced = false;
                        break;
                    }
                    st.pop();
                }
                else if(next == ']')
                {
                    if(st.isEmpty() || st.peek() == '(')
                    {
                        isBalanced = false;
                        break;
                    }
                    st.pop();
                }
            }
            if(isBalanced && st.isEmpty()) sb.append("yes\n");
            else sb.append("no\n");
        }
        System.out.print(sb);
    }
}
