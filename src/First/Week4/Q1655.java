package First.Week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Q1655 {
    static PriorityQueue<Integer> minQ;
    static PriorityQueue<Integer> maxQ;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        minQ = new PriorityQueue<>();
        maxQ = new PriorityQueue<>(Collections.reverseOrder());
        int tmp,tmpQ;
        while(t-- > 0)
        {
            tmp = Integer.parseInt(br.readLine());
            if(maxQ.size() == minQ.size()) maxQ.add(tmp);
            else minQ.add(tmp);

            if(!minQ.isEmpty() && !maxQ.isEmpty())
            {
                if(maxQ.peek() > minQ.peek())
                {
                    tmpQ = minQ.poll();
                    minQ.add(maxQ.poll());
                    maxQ.add(tmpQ);
                }
            }
            sb.append(maxQ.peek());
            sb.append("\n");
        }
        System.out.print(sb.toString());
    }
}
