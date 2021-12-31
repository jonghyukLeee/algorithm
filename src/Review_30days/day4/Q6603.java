package Review_30days.day4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q6603 {
    static StringBuilder sb;
    static boolean [] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        sb = new StringBuilder();
        while(true)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            if(k == 0) break;

            int [] num = new int[k];
            for(int i = 0; i < k; ++i) num[i] = Integer.parseInt(st.nextToken());

            visited = new boolean[k];
            play(num,0,k,0);
            sb.append("\n");
        }
        System.out.print(sb);
    }
    static void play(int [] num, int idx,int k, int len)
    {
        if(len == 6)
        {
            for(int i = 0; i < k; ++i)
            {
                if(visited[i]) sb.append(num[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i = idx; i < k; ++i)
        {
            visited[i] = true;
            play(num,i+1,k,len+1);
            visited[i] = false;
        }
    }
}
