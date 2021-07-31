package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Q11399 {
    static ArrayList<Integer> al;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        al = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < n; ++i)
        {
            al.add(Integer.parseInt(st.nextToken()));
        }

        al.sort(new Comparator<Integer>()
        {
            public int compare(Integer o1, Integer o2)
            {
                return o1-o2;
            }
        });

        int answer = al.get(0);
        for(int i = 1; i < al.size(); ++i)
        {
            al.set(i,al.get(i)+al.get(i-1));
            answer += al.get(i);
        }
        System.out.print(answer);
    }
}
