package Week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2609 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        System.out.printf("%d\n%d",gcd(x,y),lcm(x,y));
    }
    static int gcd(int x, int y)
    {
        int z;
        while(y != 0)
        {
            z = x % y;
            x = y;
            y = z;
        }
        return x;
    }
    static int lcm(int x, int y)
    {
        return x*y/gcd(x,y);
    }
}
