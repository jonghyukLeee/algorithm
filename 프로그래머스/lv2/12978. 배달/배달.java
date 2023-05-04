import java.util.*;
class Town {
    int n, time;
    public Town(int n, int time) {
        this.n = n;
        this.time = time;
    }
}

class Solution {
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        List<List<Town>> map = new ArrayList<>();

        for (int i = 0; i <= N; i++) map.add(new ArrayList<>());

        for (int [] r: road) {
            map.get(r[0]).add(new Town(r[1], r[2]));
            map.get(r[1]).add(new Town(r[0], r[2]));
        }

        int [] minTimes = new int[N + 1];
        Arrays.fill(minTimes, Integer.MAX_VALUE);
        minTimes[1] = 0;

        Queue<Town> q = new PriorityQueue<>(new Comparator<Town>() {
            @Override
            public int compare(Town o1, Town o2) {
                return o1.time - o2.time;
            }
        });

        q.add(new Town(1, 0));
        boolean [] isVisited = new boolean[N + 1];
        
        while (!q.isEmpty()) {
            Town cur = q.poll();

            if (!isVisited[cur.n]) {
                isVisited[cur.n] = true;
                
                for (Town next: map.get(cur.n)) {
                    if (!isVisited[next.n] && minTimes[next.n] > cur.time + next.time) {
                        minTimes[next.n] = cur.time + next.time;
                        q.add(new Town(next.n, minTimes[next.n]));
                    }
                }
            }
        }
        for (int time: minTimes) {
            if (time <= K) answer++;
        }
        return answer;
    }
}