package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Op {
    long num, count;

    public Op(long num, long count) {
        this.num = num;
        this.count = count;
    }
}
public class Q16953 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());

        Queue<Op> pq = new PriorityQueue<>(new Comparator<Op>() {
            @Override
            public int compare(Op o1, Op o2) {
                if (o1.num == o2.num) return (int)(o1.count - o2.count);
                return (int)(o2.num - o1.num);
            }
        });
        pq.add(new Op(a, 1));

        long answer = -1;
        while (!pq.isEmpty()) {
            Op cur = pq.poll();

            if (cur.num == b) {
                answer = cur.count;
                break;
            }

            // 곱 2
            long multiValue = cur.num * 2;
            if (multiValue <= b) pq.add(new Op(multiValue, cur.count + 1));

            // 뒤에 1
            long addOne = (cur.num * 10) + 1;
            if (addOne <= b) pq.add(new Op(addOne, cur.count + 1));

        }
        System.out.print(answer);
    }
}
