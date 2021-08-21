package BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q1654 {
    static long n;
    static long [] cables;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        cables = new long[k];
        for(int i = 0; i < k; ++i)
        {
            cables[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(cables);
        System.out.print(binarySearch(1,cables[cables.length-1]));

    }
    static long binarySearch(long start, long end)
    {
        long mid, tot;
        while(start <= end)
        {
            mid = (start + end) / 2;
            tot = 0;
            for(long i : cables)
            {
                    tot += i / mid;
            }
            if(tot >= n) start = mid + 1;
            else
            {
                end = mid -1;
            }
        }
        return end;
    }
}
