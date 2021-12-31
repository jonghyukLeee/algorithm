package Review_30days.day7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1080 {
    static int N,M;
    static int [][] A,B;
    static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        A = new int[N][M];
        B = new int[N][M];

        for(int i = 0; i < N; ++i)
        {
            String tmp = br.readLine();
            for(int j = 0; j < M; ++j) A[i][j] = tmp.charAt(j)-'0';

        }
        for(int i = 0; i < N; ++i)
        {
            String tmp = br.readLine();
            for(int j = 0; j < M; ++j) B[i][j] = tmp.charAt(j)-'0';
        }

        for(int i = 0; i < N; ++i)
        {
            for(int j = 0; j < M; ++j)
            {
                if(A[i][j] != B[i][j])
                {
                    if(reverse(i,j)) answer++;
                    else
                    {
                        System.out.print(-1);
                        return;
                    }
                }
            }
        }
        System.out.print(answer);
    }
    static boolean reverse(int x, int y)
    {
        if((x + 2) >= N || (y + 2) >= M) return false;
        for(int i = x; i < x+3; ++i)
        {
            for(int j = y; j < y+3; ++j)
            {
                A[i][j] ^= 1;
            }
        }
        return true;
    }
}
