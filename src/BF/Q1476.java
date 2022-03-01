package BF;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1476 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int E = Integer.parseInt(st.nextToken()); // 15
        int S = Integer.parseInt(st.nextToken()); // 28
        int M = Integer.parseInt(st.nextToken()); // 19

        int year = 1;
        int e = 1,s = 1,m = 1;
        while(e != E || s != S || m != M)
        {
            e++;
            s++;
            m++;
            if(e > 15) e = 1;
            if(s > 28) s = 1;
            if(m > 19) m = 1;
            year++;
        }
        System.out.println(year);
    }
}
