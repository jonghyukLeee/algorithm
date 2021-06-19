package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Q2667 {
    static int apart;
    static int [][] map;
    static int [] arr;
    static boolean [][] isVis;
    static int [] dx = {0,0,1,-1};
    static int [] dy = {1,-1,0,0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        String tmpStr;
        arr = new int[10000];
        apart = 0;
        ArrayList<Integer> al = new ArrayList<>();
        map = new int[size][size];
        isVis = new boolean[size][size];
        for(int i = 0; i < size; ++i)
        {
            tmpStr = br.readLine();
            for(int j = 0; j < size; ++j)
            {
                map[i][j] = tmpStr.charAt(j)-'0';
                if(map[i][j] == 0) isVis[i][j] = true;
            }
        }

        for(int i = 0; i < size; ++i)
        {
            for(int j = 0; j < size; ++j)
            {
                if(!isVis[i][j] && map[i][j] == 1)
                {
                    apart++;
                }
            }
        }
        Arrays.sort(arr);
        System.out.println(apart);
        for(int i = 0; i < apart; ++i)
        {
            System.out.println(arr[i]);
        }
    }
    static void dfs(int i, int j, int cnt)
    {
        for(int idx = 0; idx < 4; ++idx)
        {
            int x = i + dx[idx];
            int y = j + dy[idx];

            if(!isValid(x,y)) continue;
            if(isVis[x][y]) continue;
            isVis[x][y] = true;
            arr[apart]++;
            dfs(x,y,cnt+1);
        }
    }
    static boolean isValid(int x, int y)
    {
        if(x < 0 || y < 0 || x >= map.length || y >= map[0].length) return false;
        else return true;
    }
}
