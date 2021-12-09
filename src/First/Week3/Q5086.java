package First.Week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q5086 {
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();
        int tmp1 = 0, tmp2 = 0;
        while(true)
        {
            st = new StringTokenizer(br.readLine());
            tmp1 = Integer.parseInt(st.nextToken());
            tmp2 = Integer.parseInt(st.nextToken());
            if(tmp1 == 0 && tmp2 ==0) break;
            func(tmp1,tmp2);
        }
        System.out.print(sb.toString());
        br.close();
    }
    static void func(int x, int y)
    {
        if(y % x == 0)
        {
            sb.append("factor");
            sb.append("\n");
        }
        else if(x % y == 0)
        {
            sb.append("multiple");
            sb.append("\n");
        }
        else
        {
            sb.append("neither");
            sb.append("\n");
        }
    }
}
