import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static boolean[] isVisited;
    static List<List<Integer>> list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        list = new ArrayList<>();

        for (int i = 0; i <= n; i++) list.add(new ArrayList<>());

        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());

            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());

            list.get(v1).add(v2);
            list.get(v2).add(v1);
        }

        int count = 0;
        isVisited = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            if (!isVisited[i]) {
                count++;
                isVisited[i] = true;
                markIfLinked(i);
            }
        }

        System.out.print(count);
    }
    static void markIfLinked(int v) {
        for (int vertex: list.get(v)) {
            if (!isVisited[vertex]) {
                isVisited[vertex] = true;
                markIfLinked(vertex);
            }
        }
    }
}
