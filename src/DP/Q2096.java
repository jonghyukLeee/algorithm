package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2096 {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        int [] max = new int[3];
        int [] min = new int[3];
        int [] map = new int[3];
        int [] tmp = new int[3];

        //첫줄 초기화
        StringTokenizer st = new StringTokenizer(br.readLine());
        int fst = Integer.parseInt(st.nextToken());
        int sec = Integer.parseInt(st.nextToken());
        int third = Integer.parseInt(st.nextToken());

        max[0] = fst;
        max[1] = sec;
        max[2] = third;

        min[0] = fst;
        min[1] = sec;
        min[2] = third;

        for(int i = 1; i < N; ++i)
        {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 3; ++j)
            {
                map[j] = Integer.parseInt(st.nextToken());
            }
            //최댓값
            tmp[0] = map[0] + Math.max(max[0],max[1]);
            tmp[1] = map[1] + Math.max(max[0],Math.max(max[1],max[2]));
            tmp[2] = map[2] + Math.max(max[1],max[2]);

            max[0] = tmp[0];
            max[1] = tmp[1];
            max[2] = tmp[2];

            //최솟값
            tmp[0] = map[0] + Math.min(min[0],min[1]);
            tmp[1] = map[1] + Math.min(min[0],Math.min(min[1],min[2]));
            tmp[2] = map[2] + Math.min(min[1],min[2]);

            min[0] = tmp[0];
            min[1] = tmp[1];
            min[2] = tmp[2];
        }

        int maxAnswer = max[0];
        int minAnswer = min[0];
        for(int i = 1; i < 3; ++i)
        {
            if(max[i] > maxAnswer) maxAnswer = max[i];
            if(min[i] < minAnswer) minAnswer = min[i];
        }

        System.out.printf("%d %d",maxAnswer,minAnswer);
    }

}
