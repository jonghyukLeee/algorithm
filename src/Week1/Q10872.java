package Week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q10872 {
    static int res;
    static void factorial(int n)
    {
        if(n < 1) return;
        res *= n;
        factorial(n-1);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        res = 1;
        int n = Integer.parseInt(br.readLine());
        factorial(n);
        System.out.print(res);
    }
}
