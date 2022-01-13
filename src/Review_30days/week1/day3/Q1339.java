package Review_30days.week1.day3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q1339 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String [] arr = new String[N];

        for(int i = 0; i < N; ++i)
        {
            arr[i] = br.readLine();
        }

        int [] res = new int[26];
        for(String s : arr)
        {
            int start = s.length()-1;

            char [] tmp = s.toCharArray();
            for(char c : tmp)
            {
                res[c-65] += Math.pow(10,start--);
            }
        }

        Arrays.sort(res);
        int answer = 0;
        int tmp_num = 9;
        for(int i = 25; i >= 0; --i)
        {
            if(res[i] == 0) continue;
            answer += res[i] * tmp_num--;
        }
        System.out.print(answer);
    }
}
