import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Medal {
    int team, gold, silver, bronze;

    public Medal(int team, int gold, int silver, int bronze) {
        this.team = team;
        this.gold = gold;
        this.silver = silver;
        this.bronze = bronze;
    }

    public boolean isSame(Medal m) {
        return this.gold == m.gold && this.silver == m.silver && this.bronze == m.bronze;
    }
}
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        PriorityQueue<Medal> pq = new PriorityQueue<>(new Comparator<Medal>() {
            @Override
            public int compare(Medal o1, Medal o2) {
                if (o1.gold == o2.gold) {
                    if (o1.silver == o2.silver) {
                        return o2.bronze - o1.bronze;
                    }
                    return o2.silver - o1.silver;
                } return o2.gold - o1.gold;
            }
        });

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int team = Integer.parseInt(st.nextToken());
            int gold = Integer.parseInt(st.nextToken());
            int silver = Integer.parseInt(st.nextToken());
            int bronze = Integer.parseInt(st.nextToken());

            pq.add(new Medal(team, gold, silver, bronze));
        }

        int rank = 1;

        Medal prev = pq.poll();
        if (prev.team != k) {
            for (int i = 2; i <= n; i++) {
                Medal next = pq.poll();
                if (!next.isSame(prev)) {
                    rank = i;
                }

                if (next.team == k) break;
                prev = next;
            }
        }
        System.out.print(rank);
    }
}
