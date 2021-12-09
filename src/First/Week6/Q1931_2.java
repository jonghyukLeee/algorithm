package First.Week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Q1931_2 {
    static int [][] time;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        time = new int[n][2];
        for(int i = 0; i < n; ++i)
        {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 2; ++j)
            {
                time[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        Arrays.sort(time, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1] == o2[1])
                {
                    return o1[0] - o2[0];
                }
                return o1[1] - o2[1];
            }
        });
        int tmp = 0, cnt = 0;
        for(int i = 0; i < n; ++i)
        {
            if(tmp <= time[i][0])
            {
                tmp = time[i][1];
                cnt++;
            }
        }
        System.out.print(cnt);
    }
}
