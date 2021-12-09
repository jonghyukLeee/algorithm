package First.Week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q2606 {
    static boolean [][] virus;
    static boolean [] isVis;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int cnt = 0;
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        virus = new boolean[n+1][n+1];
        isVis = new boolean[n+1];

        int x,y;
        while(m-- > 0)
        {
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            virus[x][y] = true;
            virus[y][x] = true;
        }

        //bfs

        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        isVis[1] = true;
        while(!q.isEmpty())
        {
            int tmp = q.poll();
            for(int i = 1; i < n+1; ++i)
            {
                if(tmp == i) continue;
                if(virus[tmp][i] && !isVis[i])
                {
                    cnt++;
                    q.add(i);
                    isVis[i] = true;
                }
            }
        }//end of loop
        System.out.print(cnt);
    }
}
