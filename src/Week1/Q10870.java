package Week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q10870 {
    static int fibo(int n)
    {
        if(n < 1) return 0;
        if(n == 1) return 1;
        return fibo(n-2)+fibo(n-1);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        System.out.print(fibo(n));
    }
}
