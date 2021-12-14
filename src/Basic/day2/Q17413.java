package Basic.day2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q17413 {
    static String [] str_arr;
    static int size;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str_arr = br.readLine().split("");
        size = str_arr.length;
        sb = new StringBuilder();
        for(int i = 0; i < size; ++i)
        {
            String cur = str_arr[i];

            if(cur.equals("<"))
            {
                int tmp_end = i;
                for(int j = i+1; j < size; ++j)
                {
                    if(str_arr[j].equals(">"))
                    {
                        tmp_end = j;
                        break;
                    }
                }
                add(i,tmp_end);
                i = tmp_end;
            }
            else if(cur.equals(" ")) sb.append(" ");
            else
            {
                int tmp_end = i;
                for(int j = i+1; j < size; ++j)
                {
                    if(str_arr[j].equals(" ") || str_arr[j].equals("<"))
                    {
                        tmp_end = j-1;
                        break;
                    }
                    else if(j == size - 1) tmp_end = j;
                }
                reverse(i,tmp_end);
                i = tmp_end;
            }
        }
        System.out.print(sb.toString().trim());
    }
    static void add(int start, int end)
    {
        for(int i = start; i <= end; ++i) sb.append(str_arr[i]);
    }
    static void reverse(int start, int end)
    {
        for(int i = end; i >= start; --i) sb.append(str_arr[i]);
    }
}
