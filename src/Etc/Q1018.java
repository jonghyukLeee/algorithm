package Etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1018 {
    static boolean [][] map;
    static int cnt = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        map = new boolean[n][m];

        for(int i = 0; i < n; ++i)
        {
            String tmpStr = br.readLine(); //wbwbwbwbwb
            for(int j = 0; j < m; ++j)
            {
                if(tmpStr.charAt(j) == 'W') map[i][j] = true;
            }
        }

        for(int i = 0; i < n; ++i)
        {
            paint(i);
        }

        for(boolean [] i : map)
        {
            for(boolean j : i)
            {
                if(j) System.out.print("W");
                else System.out.print("B");
            }
            System.out.println();
        }
        System.out.print(cnt);
    }
    static void paint(int row)
    {
        boolean cur = map[row][0];

            if(row > 0)
            {
                if(cur)
                {
                    if(map[row-1][0])
                    {
                        map[row][0] = false;
                        cnt++;
                    }
                }
                else
                {
                    if(!map[row-1][0])
                    {
                        map[row][0] = true;
                        cnt++;
                    }
                }
                cur = map[row][0];
            }

        for(int i = 0; i < map[0].length-1; ++i)
        {
            if(cur)
            {
                if(map[row][i+1])
                {
                    map[row][i+1] = false;
                    cnt++;
                }
            }
            else
            {
                if(!map[row][i+1])
                {
                    map[row][i+1] = true;
                    cnt++;
                }
            }
            cur = !cur;
        }
    }
}
