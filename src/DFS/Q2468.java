package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2468 {
    static int [][] map;
    static boolean [][] isVis;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        StringTokenizer st;
        map = new int[size][size];

        for(int i = 0; i < size; ++i)
        {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < size; ++j)
            {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }


    }
}
