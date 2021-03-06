package Week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q15649 {
    static int arr[];
    static boolean isVisited[];
    static StringBuilder sb = new StringBuilder();
    static void dfs(int n, int m,int d)
    {
        if(m == d)
        {
            for(int i : arr)
            {
                sb.append(i+" ");
            }
            sb.append("\n");
            return;
        }
        for(int i = 0; i < n; ++i)
        {
            if(!isVisited[i])
            {
                isVisited[i] = true;
                arr[d] = i+1;
                dfs(n,m,d+1);
                isVisited[i] = false;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        arr = new int[m];
        isVisited = new boolean[n];
        dfs(n,m,0);
        System.out.print(sb);
    }
}
