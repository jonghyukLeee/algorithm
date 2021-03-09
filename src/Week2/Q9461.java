package Week2;

import java.io.*;
import java.util.ArrayList;

public class Q9461 {
    static long [] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        int max = Integer.MIN_VALUE;
        ArrayList<Integer> al = new ArrayList<>();
        for(int i = 0; i < t; ++i)
        {
            int tmp = Integer.parseInt(br.readLine());
            al.add(tmp);
            if(tmp > max) max = tmp;
        }
        arr = new long[100];
        arr[0] = 1; arr[1] =1; arr[2] = 1; arr[3] =2; arr[4] = 2;
        if(max > 4)
        {
            for(int i = 5; i < max; ++i)
            {
                arr[i] = arr[i-5] + arr[i-1];
            }
        }
        for(Integer i : al)
        {
            sb.append(arr[i-1]);
            sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
