package Review_30days.day1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q9093 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < t; ++i)
        {
            st = new StringTokenizer(br.readLine());
            while(st.hasMoreTokens())
            {
                String str = st.nextToken();
                int len = str.length();

                for (int k = len - 1; k >= 0; --k)
                {
                    sb.append(str.charAt(k));
                }
                sb.append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}
