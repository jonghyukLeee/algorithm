package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;

public class Q2217 {
    static ArrayList<Integer> al;
    static int answer = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        al = new ArrayList<>();

        for(int i = 0; i < n; ++i)
        {
            al.add(Integer.parseInt(br.readLine()));
        }

        al.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        int cnt = 0;
        for(Integer cur : al)
        {
            cnt++;
            int tmp = cur * cnt;
            if(tmp >= answer)
            {
                answer = tmp;
            }
        }

        System.out.print(answer);
    }
}
