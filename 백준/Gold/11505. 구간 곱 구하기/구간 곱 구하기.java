import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, M, K;
    static long[] tree;
    static int MOD = 1_000_000_007;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        int treeSize = 1;
        int level = 0;

        while (treeSize < N) {
            treeSize *= 2;
            level++;
        }

        tree = new long[(treeSize * 2) + 1];
        Arrays.fill(tree, 1);
        int leafStartIndex = (int)Math.pow(2, level);

        for (int i = 0; i < N; i++) {
            tree[leafStartIndex + i] = Integer.parseInt(br.readLine());
        }

        set(tree.length - 1);

        StringBuilder sb = new StringBuilder();
        int T = M + K;
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if (command == 1) {
                int updateIdx = leafStartIndex + b - 1;
                update(updateIdx, c);
            } else {
                int startIdx = leafStartIndex + b - 1;
                int endIdx = leafStartIndex + c - 1;

                sb.append(getResult(startIdx, endIdx)).append("\n");
            }
        }

        sb.deleteCharAt(sb.length() - 1);
        System.out.print(sb);
    }

    static void set(int idx) {
        while (idx > 1) {
            tree[idx / 2] = (tree[idx / 2] * tree[idx]) % MOD;
            idx--;
        }
    }

    static void update(int idx, int value) {
        tree[idx] = value;
        int parentIdx = idx / 2;

        while (parentIdx != 0) {
            tree[parentIdx] = (tree[parentIdx * 2] * tree[(parentIdx * 2) + 1]) % MOD;
            parentIdx /= 2;
        }
    }

    static long getResult(int start, int end) {
        long result = 1;

        while (start <= end) {
            if (start % 2 == 1) {
                result = (result * tree[start]) % MOD;
                start++;
            }

            if (end % 2 == 0) {
                result = (result * tree[end]) % MOD;
                end--;
            }

            start /= 2;
            end /= 2;
        }

        return result % MOD;
    }
}
