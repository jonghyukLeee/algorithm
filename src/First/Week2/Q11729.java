package First.Week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q11729 {
    static StringBuilder sb;
    static int cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        cnt = 0;
        int n = Integer.parseInt(br.readLine());
        hTower(n,1,2,3);
        sb.insert(0,cnt+"\n");
        System.out.print(sb.toString());
    }
    static void hTower(int n,int from,int by, int to)
    {
        cnt++;
        if(n == 1)
        {
            sb.append(stamp(from,to));
        }
        else
        {
            hTower(n-1,from,to,by);
            sb.append(stamp(from,to));
            hTower(n-1,by,from,to);

        }
    }
    static String stamp(int from, int to)
    {
        return from+" "+to+"\n";
    }
}
