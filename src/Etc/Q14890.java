package Etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q14890 {
    static int N,L,answer;
    static int [][] map;
    static boolean [][] isVis;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        map = new int[N][N];

        for(int i = 0; i < N; ++i)
        {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; ++j)
            {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        isVis = new boolean[N][N];
        for(int i = 0; i < N; ++i)
        {
            horizon(i,map[i][0]);
        }
        isVis = new boolean[N][N];
        for(int i = 0; i < N; ++i)
        {
            vertical(i,map[0][i]);
        }
        System.out.print(answer);
    }
    static void horizon(int n, int h)
    {
        int j = 0;
        int cur = h;
        while(true)
        {
            if(j == N-1)
            {
                answer++;
                break;
            }
            if(map[n][j+1] == cur) j++; // 다음칸과 동일
            else if(Math.abs(map[n][j+1] - cur) >= 2) break; // 높이 2이상 차이
            else // 높이 1차이
            {
                int next_h = map[n][j+1];
                if(cur > next_h) // down
                {
                    if(j+L >= N) break;
                    int startPoint = j+1;

                    for(int idx = startPoint; idx < startPoint+L; ++idx)
                    {
                        if(map[n][idx] != next_h || isVis[n][idx]) return;
                        isVis[n][idx] = true;
                    }
                    j += L;
                    cur--;
                }
                else // up
                {
                    if(j-L+1 < 0) break;
                    for(int idx = j; idx > j-L; --idx)
                    {
                        if(map[n][idx] != cur || isVis[n][idx]) return;
                        isVis[n][idx] = true;
                    }
                    j++;
                    cur++;
                }
            }
        }
    }
    static void vertical(int n, int h)
    {
        int i = 0;
        int cur = h;
        while(true)
        {
            if(i == N-1)
            {
                answer++;
                break;
            }
            if(map[i+1][n] == cur) i++; // 다음칸과 동일
            else if(Math.abs(map[i+1][n] - cur) >= 2) break; // 높이 2이상 차이
            else // 높이 1차이
            {
                int next_h = map[i+1][n];
                if(cur > next_h) // down
                {
                    if(i+L >= N) break;
                    int startPoint = i+1;

                    for(int idx = startPoint; idx < startPoint+L; ++idx)
                    {
                        if(map[idx][n] != next_h || isVis[idx][n]) return;
                        isVis[idx][n] = true;
                    }
                    i += L;
                    cur--;
                }
                else // up
                {
                    if(i-L+1 < 0) break;
                    for(int idx = i; idx > i-L; --idx)
                    {
                        if(map[idx][n] != cur || isVis[idx][n]) return;
                        isVis[idx][n] = true;
                    }
                    i++;
                    cur++;
                }
            }
        }
    }
}
