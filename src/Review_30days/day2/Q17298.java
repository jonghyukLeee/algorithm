package Review_30days.day2;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Q17298 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int [] arr = new int[N];
        Stack<Integer> s = new Stack<>();

        for(int i = 0; i < N; ++i) arr[i] = Integer.parseInt(st.nextToken());

        for(int i = 0; i < N; ++i)
        {
            while(!s.isEmpty() && arr[s.peek()] < arr[i])
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
