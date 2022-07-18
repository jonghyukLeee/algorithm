import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q5567 {
    static List<List<Integer>> friends;
    static boolean [] isVisited;
    static int N,M;
    static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        friends = new ArrayList<>();
        isVisited = new boolean[N + 1];

        for (int i = 0; i <= N; i++) friends.add(new ArrayList<>());

        M = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int fst = Integer.parseInt(st.nextToken());
            int sec = Integer.parseInt(st.nextToken());

            friends.get(fst).add(sec);
            friends.get(sec).add(fst);
        }

        // 상근이의 친구
        Queue<Integer> q = new LinkedList<>();

        isVisited[1] = true;
        for (int friend : friends.get(1)) {
            if (!isVisited[friend]) {
                isVisited[friend] = true;
                answer++;
                q.add(friend);
            }
        }

        while(!q.isEmpty()) {
            int next = q.poll();
            for (int friend : friends.get(next)) {
                if (!isVisited[friend]) {
                    isVisited[friend] = true;
                    answer++;
                }
            }
        }
        System.out.print(answer);
    }
}
