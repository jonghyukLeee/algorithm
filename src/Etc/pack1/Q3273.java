package Etc.pack1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q3273 {
    static int N,X;
    static int [] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; ++i) map[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(map);
        X = Integer.parseInt(br.readLine());

        int answer = 0;
        for(int i = 0; i < N; ++i)
        {
            int next = map[i];
            if((X - next) < next) break;
            if(search(i,next)) answer++;
        }
        System.out.println(answer);
    }
    static boolean search(int idx, int cur)
    {
        int start = idx;
        int end = N-1;
        int sum = 0;
        while(start <= end)
        {
            int mid = (start + end) / 2;
            sum = cur + map[mid];

            if(sum <= X)
            {
                if(sum == X) return idx != mid;
                start = mid+1;
            }
            else end = mid-1;
        }
        return false;
    }
}
