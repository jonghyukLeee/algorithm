import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    static List<List<Integer>> friends;
    static boolean[] isVisited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        isVisited = new boolean[N];
        friends = new ArrayList<>();
        for (int i = 0; i < N; i++) friends.add(new ArrayList<>());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int fst = Integer.parseInt(st.nextToken());
            int sec = Integer.parseInt(st.nextToken());

            friends.get(fst).add(sec);
            friends.get(sec).add(fst);
        }

        for (int i = 0; i < N; i++) dfs(i, 0);
        System.out.print("0");
    }
    static void dfs(int node, int depth) {
        if (depth == 4) {
            System.out.print(1);
            System.exit(0);
        }

        isVisited[node] = true;
        for (int friend: friends.get(node)) {
            if (!isVisited[friend]) dfs(friend, depth + 1);
        }

        isVisited[node] = false;
    }
}
