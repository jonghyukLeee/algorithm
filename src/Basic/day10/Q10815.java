package Basic.day10;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q10815 {
    static int N,M;
    static int [] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        map = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; ++i) map[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(map);
        M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; ++i)
        {
            int next = Integer.parseInt(st.nextToken());
            bw.write(find(next)+" ");
        }
        bw.flush();
        bw.close();
    }
    static int find(int n)
    {
        int start = 0;
        int mid = 0;
        int end = N-1;

        while(start <= end)
        {
            mid = (start + end) / 2;
            if(map[mid] > n)
            {
                end = mid - 1;
            }
            else if(map[mid] < n) start = mid + 1;
            else return 1;
        }
        return 0;
    }
}
