package Review_30days.week2.day11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q1026 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int [] a = new int[n];
        int [] b = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; ++i) a[i] = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; ++i) b[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(a);
        Arrays.sort(b);

        int answer = 0;
        for(int i = 0; i < n; ++i) answer += (a[i] * b[n-1-i]);
        System.out.print(answer);
    }
}
