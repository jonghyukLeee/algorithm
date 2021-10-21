package Etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Q13458 {
    static int N;
    static long answer;
    static List<Integer> map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        answer = N;
        StringTokenizer st;
        map = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; ++i) map.add(Integer.parseInt(st.nextToken()));

        st = new StringTokenizer(br.readLine());
        int fst = Integer.parseInt(st.nextToken());
        int sec = Integer.parseInt(st.nextToken());

        for(int student : map)
        {
            int n = student-fst;
            if(n > 0)
            {
                if(n % sec == 0) answer += n / sec;
                else answer += (n / sec) + 1;
            }
        }
        System.out.print(answer);
    }
}
