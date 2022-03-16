package twopointers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Q1644 {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        //N이 1일때
        if(N == 1)
        {
            System.out.print("0");
            return;
        }

        //에라토스테네스의 체
        boolean [] notPrime = new boolean[N+1];
        for(int i = 2; i*i <= N; ++i)
        {
            if(!notPrime[i])
            {
                for(int j = i*i; j <= N; j+=i)
                {
                    notPrime[j] = true;
                }
            }
        }

        List<Integer> primeList = new ArrayList<>();
        for(int i = 2; i <= N; ++i)
        {
            if(!notPrime[i]) primeList.add(i);
        }

        int size = primeList.size();
        int e = 0;
        int sum = primeList.get(0);
        int res = 0;
        for (int start : primeList)
        {
            while (e < size && sum < N)
            {
                e++;
                if(e != size) sum += primeList.get(e);
            }
            if (e == size) break;
            if (sum == N) res++;
            sum -= start;
        }
        System.out.print(res);
    }
}
