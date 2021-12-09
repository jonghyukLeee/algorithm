package First.Week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Q10773 {
    static Stack<Integer> stk;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        stk = new Stack<>();
        int input;
        int t = Integer.parseInt(br.readLine());
        for(int i = 0; i < t; ++i)
        {
            input = Integer.parseInt(br.readLine());
            if(input == 0) stk.pop();
            else
            {
                stk.push(input);
            }
        }

        int res = 0;
        for (Integer i : stk)
        {
            res += i;
        }

        System.out.print(res);
        br.close();
    }
}
