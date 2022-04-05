package Etc.pack1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1316 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int cnt = 0;

        loop : for(int i = 0; i < N; i++)
        {
            char[] input = br.readLine().toCharArray();

            boolean [] visited = new boolean[26];
            int before = 26;
            for(char next : input)
            {
                int cur = next - 97;
                if(before == cur) continue;
                if(visited[cur]) continue loop;
                visited[cur] = true;
                before = cur;
            }
            cnt++;
        }
        System.out.print(cnt);
    }
}
