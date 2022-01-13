package Review_30days.week3.day19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q2110 {
    static int N,C;
    static int [] h_point;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        h_point = new int[N];
        for(int i = 0; i < N; ++i)
        {
            h_point[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(h_point);

        int left = 1; //최소 간격
        int right = h_point[N-1] - h_point[0]; //최대 간격

        while(left <= right)
        {
            int mid = (left + right) / 2;

            if(set(mid) >= C) left = mid+1;
            else right = mid-1;
        }
        System.out.print(left-1);
    }
    static int set(int dist)
    {
        int cur = h_point[0];
        int cnt = 1;
        for(int i = 1; i < N; ++i)
        {
            if((h_point[i] - cur) >= dist)
            {
                cur = h_point[i];
                cnt++;
            }
        }
        return cnt;
    }
}
