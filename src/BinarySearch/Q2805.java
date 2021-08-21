package BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q2805 {
    static long [] trees;
    static int m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 나무의 갯수
        m = Integer.parseInt(st.nextToken()); // 필요한 길이

        trees = new long[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; ++i)
        {
            trees[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(trees); //4 26 40 42 46

        System.out.print(search(0,(int)trees[trees.length-1]));
    }
    static int search(int start,int end)
    {
        int height,res = 0;
        long tot;

        while(start <= end)
        {
            height = (start + end) / 2;
            tot = 0;
            for(long tree : trees)
            {
                if(tree > height) tot += tree - height;
            }
            if(tot < m) end = height-1;
            else
            {
                start = height +1;
                res = height;
            }
        }
        return res;
    }

}
