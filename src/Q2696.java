import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q2696 {
    static List<Integer> map;
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> minQ;
        PriorityQueue<Integer> maxQ;
        StringBuilder sb = new StringBuilder();
        while(T-- > 0)
        {
            map = new ArrayList<>();
            int N = Integer.parseInt(br.readLine());
            sb.append((N+1)/2).append("\n");
            // N이 10 이상
            while(N > 9)
            {
                st = new StringTokenizer(br.readLine());
                getList(10);
                N -= 10;
            }
            // 나머지 or 10 미만
            if(N > 0)
            {
                st = new StringTokenizer(br.readLine());
                getList(N);
            }
            minQ = new PriorityQueue<>(Collections.reverseOrder());
            maxQ = new PriorityQueue<>();

            int flag = 1;
            for(int next : map)
            {
                if(minQ.size() == maxQ.size()) minQ.add(next);
                else maxQ.add(next);
                if(!maxQ.isEmpty())
                {
                    int left = minQ.peek();
                    int right = maxQ.peek();
                    if(left > right)
                    {
                        maxQ.add(minQ.poll());
                        minQ.add(maxQ.poll());
                    }
                }
                if((flag % 2) > 0) sb.append(minQ.peek()).append(" ");

                flag++;
                // 10개 찍었으면 줄바꿈
                if(flag > 19)
                {
                    sb.append("\n");
                    flag = 0;
                }
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
    static void getList(int n)
    {
        for(int i = 0; i < n; i++)
        {
            map.add(Integer.parseInt(st.nextToken()));
        }
    }
}
