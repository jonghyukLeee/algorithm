package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Lecture
{
    int start,end;

    public Lecture(int start, int end) {
        this.start = start;
        this.end = end;
    }
}
public class Q11000 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st;
        Queue<Lecture> lectures = new PriorityQueue<>(new Comparator<Lecture>() {
            @Override
            public int compare(Lecture o1, Lecture o2) {
                if(o1.start == o2.start) {
                    return o1.end - o2.end;
                }
                return o1.start - o2.start;
            }
        });
        Queue<Integer> cur = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            lectures.add(new Lecture(start,end));
        }

        //첫 수업
        cur.add(lectures.poll().end);

        while (!lectures.isEmpty()) {
            //다음 강의 시작시간
            Lecture next = lectures.poll();

            if (next.start >= cur.peek()) {
                cur.poll();
            }
            cur.add(next.end);
        }

        System.out.print(cur.size());
    }
}
