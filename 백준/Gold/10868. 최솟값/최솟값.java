import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] tree;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int level = 0;
        int treeSize = 1;

        while (treeSize < N) {
            treeSize *= 2;
            level++;
        }

        tree = new int[(treeSize * 2) + 1];
        Arrays.fill(tree, Integer.MAX_VALUE);

        int leafStartIndex = (int)Math.pow(2, level);

        for (int i = 0; i < N; i++) {
            tree[leafStartIndex + i] = Integer.parseInt(br.readLine());
        }

        setTree(tree.length - 1);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int s = Integer.parseInt(st.nextToken()) + leafStartIndex - 1;
            int e = Integer.parseInt(st.nextToken()) + leafStartIndex - 1;

            sb.append(getMin(s, e)).append("\n");
        }

        sb.deleteCharAt(sb.length() - 1);
        System.out.print(sb);
    }

    static void setTree(int idx) {
        while (idx > 1) {
            tree[idx / 2] = Math.min(tree[idx / 2], tree[idx]);
            idx--;
        }
    }

    static int getMin(int start, int end) {
        int result = Integer.MAX_VALUE;

        while (start <= end) {
            if ((start % 2) == 1) {
                result = Math.min(result, tree[start]);
                start++;
            }

            if ((end % 2) == 0) {
                result = Math.min(result, tree[end]);
                end--;
            }

            start /= 2;
            end /= 2;
        }

        return result;
    }
}
