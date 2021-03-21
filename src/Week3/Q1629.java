package Week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1629 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long a = Integer.parseInt(st.nextToken());
        long b = Integer.parseInt(st.nextToken());
        long c = Integer.parseInt(st.nextToken());
        System.out.print(func(a,b,c)%c);
    }
    static long func(long a, long b, long c)
    {
        long tmp = b/2;
        if(b == 0) return a%c;
        else if(b % 2 == 0) return (func(a,tmp,c) * func(a,tmp,c))%c;
        else return (func(a,tmp,c) * func(a,tmp,c) * a)%c;
    }
}
