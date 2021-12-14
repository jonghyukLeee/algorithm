package Basic.day2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q10799 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String [] str_arr = br.readLine().split("");

        String pre = "";
        int left = 0,answer = 0;
        for(String cur : str_arr)
        {
            if(cur.equals("(")) left++;
            else
            {
                left--;
                if(pre.equals("(")) answer+= left;
                else answer++;
            }
            pre = cur;
        }
        System.out.print(answer);
    }
}
