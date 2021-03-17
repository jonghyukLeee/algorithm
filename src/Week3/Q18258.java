package Week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q18258 {
    static StringBuilder sb;
    static Deque<Integer> q;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        q = new LinkedList();
        sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        while(t-->0)
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
                    sb.append(q.size());
                    sb.append("\n");
                    break;
                }
                case "empty" :
                {
                    empty();
                    break;
                }
                case "front" :
                {
                    front();
                    break;
                }
                case "back" :
                {
                    back();
                    break;
                }
            }
        } //end
        System.out.print(sb.toString());
        br.close();
    }
    static void push(int n)
    {
        q.add(n);
    }
    static void pop()
    {
        if(q.isEmpty())
        {
            sb.append("-1\n");
            return;
        }
        sb.append(q.poll());
        sb.append("\n");
    }
    static void empty()
    {
        if(q.isEmpty())
        {
            sb.append("1\n");
            return;
        }
        sb.append("0\n");
    }
    static void front()
    {
        if(q.isEmpty())
        {
            sb.append("-1\n");
            return;
        }
        sb.append(q.peek());
        sb.append("\n");
    }
    static void back()
    {
        if(q.isEmpty())
        {
            sb.append("-1\n");
            return;
        }
        sb.append(q.peekLast());
        sb.append("\n");
    }
}

