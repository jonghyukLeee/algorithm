package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Q1932 {
    static int [][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        for(int i = 0; i < n; ++i)
        {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j <= i; ++j)
            {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(i > 0)
                {
                    if(j == 0)
                    {
                        map[i][j] += map[i-1][j];
                    }
                    else if(j == i)
                    {
                        map[i][j] += map[i-1][j-1];
                    }
                    else
                    {
                        map[i][j] += Math.max(map[i-1][j-1],map[i-1][j]);
                    }
                }
            }
        }

        ArrayList<Integer> al = new ArrayList<>();
        for(int i = 0; i < n; ++i)
        {
            al.add(map[n-1][i]);
        }

        al.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });

        System.out.print(al.get(0));
    }
}
