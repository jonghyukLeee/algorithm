package First.Week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q2447 {
    static StringBuilder sb;
    static void printStar(int i, int j, int num)
    {
        if((i/num)%3 == 1 && (j/num)%3 == 1)
        {
            sb.append(" ");
        }
        else
        {
            if(num/3 == 0)
            {
                sb.append("*");
            }
            else
            {
                printStar(i,j,num/3);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; ++i)
        {
            for(int j = 0; j < n; ++j)
            {
                printStar(i,j,n);
            }
            sb.append("\n");
        }
        System.out.print(sb.toString());
    }
}
