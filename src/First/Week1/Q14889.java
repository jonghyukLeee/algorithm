package First.Week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q14889 {
    static int [][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        for(int i = 0; i < n; ++i)
        {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; ++j)
            {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        } // set arr

    }
}
