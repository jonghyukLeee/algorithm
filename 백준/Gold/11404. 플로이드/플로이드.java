import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static final int INF = 100000001;
    static int n;
    static int [][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        map = new int[n+1][n+1];

        for(int i = 1; i <= n; ++i)
        {
            for(int j = 1; j <= n; ++j)
            {
                map[i][j] = INF;
                if(i == j) map[i][j] = 0;
            }
        }
        for(int i = 0; i < m; ++i)
        {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            map[start][end] = Math.min(map[start][end],cost);
        }

        for(int i = 1; i <= n; ++i) // 플로이드 와샬
        {
            for(int j = 1; j <= n; ++j)
            {
                for(int k = 1; k <=n; ++k)
                {
                    if(map[j][k] > map[j][i] + map[i][k])
                    {
                        map[j][k] = map[j][i] + map[i][k];
                    }
                }
            }
        }

        for(int i = 1; i <=n; ++i)
        {
            for(int j = 1; j <=n; ++j)
            {
                if(map[i][j] == INF)
                {
                    System.out.print("0 ");
                    continue;
                }
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
    }

}
