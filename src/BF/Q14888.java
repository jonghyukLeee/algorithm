package BF;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q14888 {
    static int N;
    static int [] num;
    static int ADD, MINUS, MUL, DIV;
    static int MIN = Integer.MAX_VALUE;
    static int MAX = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        num = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        // + - * /
        st = new StringTokenizer(br.readLine());
        ADD = Integer.parseInt(st.nextToken());
        MINUS = Integer.parseInt(st.nextToken());
        MUL = Integer.parseInt(st.nextToken());
        DIV = Integer.parseInt(st.nextToken());

        calc(0, 0, 0, 0, 0, num[0]);

        System.out.printf("%d\n%d", MAX, MIN);
    }
    static void calc (int idx, int add, int minus, int mul, int div, int res) {
        if (add > ADD || minus > MINUS || mul > MUL || div > DIV) {
            return;
        }
        if (idx == N - 1) {
            MIN = Math.min(MIN, res);
            MAX = Math.max(MAX, res);
            return;
        }

        // + - * /
        calc(idx + 1, add + 1, minus, mul, div, res + num[idx + 1]);
        calc(idx + 1, add, minus + 1, mul, div, res - num[idx + 1]);
        calc(idx + 1, add, minus, mul + 1, div, res * num[idx + 1]);
        // 나눗셈
        int tmp = Math.abs(res) / num[idx + 1];
        if (res < 0) tmp *= -1;
        calc(idx + 1, add, minus, mul, div + 1, tmp);
    }
}
