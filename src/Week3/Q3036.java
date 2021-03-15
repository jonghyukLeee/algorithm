package Week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q3036 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int first = Integer.parseInt(st.nextToken());
        int tmp = 0;
        int div = 0;
        for(int i = 0; i < n-1; ++i)
        {
            tmp = Integer.parseInt(st.nextToken());
            div = gcd(first,tmp);
            sb.append(first/div);
            sb.append("/");
            sb.append(tmp/div);
            sb.append("\n");
        } // end
        System.out.print(sb.toString());
    }
    static int gcd(int x, int y)
    {
        int z = 0;
        while(y != 0)
        {
            z = x % y;
            x = y;
            y = z;
        }
        return x;
    }
}
