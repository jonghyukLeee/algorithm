import java.util.*;

class Dest {
    int location, count;

    public Dest(int location, int count) {
        this.location = location;
        this.count = count;
    }
}

class Solution {
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        List<List<Integer>> map = new ArrayList<>();
        for (int i = 0; i <= n; i++) map.add(new ArrayList<>());

        for (int[] road: roads) {
            int fst = road[0];
            int sec = road[1];

            map.get(fst).add(sec);
            map.get(sec).add(fst);
        }

        int[] distance = new int[n + 1];
        Arrays.fill(distance, -1);
        distance[destination] = 0;
        Queue<Dest> q = new LinkedList<>();
        q.add(new Dest(destination, 0));

        while (!q.isEmpty()) {
            Dest cur = q.poll();

            for (int next: map.get(cur.location)) {
                if (distance[next] < 0) {
                    distance[next] = cur.count + 1;
                    q.add(new Dest(next, cur.count + 1));
                }
            }
        }

        int sourceLength = sources.length;
        int[] answer = new int[sourceLength];

        for (int i = 0; i < sourceLength; i++) answer[i] = distance[sources[i]];
        return answer;
    }
}