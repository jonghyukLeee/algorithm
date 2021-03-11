package Week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q15652 {
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
        func(0,1);
        System.out.print(sb.toString());
    }
    static void func(int cnt,int num)
    {
        if(cnt == m)
        {
            for(int i : arr)
            {
                sb.append(i);
                sb.append(" ");
            }
            sb.append("\n");
        }
        else
        {
            for(int i = num; i < n+1; ++i)
            {
                    arr[cnt] = i;
                    func(cnt+1,i);
            }
        }
    }
}
