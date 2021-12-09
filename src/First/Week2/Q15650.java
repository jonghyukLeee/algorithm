package First.Week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q15650 {
    static int [] arr;
    static boolean [] isVisited;
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
        isVisited = new boolean[n+1];
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
            return;
        }
        else
        {
            for(int i = num; i < n+1; ++i)
            {
                if(!isVisited[i])
                {
                    arr[cnt] = i;
                    isVisited[i] = true;
                    func(cnt+1,i+1);
                    isVisited[i] = false;
                }
            }
        }
    }
}
