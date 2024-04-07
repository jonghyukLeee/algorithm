import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int [][] tree;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        tree = new int[N + 1][2];

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int pIdx = st.nextToken().charAt(0) - 64;
            int left = st.nextToken().charAt(0) - 64;
            int right = st.nextToken().charAt(0) - 64;

            if (left > 0) {
                tree[pIdx][0] = left;
            }
            if (right > 0) {
                tree[pIdx][1] = right;
            }
        }

        StringBuilder sb = new StringBuilder();
        prefix(sb, 1);
        sb.append("\n");
        infix(sb, 1);
        sb.append("\n");
        postfix(sb, 1);

        System.out.print(sb);
    }
    static void prefix(StringBuilder sb, int p) {
        sb.append(((char)(p + 64)));
        if (tree[p][0] > 0) prefix(sb, tree[p][0]);
        if (tree[p][1] > 0) prefix(sb, tree[p][1]);
    }
    static void infix(StringBuilder sb, int p) {
        if (tree[p][0] > 0) infix(sb, tree[p][0]);
        sb.append(((char)(p + 64)));
        if (tree[p][1] > 0) infix(sb, tree[p][1]);
    }
    static void postfix(StringBuilder sb, int p) {
        if (tree[p][0] > 0) postfix(sb, tree[p][0]);
        if (tree[p][1] > 0) postfix(sb, tree[p][1]);
        sb.append(((char)(p + 64)));
    }
}
