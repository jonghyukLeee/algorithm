package Week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class Q2108 {
    static ArrayList<Integer> al;
    static HashMap<Integer,Integer> hm;
    static int min,max;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        al = new ArrayList<>();
        hm = new HashMap<>();
        for(int i = 0; i < t; ++i)
        {
            int tmp = Integer.parseInt(br.readLine());
            al.add(tmp);

            try{    // if랑 속도비교 해보기
                hm.replace(tmp,hm.get(tmp)+1);
            }catch(NullPointerException e)
            {
                hm.put(tmp,0);
            }
        }
        Collections.sort(al,Collections.reverseOrder());

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
                return al.get(al.size()/2);
            }
            case 3: // 최빈
            {

            }
            case 4: // 최댓값 - 최솟값
            {
                return Collections.max(al) - Collections.min(al);
            }
            default: return -1;
        }
    }
}
