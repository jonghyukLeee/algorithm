package First.Week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q10989 {
    static int [] cntArr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        cntArr = new int[100001];
        for(int i = 0; i < t; ++i)
        {
            cntArr[Integer.parseInt(br.readLine())]++;
        }
        for(int i = 1; i < 10001; ++i)
        {
            while(cntArr[i] > 0)
            {
                sb.append(i).append("\n");
                cntArr[i]--;
            }
        }
        System.out.print(sb.toString());
    }
}
