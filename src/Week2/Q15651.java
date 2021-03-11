package Week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q15651 {
    static int [] arr;
    static int m,n;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[m];
        func(0);
        System.out.print(sb.toString());
    }
    static void func(int cnt)
    {
        if(cnt == m)
        {
            for(int i : arr)
            {
                sb.append(i);
                sb.append(" ");
            }
            sb.append("\n");
            return;
        }
        else
        {
            for(int i = 1; i < n+1; ++i)
            {
                    arr[cnt] = i;
                    func(cnt+1);
            }
        }
    }
}