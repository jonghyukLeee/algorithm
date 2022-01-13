package Review_30days.week1.day1;

import java.io.*;

public class Q9012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < t; ++i)
        {
            String [] tmp_arr = br.readLine().split("");
            int left = 0,right = 0;
            for(String s : tmp_arr)
            {
                if(s.equals("(")) left++;
                else right++;
                if(left < right) break;
            }
            if(left == right) bw.write("YES\n");
            else bw.write("NO\n");
        }
        bw.flush();
        bw.close();
    }
}
