package Week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Q1655 {
    static PriorityQueue<Integer> minQ;
    static PriorityQueue<Integer> maxQ;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        minQ = new PriorityQueue<Integer>(Collections.reverseOrder());
        maxQ = new PriorityQueue<Integer>();
        int tmp;
        while(t-- > 0)
        {
            tmp = Integer.parseInt(br.readLine());
            minQ.add(tmp);
            if(!maxQ.isEmpty())
            {
                if(minQ.peek() > maxQ.peek())
                {
                    int tmpQ = minQ.poll();
                    minQ.add(maxQ.poll());
                    maxQ.add(tmpQ);
                }
            }
        }
        System.out.print(sb.toString());
    }
}
