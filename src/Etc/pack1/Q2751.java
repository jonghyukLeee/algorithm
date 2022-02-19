package Etc.pack1;

import java.io.*;

public class Q2751 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        boolean [] arr = new boolean[2000001];

        for(int i = 0; i < N; ++i)
        {
            arr[Integer.parseInt(br.readLine())+1000000] = true;
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int i = 0; i <= 2000000; ++i)
        {
            if(arr[i])
            {
                bw.write((i-1000000)+"\n");
            }
        }

        bw.flush();
        bw.close();
    }
}
