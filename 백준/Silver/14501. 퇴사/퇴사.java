import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Counsel
{
    int time,cost;

    public Counsel(int time, int cost)
    {
        this.time = time;
        this.cost = cost;
    }
}
public class Main {
    static Counsel [] counsel;
    static int [] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        counsel = new Counsel[N];
        dp = new int[N+1];
        StringTokenizer st;
        for(int i = 0; i < N; ++i)
        {
            st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            counsel[i] = new Counsel(time,cost);
        }

        for(int i = 0; i < N; ++i)
        {
            Counsel cur = counsel[i];
            int next = cur.time + i;

            if(next <= N)
            {
                dp[next] = Math.max((dp[i] + cur.cost),dp[next]);
            }
            dp[i+1] = Math.max(dp[i+1],dp[i]);
        }
        Arrays.sort(dp);
        System.out.print(dp[dp.length-1]);
    }
}
