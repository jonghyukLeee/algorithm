package Week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Q2108 {
    static ArrayList<Integer> al;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        al = new ArrayList<>();
        for(int i = 0; i < t; ++i)
        {
            al.add(Integer.parseInt(br.readLine()));
        }
        for(int i = 1; i < 5; ++i)
        {
            System.out.println(func(i));
        }
    }
    static int func(int i)
    {
        switch(i)
        {
            case 1: // 평균
            {
                int sum = 0;
                for(Integer tmp : al)
                {
                    sum += tmp;
                }
                return sum / al.size();
            }
            case 2: // 중앙
            {
                Collections.sort(al);
                return al.get(al.size()/2);
            }
            case 3: // 최빈
            {

            }
            case 4: // 최댓값 - 최솟값
            {

            }
            default: return -1;
        }
    }
}
