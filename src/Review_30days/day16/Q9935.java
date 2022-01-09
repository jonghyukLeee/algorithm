package Review_30days.day16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Q9935 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String input = br.readLine();

        int str_len = str.length();
        int input_len = input.length();

        Stack<Character> s = new Stack<>();
        for(int i = 0; i < str_len; ++i)
        {
            char c = str.charAt(i);
            s.add(c);

            if(s.size() >= input_len)
            {
                boolean isSame = true;
                int s_size = s.size();
                for(int idx = 0; idx < input_len; ++idx)
                {
                    char c1 = s.get(s_size - input_len + idx);
                    char c2 = input.charAt(idx);

                    if(c1 != c2)
                    {
                        isSame = false;
                        break;
                    }
                }
                if(isSame)
                {
                    for(int j = 0; j < input_len; ++j) s.pop();
                }
            }
        }
        String answer = "FRULA";
        if(!s.isEmpty())
        {
            StringBuilder sb = new StringBuilder();
            for(char c : s) sb.append(c);
            answer = sb.toString();
        }
        System.out.print(answer);
    }
}
