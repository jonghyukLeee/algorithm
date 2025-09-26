import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int [] dp,map;
    static int max_value = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        dp = new int[N];
        map = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; ++i)
        {
            int cur = Integer.parseInt(st.nextToken());
            map[i] = cur;
            dp[i] = cur;
            int tmp = 0;
            for(int j = 0; j < i; ++j)
            {
                if(cur > map[j])
                {
                    tmp = Math.max(tmp,dp[j]);
                }
            }
            dp[i] += tmp;
            max_value = Math.max(max_value,dp[i]);
        }
        System.out.print(max_value);
    }
}
