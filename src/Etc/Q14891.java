package Etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Q14891 {
    static ArrayList<Boolean> [] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String tmp_str;
        map = new ArrayList[5];
        for(int i = 0; i < 5; ++i) map[i] = new ArrayList<>();

        boolean tmp_bool;
        for(int i = 1; i < 5; ++i)
        {
            tmp_str = br.readLine();

            for(int j = 0; j < 8; ++j)
            {
                tmp_bool = tmp_str.charAt(j) > 0;
                map[i].add(tmp_bool);
            }
        }

        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int num,dir;
        for(int i = 0; i < t; ++i)
        {
            st = new StringTokenizer(br.readLine());
            num = Integer.parseInt(st.nextToken());
            dir = Integer.parseInt(st.nextToken());
            rotate(num,dir);
        }
    }
    static void rotate(int num, int dir)
    {
        if(dir == 1) // 시계
        {

        }
        else //반시계
        {

        }
    }
}
