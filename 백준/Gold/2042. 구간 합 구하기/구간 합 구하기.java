import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M, K;
    static long[] tree;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        // 세그먼트 트리 배열 초기화
        int level = 0;
        int tmpLength = N;
        while (tmpLength != 0) {
            tmpLength /= 2;
            level++;
        }

        int treeLength = (int)Math.pow(2, level + 1);
        int startIdx = (int)Math.pow(2, level);
        tree = new long[treeLength + 1];

        for (int i = 0; i < N; i++) {
            tree[startIdx + i] = Long.parseLong(br.readLine());
        }

        int maxIdx = treeLength - 1;
        while (maxIdx != 1) {
            tree[maxIdx / 2] += tree[maxIdx];
            maxIdx--;
        }

        StringBuilder sb = new StringBuilder();
        int T = M + K;
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());

            if (command == 1) {
                int updateIdx = startIdx + b - 1;
                update(updateIdx, c);
            } else {
                int from = startIdx + b - 1;
                int to = startIdx + (int)c - 1;
                sb.append(getSum(from, to)).append("\n");
            }
        }

        sb.deleteCharAt(sb.length() - 1);
        System.out.print(sb);
    }

    static void update(int idx, long value) {
        long diff = value - tree[idx];
        int parentIdx = idx;

        while (parentIdx != 0) {
            tree[parentIdx] += diff;
            parentIdx /= 2;
        }
    }

    static long getSum(int start, int end) {
        long result = 0;

        while (start <= end) {
            if (isRight(start)) {
                result += tree[start];
                start++;
            }

            if (isLeft(end)) {
                result += tree[end];
                end--;
            }

            start /= 2;
            end /= 2;
        }

        return result;
    }

    static boolean isRight(int idx) {
        return (idx % 2) == 1;
    }

    static boolean isLeft(int idx) {
        return (idx % 2) == 0;
    }
}
