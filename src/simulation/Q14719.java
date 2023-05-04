package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q14719 {
    static int H,W;
    static int [] rain,blocks;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 맵 크기
        StringTokenizer st = new StringTokenizer(br.readLine());

        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());

        blocks = new int[W];
        rain = new int[W];

        st = new StringTokenizer(br.readLine());
        int height = Integer.MIN_VALUE;
        for (int i = 0; i < W; i++) {
            blocks[i] = Integer.parseInt(st.nextToken());
            height = Math.max(height,blocks[i]);
            rain[i] = height;
        }

        int answer = 0;
        height = Integer.MIN_VALUE;
        for(int i = W-1; i >= 0; i--) {
            height = Math.max(height, blocks[i]);
            rain[i] = Math.min(rain[i], height);
            answer += rain[i] - blocks[i];
        }

        System.out.print(answer);
    }
}
