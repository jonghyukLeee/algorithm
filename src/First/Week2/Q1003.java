package First.Week2;

import java.io.*;

class Fibo
{
    int cnt0,cnt1;
    public Fibo(int cnt0, int cnt1)
    {
        this.cnt0 = cnt0;
        this.cnt1 = cnt1;
    }
}
public class Q1003 {
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        int tc [] = new int[t];
        int max_v = Integer.MIN_VALUE;
        for(int i = 0; i < t; ++i)
        {
            tc[i] = Integer.parseInt(br.readLine());
            if(tc[i] > max_v) max_v = tc[i];
        }
        Fibo fibo [] = new Fibo[max_v+1];
        for(int i = 0; i <= max_v; ++i)
        {
            fibo[i] = new Fibo(0,0);
        }
        fibo[0].cnt0 = 1;
        fibo[1].cnt1 = 1;
        for(int i = 2; i <= max_v; ++i)
        {
            fibo[i].cnt0 = fibo[i-2].cnt0 + fibo[i-1].cnt0;
            fibo[i].cnt1 = fibo[i-2].cnt1 + fibo[i-1].cnt1;
        }
        for(int i = 0; i < tc.length; ++i)
        {
            sb.append(fibo[tc[i]].cnt0);
            sb.append(" ");
            sb.append(fibo[tc[i]].cnt1);
            sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
