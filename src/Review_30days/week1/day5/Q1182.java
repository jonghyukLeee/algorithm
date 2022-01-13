package Review_30days.week1.day5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1182 {
    static int N,S,answer;
    static int [] num;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        num = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; ++i) num[i] = Integer.parseInt(st.nextToken());

        if(N == 1)
        {
            System.out.print(num[0] == S ? 1 : 0);
            return;
        }
        for(int i = 0; i < N; ++i)
        {
            int tmp_sum = num[i];
            if(tmp_sum == S) answer++;
            for(int j = i+1; j < N; ++j)
            {
                sum(tmp_sum+num[j],j+1);
            }
        }
        System.out.print(answer);
    }
    static void sum(int sum,int idx)
    {
        if(sum == S)
        {
            answer++;
        }
        for(int i = idx; i < N; ++i)
        {
            sum(sum+num[i],i+1);
        }
    }
}
