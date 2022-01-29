package Etc.pack1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1717 {
    static int [] parents;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        parents = new int[n+1];
        for(int i = 0; i <= n; ++i) parents[i] = i; // 자기자신을 부모로 초기화

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < m; ++i)
        {
            st = new StringTokenizer(br.readLine());
            int cmd = Integer.parseInt(st.nextToken());
            int fst = Integer.parseInt(st.nextToken());
            int sec = Integer.parseInt(st.nextToken());

            if(cmd > 0) sb.append(getParent(fst) == getParent(sec) ? "YES" : "NO").append("\n");
            else setParent(fst,sec);
        }
        System.out.print(sb);
    }
    static int getParent(int child)
    {
        if(parents[child] == child) return child;
        return getParent(parents[child]);
    }
    static void setParent(int fst, int sec)
    {
        int a = getParent(fst);
        int b = getParent(sec);

        if(a > b) parents[b] = a;
        else if(a < b) parents[a] = b;
    }
}
