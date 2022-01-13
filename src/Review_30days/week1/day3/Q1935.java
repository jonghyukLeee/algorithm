package Review_30days.week1.day3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Q1935 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int max = 65+N;
        char [] form = br.readLine().toCharArray();
        double [] values = new double[max-65];

        for(int i = 0; i < N; ++i) values[i] = Integer.parseInt(br.readLine());

        Stack<Double> s = new Stack<>();

        for(char cur : form)
        {
            if(cur >= 65 && cur < max) s.push(values[cur-65]);
            else
            {
                if(cur == '+')
                {
                    double sec = s.pop();
                    double fst = s.pop();

                    s.push(fst + sec);
                }
                else if(cur == '-')
                {
                    double sec = s.pop();
                    double fst = s.pop();
                    s.push(fst - sec);
                }
                else if(cur == '*')
                {
                    double sec = s.pop();
                    double fst = s.pop();
                    s.push(fst * sec);
                }
                else
                {
                    double sec = s.pop();
                    double fst = s.pop();
                    s.push(fst / sec);
                }
            }
        }

        System.out.printf("%.2f",s.pop());
    }
}
