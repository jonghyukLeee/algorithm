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
                    push(Integer.parseInt(st.nextToken()));
                    break;
                }
                case "pop" :
                {
                    pop();
                    break;
                }
                case "size" :
                {
                    sb.append(stk.size());
                    sb.append("\n");
                    break;
                }
                case "empty" :
                {
                    empty();
                    break;
                }
                case "top" :
                {
                    top();
                    break;
                }

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
        sb.append(stk.removeLast());
        sb.append("\n");
    }
    static void empty()
    {
        if(stk.isEmpty())
        {
            sb.append("1\n");
            return;
        }
        sb.append("0\n");
    }
    static void top()
    {
        if(stk.isEmpty())
        {
            sb.append("-1\n");
            return;
        }
        sb.append(stk.getLast());
        sb.append("\n");
    }
}
