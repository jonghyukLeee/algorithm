import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Meeting {
    int startTime, endTime;

    public Meeting(int startTime, int endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }
}
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Meeting> pq = new PriorityQueue<>(new Comparator<Meeting>() {
            @Override
            public int compare(Meeting o1, Meeting o2) {
                if (o1.endTime == o2.endTime) {
                    return o1.startTime - o2.startTime;
                } else {
                    return o1.endTime - o2.endTime;
                }
            }
        });
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int startTime = Integer.parseInt(st.nextToken());
            int endTime = Integer.parseInt(st.nextToken());

            pq.add(new Meeting(startTime, endTime));
        }

        int lastTime = -1;
        int answer = 0;
        while (!pq.isEmpty()) {
            Meeting next = pq.poll();

            if (next.startTime > lastTime) {
                answer++;
                lastTime = next.endTime - 1;
            }
        }

        System.out.print(answer);
    }
}
