package Week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q10828 {
    static LinkedList<Integer> stk;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        stk = new LinkedList<>();
        sb = new StringBuilder();
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        for(int i = 0; i < t; ++i)
        {
            st = new StringTokenizer(br.readLine());
            switch(st.nextToken())
            {
                case "push" :
                {
                    stk.push(Integer.parseInt(st.nextToken()));
                    break;
                }
                case "pop" :
                {
                    stk.pop();
                    break;
                }
                case "size" :
                {
                    stk.size();
                    break;
                }
                case "empty" :
                {
                    stk.isEmpty();
                    break;
                }
         /*       case "top" :
                {
                    stk.top();
                }
         */
            }
        } //end
        System.out.print(sb.toString());
    }
    static void push(int n)
    {
        stk.add(n);
    }
    static void pop()
    {
        if(stk.isEmpty())
        {
            sb.append("-1\n");
            return;
        }
        int idx = stk.size()-1;
        sb.append(stk.get(idx));
        sb.append("\n");
        stk.remove(idx);
    }
    static void top()
    {
        if(stk.isEmpty())
        {
            sb.append("-1\n");
            return;
        }
        int idx = stk.size()-1;
        sb.append(stk.get(idx));
        sb.append("\n");
    }
}
