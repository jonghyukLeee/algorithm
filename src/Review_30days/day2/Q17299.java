package Review_30days.day2;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Q17299 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int [] arr = new int[N];
        int [] cnt = new int[1000001];
        Stack<Integer> s = new Stack<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; ++i)
        {
            int n = Integer.parseInt(st.nextToken());
            arr[i] = n;
            cnt[n]++;
        }

        for(int i = 0; i < N; ++i)
        {
            int cur_cnt = cnt[arr[i]];
            while(!s.isEmpty() && cur_cnt > cnt[arr[s.peek()]])
            {
                arr[s.pop()] = arr[i];
            }
            s.push(i);
        }

        while(!s.isEmpty()) arr[s.pop()] = -1;

        for(int i : arr) bw.write(i+" ");
        bw.flush();
        bw.close();
    }
}
