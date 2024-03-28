import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int [] arr1;
    static int [] arr2;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        arr1 = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; ++i)
        {
            arr1[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr1);
        int m = Integer.parseInt(br.readLine());
        arr2 = new int[m];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < m; ++i)
        {
            func(Integer.parseInt(st.nextToken()),0,n-1);
        }
        System.out.print(sb.toString());
    }
    static void func(int n, int start,int end)
    {
        int pv = 0;
        while(start <= end)
        {
            pv = (start+end) / 2;
            if(arr1[pv] == n)
            {
                sb.append("1\n");
                return;
            }
            else
            {
                if(arr1[pv] > n)
                {
                    end = pv-1;
                }
                else
                {
                    start = pv+1;
                }
            }
        } // end loop
        sb.append("0\n");
    }
}
