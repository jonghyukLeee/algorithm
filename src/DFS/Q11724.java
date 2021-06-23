package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Q11724 {
    static int [] parents;
    static int [][] input;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        parents = new int[Integer.parseInt(st.nextToken())+1];
        for(int i = 1; i < parents.length; ++i)
        {
            parents[i] = i;
        }
        int t = Integer.parseInt(st.nextToken());
        input = new int[t][2];
        for(int i = 0; i < t; ++i)
        {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 2; ++j)
            {
                input[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        Arrays.sort(input, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });

        for(int i = 0; i < input.length; ++i)
        {
            int fst = input[i][0];
            int sec = input[i][1];

            parents[sec] = getParent(fst);
        }
        int cnt = 0;
        for(int i = 1; i < parents.length; ++i)
        {
            if(i == parents[i]) cnt++;
        }
        System.out.print(cnt);
    }
    static int getParent(int child)
    {
        if(parents[child] == child) return child;
        return getParent(parents[child]);
    }
}
