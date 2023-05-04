package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1074 {
    static int N,r,c;
    static int curNum;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        int size = (int)Math.pow(2, N);

        findLocation(0, 0, size);
    }

    static void findLocation(int x, int y, int n) {
        if (n == 1) {
            System.out.print(curNum);
            return;
        }

        int nextSize = n / 2;
        int nextX = x, nextY = y;
        int tmpValue = (n * n) / 4;
        // 2사분면
        if (r < (x + nextSize) && c >= (y + nextSize)) {
            curNum += tmpValue;
            nextY += nextSize;
        }
        // 3사분면
        else if (r >= (x + nextSize) && c < (y + nextSize)) {
            curNum += tmpValue * 2;
            nextX += nextSize;
        }
        // 4사분면
        else if (r >= (x + nextSize) && c >= (y + nextSize)) {
            curNum += tmpValue * 3;
            nextX += nextSize;
            nextY += nextSize;
        }
        findLocation(nextX, nextY, nextSize);
    }

}
