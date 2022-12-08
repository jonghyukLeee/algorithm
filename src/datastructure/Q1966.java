package datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PipedReader;
import java.util.*;

class Print {
    int idx;
    int lev;

    public Print(int idx, int lev) {
        this.idx = idx;
        this.lev = lev;
    }
}
public class Q1966 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            Queue<Print> q = new LinkedList<>(); // 순서를 담는 큐
            Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder()); // 내림차순 (중요도 높은거 먼저)

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                int tmpValue = Integer.parseInt(st.nextToken());
                q.add(new Print(i, tmpValue));
                pq.add(tmpValue);
            }

            int tmpCount = 1;
            loop : while(!pq.isEmpty()) {
                int next = pq.poll();

                // 다음 중요도 값을 탐색하여 꺼냄
                while (!q.isEmpty()) {
                    if (q.peek().lev != next) {
                        // 다시 뒤로
                        q.add(q.poll());
                    }
                    else {
                        Print print = q.poll();
                        if (print.idx == M) break loop;
                        tmpCount++;
                        continue loop;
                    }
                }
            }
            sb.append(tmpCount).append("\n");
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.print(sb);
    }
}
