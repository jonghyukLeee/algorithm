package First.Week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q17298 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int [] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; ++i)
        {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < n; ++i)
        {
            for(int j = i; j < n; ++j)
            {
                if(arr[i] < arr[j])
                {
                    sb.append(arr[j]);
                    sb.append(" ");
                    break;
                }
                if(j == n-1)
                {
                    sb.append(-1);
                    sb.append(" ");
                }
            }
        }
        System.out.print(sb.toString());
        br.close();
    }
}
